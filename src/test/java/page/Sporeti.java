package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Sporeti extends BaseTest {

    public Sporeti() {
        PageFactory.initElements(driver,this);

    }

    @FindBy (xpath = "//span[text() ='Električni šporeti']")
     WebElement elektricniSporeti;


     public void elektricniSporetiClick() {
         wdWait.until(ExpectedConditions.elementToBeClickable(elektricniSporeti)).click();
 //        actions.click(elektricniSporeti).perform();



            }




}
