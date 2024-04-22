package utilities;

import browsers.DriverProvider;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.Reporter;
import report.ReportFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class BaseUtil {

    private BaseObjects base = new BaseObjects();

    public String getTestNGParameter(String KEY) {
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(KEY);
    }

    public String CurrentDate_Time() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());

    }


    public String takePageScreenshotBase64(WebDriver driver, String testCaseName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhh_mmss").format(new Date());
        String path = System.getProperty("user.dir");
        String destination = path + "/Screenshots/" + testCaseName + dateName + ".jpg";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(destination));
        byte[] imageByte = IOUtils.toByteArray(new FileInputStream(destination));
        return Base64.getEncoder().encodeToString(imageByte);
    }


    public String takeScreenshotOfParticularSectionOrElementBase64(WebElement element) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhh_mmss").format(new Date());
        String path = System.getProperty("user.dir");
        String destination = path + "/Screenshots/" + dateName + ".jpg";
        File elementShot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementShot, new File(destination));
        byte[] imageByte = IOUtils.toByteArray(new FileInputStream(destination));
        return Base64.getEncoder().encodeToString(imageByte);
    }


    public void highlightElement(WebElement element) throws InterruptedException {
        int yPosition = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) DriverProvider.getInstance().getDriver();
        js.executeScript("window.scroll (0, " + yPosition + ") ");
        Thread.sleep(2000);
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }


    public void verifyCurrentUrl(WebDriver driver, String URL, String errorMessage) {
        String currentUrl = driver.getCurrentUrl();
        try {
            Assert.assertEquals(currentUrl, URL, errorMessage);
            ReportFactory.getInstance().getLogger().log(Status.PASS, "Current URL" + currentUrl + " Verified Successfully");
        } catch (AssertionError e) {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, "Current URL" + currentUrl + " not matching with expected " + URL);
            throw new AssertionError(e);
        }
    }

    public void verifyCurrentUrlContains(WebDriver driver, String URL, String errorMessage) {
        String currentUrl = driver.getCurrentUrl();
        try {
            Assert.assertTrue(currentUrl.toLowerCase().contains(URL.toLowerCase()), errorMessage);
            ReportFactory.getInstance().getLogger().log(Status.PASS, "Current URL " + currentUrl + "contains expected " + URL);
        } catch (AssertionError e) {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, "Current URL " + currentUrl + " doesn't contain " + URL);
            throw new AssertionError(e);
        }
    }

    public String getCurrentUrlComponent(String currentURL, String component) throws MalformedURLException {
        String result;
        try {
            URL url = new URL(currentURL);
            switch (component.toLowerCase()) {
                case "protocol":
                    result = url.getProtocol();
                    break;
                case "host":
                    result = url.getHost();
                    break;
                case "query":
                    result = url.getQuery();
                    break;
                case "file":
                    result = url.getFile();
                    break;
                case "port":
                    result = String.valueOf(url.getDefaultPort());
                    break;
                default:
                    result = url.toString();
            }
            ReportFactory.getInstance().getLogger().log(Status.PASS, component + " from given URL is fetched "+ result);
        } catch (MalformedURLException e) {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, "Given String URL " + currentURL + " is malformed");
            throw e;
        }
        return result;
    }

    public WebDriver initiateBrowserAndLaunchURL(String url) throws Exception {
        WebDriver driver = base.browserInit().browser();
        driver.get(url);
        return driver;
    }


    public WebDriver initiateBrowser() throws Exception {
        return base.browserInit().browser();
    }


    public void launchURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public String readTestCaseInfo(String methodName) throws ClassNotFoundException {
        String mName = methodName.substring(methodName.lastIndexOf(".") + 1);
        String cName = methodName.replace(mName, "");
        cName = cName.substring(0, cName.lastIndexOf("."));
        cName = cName.substring(cName.indexOf(" ") + 1, cName.length());
        String testCaseId = "";
        String testCaseDescription = "";
        Class<?> aClass = Class.forName(cName);
        // Get the methods
        Method[] methods = aClass.getDeclaredMethods();
        // Loop through the methods and print out their names
        for (Method method : methods) {
            // System.out.println(method.getName());
            if ((method.isAnnotationPresent(TestCase.class))
                    && method.getName().equalsIgnoreCase(mName)) {
                testCaseId = method.getAnnotation(TestCase.class).testCaseId();
                testCaseDescription = method.getAnnotation(TestCase.class).testCaseDescription();
            }
        }
        System.out.println("class name " + testCaseDescription);
        return testCaseId;
    }

    public List<String> clickAndGetCurrentURLOfElements(String xpath) throws MalformedURLException {
        List<String> actualTextSequence = new ArrayList<>();
        List<WebElement> elementList = base.driverHelper().getElementsByXpath(xpath);
        for (int i = 0; i < elementList.size(); i++) {
            base.driverHelper().clickElement(elementList.get(i));
            actualTextSequence.add(base.baseUtil().getCurrentUrlComponent(base.driverHelper().getCurrentURL(),"file"));
            base.driverHelper().navigateBackOnBrowser();
            elementList = base.driverHelper().getElementsByXpath(xpath);
        }
        return actualTextSequence;
    }

    public void reportLogger(String expected, String actual, String message) {
        if (expected.equalsIgnoreCase(actual)) {
            ReportFactory.getInstance().getLogger().log(Status.PASS, message);
        } else {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, message);
        }
    }

    public void verifyElementPresent(WebElement element, String expected) {
        try {
            Assert.assertTrue(base.driverHelper().isElementPresent(element), expected);
            ReportFactory.getInstance().getLogger().log(Status.PASS, " ' " + expected + "' Found on Page");
        } catch (AssertionError e) {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, "' " + expected + " ' Not Found on Page");
            throw new AssertionError("Expected Element "+element +" Not Found on Page");
        }
    }

    public void verifyElementText(WebElement element, String expected) throws Exception {
        if (base.driverHelper().isElementPresent(element)) {
            String actualText = base.driverHelper().getText(element);
            reportLogger(expected, actualText, "Verification of Text '" + expected + "' is Successful");
            Assert.assertTrue(expected.equalsIgnoreCase(actualText), "Text not matching, Actual: "+actualText);
        } else {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, " ' " + element + "' Not Found");
            throw new Exception("Expected Element " + element + " Not Found");
        }
    }

    public void verifyListOfString(List<String> actual, List<String> expected, String component) {
        try {
            Assert.assertTrue(actual.equals(expected), component + " Actual Sequence matching with Expected " + expected);
            ReportFactory.getInstance().getLogger().log(Status.PASS, "Actual Sequence matching with Expected " + expected);
        } catch (Error e) {
            ReportFactory.getInstance().getLogger().log(Status.FAIL, "Actual Sequence " + actual + " Not matching with Expected " + expected);
            throw new AssertionError("Actual Sequence " + actual + " Not matching with Expected " + expected);
        }
    }

    public boolean isSortedInOrderFloat(List<Float> arr, boolean isAscending) {
        if (arr.isEmpty() || arr.size() == 1) {
            return true;
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            if (isAscending) {
                if (arr.get(i) > arr.get(i + 1)) {
                    return false;
                }
            } else {
                if (arr.get(i) < arr.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSortedInOrderInt(List<Integer> arr, boolean isAscending) {
        if (arr.isEmpty() || arr.size() == 1) {
            return true;
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            if (isAscending) {
                if (arr.get(i) > arr.get(i + 1)) {
                    return false;
                }
            } else {
                if (arr.get(i) < arr.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}