package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElektricniSporeti extends BaseTest {


    public ElektricniSporeti () {

        PageFactory.initElements(driver,this);
    }


    @FindBy (xpath  = "//label[text() ='Gorenje']")
    WebElement gorenjeClick;

    @FindBy (xpath = "//a[contains(text() , 'E5121WH ')]")
    WebElement E5121WHclick;

    @FindBy (xpath = "//label[text() = 'Beko']")
    WebElement bekoClick;


    @FindBy (xpath = "//a[@title='FSS66000W električni šporet']")
    WebElement prviBekoSporet;


    public void clickGorenjeCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(gorenjeClick)).click();
//        actions.moveToElement(gorenjeClick).perform();
//        gorenjeClick.click();
//         wdWait.until(ExpectedConditions.elementToBeClickable((gorenjeClick))).submit();

    }
    public void clickSporetE5121WH() {
        wdWait.until(ExpectedConditions.elementToBeClickable(E5121WHclick)).click();

    }
    public void clickBekoCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable((bekoClick))).click();
    }
    public void prviBekoSporetClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable((prviBekoSporet)));
        actions.moveToElement(prviBekoSporet).perform();
        prviBekoSporet.click();



    }
}
