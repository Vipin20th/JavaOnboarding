package report;

import com.aventstack.extentreports.ExtentTest;

public class ReportFactory {

    private ReportFactory() {

    }

    private static ReportFactory instance  = new ReportFactory();

    public static ReportFactory getInstance() {
        return instance;
    }

    //factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public ExtentTest getLogger() {
        return extentTest.get();
    }

    public void setLogger(ExtentTest extentTestObject) {
        extentTest.set(extentTestObject);
    }

    public void removeExtentObject() {
        extentTest.remove();
    }
}
