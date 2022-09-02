package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssertNovaStaraCena extends BaseTest {

    public AssertNovaStaraCena() {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".extra-discount-price.pull-left")
    WebElement novaCena;

    @FindBy(xpath = "//span[text() = '30.588 ']")
    WebElement staraCena;

    public boolean cenaNovaisDisplayed() {
        return novaCena.isDisplayed();

    }

    public boolean cenaStaraisDisplayed() {
        return staraCena.isDisplayed();
    }

    public String cenaNovagetText() {
        return novaCena.getText();
    }

    public String cenaStaragetText() {
        return staraCena.getText();
    }
    public void clickBack() {
        driver.navigate().back();
    }
}