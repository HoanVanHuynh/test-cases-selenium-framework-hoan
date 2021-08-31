package tests;

import common.Constants;
import helpers.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverHelper.initDriver();
        DriverHelper.navigate(Constants.URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.quit();
    }
}