package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RegistrationMessage extends BaseTest {

    public RegistrationMessage() {

        PageFactory.initElements(driver,this);
    }

    @FindBy( css = ".alert-success")
    WebElement registrationSuccessful;

    @FindBy ( css = ".alert-success")
    WebElement tekstUspesneRegistracije;

    @FindBy(css = ".am-opener")
    WebElement sviProizvodiMenu;

    @FindBy (xpath = "//a[text() ='Bela tehnika']")
    WebElement belaTehnika;

    @FindBy (xpath = "//a[text() = 'Šporeti']")
    WebElement sporetiCLick;
    public boolean isMessageDisplayed() {
        return registrationSuccessful.isDisplayed();

    }
    public String tekstPoruke() {
     return tekstUspesneRegistracije.getText();

    }
    public void sviProizvodiMenuHover() {
        wdWait.until(ExpectedConditions.elementToBeClickable(sviProizvodiMenu));
        actions.moveToElement(sviProizvodiMenu).perform();

    }

    public void belaTehnikaHover() {
        wdWait.until(ExpectedConditions.elementToBeClickable((belaTehnika)));
        actions.moveToElement(belaTehnika).perform();

    }
    public void clickSporeti () {
        wdWait.until(ExpectedConditions.elementToBeClickable(sporetiCLick)).click();
    }
}




