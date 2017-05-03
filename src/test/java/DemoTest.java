import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.DriverSupport;

public class DemoTest {
    private WebDriver driver;
    private Header header;
    private PlaceInfo placeInfo;
    private PlacePin placePin;
    private PlacePhotos placePhotos;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url) {
        driver = DriverSupport.initDriver(browser);
        driver.get(url);
        header = new Header(driver);
        placeInfo = new PlaceInfo(driver);
        placePin = new PlacePin(driver);
        placePhotos = new PlacePhotos(driver);
    }

    @Test(priority = 0)
    @Parameters({"searchInput", "placeName"})
    public void searchForPlace(String searchInput, String placeName) {

        driver.manage().window().setSize(new Dimension(2000, 3000));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        header.getSearchInput().sendKeys(searchInput);
        Assert.assertTrue(header.getSuggestion(placeName).isEnabled());

    }

    @Test(dependsOnMethods = {"searchForPlace"})
    @Parameters({"placeName"})
    public void openSuggestion(String placeName) {
        header.getSuggestion(placeName).click();
        Assert.assertEquals(placeInfo.getPlaceName().getText(), placeName);
    }

    @Test(dependsOnMethods = {"openSuggestion"})
    @Parameters({"address", "phoneNumber", "email"})
    public void checkPlaceInfo(String address, String phoneNumber, String email) {
        Assert.assertEquals(placeInfo.getAddress().getText(), address);
        Assert.assertEquals(placeInfo.getPhone().getText(), phoneNumber);
        Assert.assertEquals(placeInfo.getMailLink().getText(), email);
    }

    @Test(dependsOnMethods = {"checkPlaceInfo"})
    @Parameters({"placeName", "address", "phoneNumber", "webAddress"})
    public void checkPinInfo(String placeName, String address, String phoneNumber, String webAddress) {
        Assert.assertEquals(placePin.getPlaceName().getText(), placeName);
        Assert.assertEquals(placePin.getAddress().getText(), address);
        Assert.assertEquals(placePin.getPhoneNumber().getText(), phoneNumber);
        Assert.assertTrue(placePin.getWebAddress(webAddress).isDisplayed());
    }

    @Test(dependsOnMethods = {"checkPinInfo"})
    public void openPlacePhotos() {
        placeInfo.getProfileImage().click();
        Assert.assertTrue(placePhotos.checkCurrentPhotoNumber(1));
    }

    @Test(dependsOnMethods = {"openPlacePhotos"})
    public void listPhotos() {
        Integer numberOfPhotos = 10;

        for (Integer i = 2; i < numberOfPhotos; i++) {
            placePhotos.getNextButton().click();
            Assert.assertTrue(placePhotos.checkCurrentPhotoNumber(i), i.toString() + ". photo not loaded");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
