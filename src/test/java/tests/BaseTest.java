package tests;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.DriverUtils;
import com.logigear.helper.BrowserSettingHelper;
import common.Constants;
import helpers.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters("Browser")
    public void beforeMethod(@Optional("chrome.local") String browser) throws Exception {
        LogHelper.info("Before method");
        DriverProperty driverProperty = BrowserSettingHelper.getDriverProperty(Constants.BROWSER_SETTING_FILE, browser);
        DriverUtils.getDriver(driverProperty);
        DriverUtils.setTimeOut(Constants.TIME_WAIT);
        DriverUtils.navigate(Constants.URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.info("After method");
        DriverUtils.quitBrowser();
    }
}