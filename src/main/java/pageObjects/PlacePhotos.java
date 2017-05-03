package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPage;

public class PlacePhotos extends AbstractPage {

    public PlacePhotos(WebDriver driver) {
        super(driver);
        initElements();
    }

    @FindBy(id = "cboxNext")
    @CacheLookup
    private WebElement nextButton;

    @FindBy(id = "cboxCurrent")
    @CacheLookup
    private WebElement current;

    public WebElement getNextButton() {
        return nextButton;
    }

    public boolean checkCurrentPhotoNumber(Integer number) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        return wait.until(ExpectedConditions.textToBePresentInElement(current, "Slika " + number.toString() + " od 13"));
    }
}
