package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.*;

public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage;
    SharedMethods sharedMethods;
    RegistrationMessage registrationMessage;
    AssertNovaStaraCena assertNovaStaraCena;
    BekoBelaBoja bekoBelaBoja;
    ElektricniSporeti elektricniSporeti;
    Sporeti sporeti;

     //  @Before metode ne smeju da se zovu isto ( ona u base test
    @Before
    public void setUpTest() {
        registrationPage = new RegistrationPage();
        sharedMethods = new SharedMethods();
        registrationMessage = new RegistrationMessage();
        assertNovaStaraCena = new AssertNovaStaraCena();
        bekoBelaBoja = new BekoBelaBoja();
        elektricniSporeti = new ElektricniSporeti();
        sporeti = new Sporeti();
    }

    @Test
    public void SuccessfulRegistrationTest() throws InterruptedException  {
        sharedMethods.killAllPopupBanners();
        registrationPage.ImeInputFieldSendKeys("Marko");
        registrationPage.PrezimeInputFieldSendKeys("Maric");
        registrationPage.EmailInputField("mhppplcp@acdc.com");
        registrationPage.NewsLetterCheckbox();
        registrationPage.PasswordInputFieldSendKeys("Mario1899");
        registrationPage.ConfirmationInputFieldSendKeys("Mario1899");
        sharedMethods.acceptCookiesClick();
        registrationPage.RegistrationConfirmationClick();
        Assert.assertTrue(registrationMessage.isMessageDisplayed());
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.",registrationMessage.tekstPoruke());
    }

    @Test
    public void companySuccessfullRegistration() throws InterruptedException {
        sharedMethods.killAllPopupBanners();
        registrationPage.ImeInputFieldSendKeys("Marko");
        registrationPage.PrezimeInputFieldSendKeys("Maric");
        registrationPage.EmailInputField("niciave1@acdc.com");
        registrationPage.NewsLetterCheckbox();
        registrationPage.companySelect();
        registrationPage.companyInputFieldSendKeys("Krstic");
        registrationPage.pibInputFieldSendKeys("123456789");
        registrationPage.PasswordInputFieldSendKeys("Mario1899");
        registrationPage.ConfirmationInputFieldSendKeys("Mario1899");
        sharedMethods.acceptCookiesClick();
        registrationPage.RegistrationConfirmationClick();
        Assert.assertTrue(registrationMessage.isMessageDisplayed());
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.", registrationMessage.tekstPoruke());
    }
    @Test
    public void sporetiKarakondzulaTest() throws InterruptedException {
        sharedMethods.killAllPopupBanners();
        registrationPage.ImeInputFieldSendKeys("Marko");
        registrationPage.PrezimeInputFieldSendKeys("Maric");
        registrationPage.EmailInputField("mhppplcp@acdc.com");
        registrationPage.NewsLetterCheckbox();
        registrationPage.PasswordInputFieldSendKeys("Mario1899");
        registrationPage.ConfirmationInputFieldSendKeys("Mario1899");
        sharedMethods.acceptCookiesClick();
        registrationPage.RegistrationConfirmationClick();
        registrationMessage.sviProizvodiMenuHover();
        registrationMessage.belaTehnikaHover();
        registrationMessage.clickSporeti();
        sharedMethods.acceptCookiesClick();
        sporeti.elektricniSporetiClick();
        elektricniSporeti.clickGorenjeCheckbox();
        elektricniSporeti.clickSporetE5121WH();
        Assert.assertTrue(assertNovaStaraCena.cenaStaraisDisplayed());
        Assert.assertTrue(assertNovaStaraCena.cenaNovaisDisplayed());
        assertNovaStaraCena.clickBack();
        elektricniSporeti.clickGorenjeCheckbox();
        elektricniSporeti.clickBekoCheckbox();
        elektricniSporeti.prviBekoSporetClick();
        Assert.assertEquals("Bela",bekoBelaBoja.belaBojaGetText());
        bekoBelaBoja.clickOcene();
        Assert.assertTrue(bekoBelaBoja.isKomentarDisplayed());
        Assert.assertEquals("Kupili smo ovaj sporet za letnju kuhinju i jedini kriterijum je bio da bude sto jeftiniji." +
                " Videli smo ovaj model i posle razgovora sa prodavcem, shvatili smo da nema sta dalje da gledamo." +
                " Bekov sporet najobicniji, sa minimalno elektronike za 23 hiljade je smesno." +
                " Mi smo prezadovoljni jer smo prosli jeftinije nego sto smo mislili, a sporet za sada radi perfektno.",bekoBelaBoja.komentarCikaLjubeGetText());






    }
}
