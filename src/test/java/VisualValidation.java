import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.DriverSupport;

import java.io.File;
import java.io.IOException;

public class VisualValidation {
    private WebDriver driver;
    private Header header;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url) {
        driver = DriverSupport.initDriver(browser);
        driver.get(url);
        header = new Header(driver);
    }

    @Test(priority = 0)
    @Parameters({"searchInput", "placeName"})
    public void searchForPlace(String searchInput, String placeName) {
//        File newScreenShot = null;
//        try {
//            newScreenShot = DriverSupport.takeScreenshot();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        File refScreenShot = new File("/Users/Tarik/Desktop/screenshot.png");
//
//        // if no ref screenshot exists, current screenshot becomes referent
//        if (!refScreenShot.exists()) {
//            try {
//                FileUtils.copyFile(newScreenShot, refScreenShot);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        //compare screenshots
//        try {
//            DriverSupport.generatePdiff(refScreenShot, newScreenShot);
//            Assert.assertTrue(true);
//        } catch (Exception e) {
//            Assert.fail("Images do not match");
//        }

        header.getSearchInput().sendKeys(searchInput);
        Assert.assertTrue(header.getSuggestion(placeName).isDisplayed());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
