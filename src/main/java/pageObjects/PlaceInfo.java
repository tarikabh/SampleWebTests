package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPage;

public class PlaceInfo extends AbstractPage {

    public PlaceInfo(WebDriver driver) {
        super(driver);
        initElements();
    }

    @FindBy(className = "place-body")
    @CacheLookup
    private WebElement placeBody;

    @FindBy(className = "address")
    @CacheLookup
    private WebElement address;

    @FindBy(className = "phone-nmb")
    @CacheLookup
    private WebElement phone;

    @FindBy(className = "profile-image-link")
    @CacheLookup
    private WebElement profileImage;

    @FindBy(css = "a[href*='mailto:']")
    @CacheLookup
    private WebElement mailLink;

    public WebElement getPlaceName() {
        return placeBody.findElement(By.className("name"));
    }

    public WebElement getAddress() {
        return address.findElement(By.className("text"));
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getProfileImage() {
        return profileImage;
    }

    public WebElement getMailLink() {
        return mailLink;
    }
}
