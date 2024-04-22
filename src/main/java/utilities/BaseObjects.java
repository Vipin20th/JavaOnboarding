package utilities;

import browsers.BrowserInit;
import com.aventstack.extentreports.Status;
import report.ReportFactory;
import report.ReportGenerator;

public class BaseObjects {

    private DriverHelper driverhelper = null;

    public DriverHelper driverHelper() {
        if (driverhelper == null) {
            driverhelper = new DriverHelper();
        }
        return driverhelper;
    }

    private BaseUtil baseutil = null;

    public BaseUtil baseUtil() {
        if (baseutil == null) {
            baseutil = new BaseUtil();
        }
        return baseutil;
    }

    private PropertyClass property = null;

    public PropertyClass propertyClass() {
        if (property == null) {
            property = new PropertyClass();
        }
        return property;
    }

    private BrowserInit browser = null;

    public BrowserInit browserInit() {
        if (browser == null) {
            browser = new BrowserInit();
        }
        return browser;
    }

    private ReportGenerator report = null;

    public ReportGenerator reports() {
        if (report == null) {
            report = new ReportGenerator();
        }
        return report;
    }

    private DBConnection DB = null;

    public DBConnection dbConnection() {
        if (DB == null) {
            DB = new DBConnection();
        }
        return DB;
    }

    private CookieHelper cookie = null;

    public CookieHelper cookieHelper() {
        if (cookie == null) {
            cookie = new CookieHelper();
        }
        return cookie;
    }

    private NetworkHelper network = null;

    public NetworkHelper networkHelper() {
        if (network == null) {
            network = new NetworkHelper();
        }
        return network;
    }

    private EMailer mailer = null;

    public EMailer eMailer() {
        if (mailer == null) {
            mailer = new EMailer();
        }
        return mailer;
    }

    private ExcelUtil excelUtil = null;

    public ExcelUtil excel() {
        if (excelUtil == null) {
            excelUtil = new ExcelUtil();
        }
        return excelUtil;
    }

    private JSONUtil jsonUtils = null;

    public JSONUtil jsonUtil() {
        if (jsonUtils == null) {
            jsonUtils = new JSONUtil();
        }
        return jsonUtils;
    }
}
