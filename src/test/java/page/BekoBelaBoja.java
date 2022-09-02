package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BekoBelaBoja  extends BaseTest {

    public BekoBelaBoja() {

        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//td[@class='xl65' and text()='Bela']")
    WebElement belaBoja;

    @FindBy (xpath = " //a[text() = 'Ocene']  ")
    WebElement oceneClick;

    @FindBy (xpath = "//p[contains(text(),'Kupili smo')]")
    WebElement komentarCikaLjube;


    public String belaBojaGetText() {
        return belaBoja.getText();
    }
    public void clickOcene() {
        wdWait.until(ExpectedConditions.elementToBeClickable(oceneClick));
        actions.moveToElement(oceneClick).perform();
        oceneClick.click();
        }
    public boolean isKomentarDisplayed () {
      return komentarCikaLjube.isDisplayed();

        }
     public String komentarCikaLjubeGetText() {
        return komentarCikaLjube.getText();

     }
    }

