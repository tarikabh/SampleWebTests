package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPage;

public class Header extends AbstractPage {

    public Header(WebDriver driver) {
        super(driver);
        initElements();
    }

    @FindBy(className = "ember-text-field")
    @CacheLookup
    private WebElement searchInput;

    @FindBy(className = "tt-suggestions")
    private WebElement searchSuggestions;

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSuggestion(String suggestion) {
        return searchSuggestions.findElement(By.xpath(".//*[contains(text(), \"" + suggestion + "\")]"));
    }
}
