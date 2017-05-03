package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPage;

public class PlacePin extends AbstractPage {

    public PlacePin(WebDriver driver) {
        super(driver);
        initElements();
    }

    @FindBy(className = "leaflet-popup-content")
    @CacheLookup
    private WebElement pinContent;

    public WebElement getPlaceName() {
        return pinContent.findElement(By.className("name"));
    }

    public WebElement getAddress() {
        return pinContent.findElement(By.className("address"));
    }

    public WebElement getPhoneNumber() {
        return pinContent.findElement(By.className("phone"));
    }

    public WebElement getWebAddress(String webAddress) {
        return pinContent.findElement(By.linkText(webAddress));
    }
}
