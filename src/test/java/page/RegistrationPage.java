package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "firstname")
    WebElement imeInputField;
    @FindBy(id = "is_subscribed")
    WebElement newsLetterCheckbox;
    @FindBy (id = "lastname" )
    WebElement prezimeInputField;

    @FindBy (id = "email_address")
    WebElement emailInputField;
    @FindBy (id = "password")
    WebElement passwordInputField;

    @FindBy (id = "confirmation")
    WebElement confirmationInputField;



    @FindBy (xpath = "//span[contains(text(), 'Pošalji')]")
    WebElement registrationConfirmation;

   @FindBy (id = "pravnolice")
   WebElement selectCompany;

    @FindBy (id = "firma")
    WebElement companyName;

    @FindBy (id = "pib")
    WebElement poreskiBroj;


    public void ImeInputFieldSendKeys(String ime) {

        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys(ime);
    }
    public void PrezimeInputFieldSendKeys (String prezime) {
        wdWait.until(ExpectedConditions.visibilityOf(prezimeInputField)).clear();
        prezimeInputField.sendKeys(prezime);
    }

    public void NewsLetterCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(newsLetterCheckbox));
        if (newsLetterCheckbox.isSelected()) {
            newsLetterCheckbox.click();

        }
    }
     public void PasswordInputFieldSendKeys (String password) {
         wdWait.until(ExpectedConditions.visibilityOf(passwordInputField)).clear();
         passwordInputField.sendKeys(password);
        }
     public void ConfirmationInputFieldSendKeys (String repeatPassword) {
         wdWait.until(ExpectedConditions.visibilityOf(confirmationInputField)).clear();
         confirmationInputField.sendKeys(repeatPassword);
     }



     public void RegistrationConfirmationClick() {
         wdWait.until(ExpectedConditions.elementToBeClickable(registrationConfirmation)).submit();
         }
         public void EmailInputField (String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);

    }

    public void companySelect() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pravnolice")));
        dropdown = new Select(selectCompany);
        dropdown.selectByValue("1");

    }

    public void companyInputFieldSendKeys (String firma) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firma"))).clear();
        companyName.sendKeys(firma);

    }

    public void pibInputFieldSendKeys(String pib) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pib"))).clear();
        poreskiBroj.sendKeys(pib);


    }

}
