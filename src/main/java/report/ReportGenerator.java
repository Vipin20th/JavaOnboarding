package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import utilities.BaseObjects;



public class ReportGenerator {
    static ExtentReports extent;
    ExtentSparkReporter spark;
    private BaseObjects base = new BaseObjects();

    public ExtentReports config() {
        String ForDate = base.driverHelper().getCurrentDate("yyyy-MM-dd_HH:mm:ss z");
        String path = System.getProperty("user.dir");
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(path + "/Reports/TA_WebCores" + ForDate + ".html");
        spark.config().setReportName("WebCore");
        spark.config().setDocumentTitle("airtel");
        spark.config().setTheme(Theme.DARK);
        spark.viewConfigurer()
                .viewOrder()
                .as(new ViewName[]{
                        ViewName.DASHBOARD,
                        ViewName.TEST,
                        ViewName.AUTHOR,
                        ViewName.DEVICE,
                        ViewName.EXCEPTION,
                        ViewName.LOG
                })
                .apply();

        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
        extent.attachReporter(spark);
        return extent;
    }

    public void closeReport() {
        extent.flush();
    }

}
