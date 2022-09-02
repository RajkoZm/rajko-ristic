import io.github.bonigarcia.wdm.WebDriverManager;


import io.github.sukgu.Shadow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    //ovde smo deklarisali nasu promenljivu driver koja ce da pokrece chromedriver
public static WebDriver driver;
public static WebDriverWait wdWait;
public static Shadow shadow;
public static Select dropdown;
//ovo je JUnit anotacija koja govori da ce se ova metoda izvrsiti pre svih testova
@Before
// Ovo je metoda cije ime mi dajemo proizvoljno i tu stavljamo sve sto je potrebno izvrsiti pre svih testova
    public void setUp(){
    // Ovo automatski skida odgovarajucu verziju zeljenog pretrazivaca (driver-a)
//    WebDriverManager.chromedriver().setup();
    // Ovde smo nasoj promenljivoj driver dodelili objekat klase ChromeDriver
    driver = new ChromeDriver();
    wdWait = new WebDriverWait(driver,30);
    shadow = new Shadow(driver);
    driver.get("https://www.google.com/");
    driver.manage().window().maximize();

        }


 // Ovo je JUnit anotacija koja govori da ce se ova metoda izvrsiti nakon svih testova
 @After
 //  Ovo je metoda cije ime mi dajemo proizvoljno i tu stavljamo sve sto je potrebno izvrsiti nakon svih testova
    public void tearDown () {

    // Ova komanda zatvara tab koji je trenutno u fokusu
    //  driver.close();
    // Ova komanda zatvara ceo pretrazivac (driver)
    //  driver.quit();


 }
 // Ovo je JUnit anotacija za test
 @Test
 public void firstTest () {

//   Otvaranje yahoo stranice
     driver.get("https://www.yahoo.com/");
//   Vracanje nazad
     driver.navigate().back();
//   Refresh stranice
     driver.navigate().refresh();
//   Odlazak na sledecu stranicu
     driver.navigate().forward();
//   Fullscreen
     driver.manage().window().fullscreen();
//  Zatvaranje taba
     driver.close();
 }

// XPATH:
// Apsolutni ne smemo da koristimo!!!
// C:/My Documents/My Pictures/More/Grcka 2019/zalazak sunca.jpg

//  Relativni  OBAVEZNO KORISTIMO
//  //Input[@title = "Search"]
//  Input[@maxlength="2048]
//  tipElementa[@atribut = "vrednost"]
//  zalazak sunca.jpg
//  CSS selektor
//  [maxlength="2048"]

//    XPATH po sadrzanom tekstu
//    div[contains(text(),'Google offered')]
//    tipElementa[contains(text(),'zeljeni tekst')]
//    tipElementa[contains(text(), 'neki tekst')]
//    XPATH po tacnom tekstu
//    div[text() = 'Google offered in: ']
//    tipELementa[text() = 'zeljeni tacan tekst']

    // ovo je kraj nase klase i nista ne sme biti posle viticaste zagrade
    @Test
    public void googleTest() {
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("Beograd");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Test
    public void domaciZadatak(){

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q"))).clear();
        driver.findElement(By.name("q")).sendKeys("yahoo");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),  'Weather')]"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("root_2"))).click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("ybar-sbq"))).clear();
        driver.findElement(By.id("ybar-sbq")).sendKeys("google");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("ybar-search"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".d-ib.ls-05.fz-20.lh-26.td-hu.tc.va-bot.mxw-100p"))).click();


    }
    @Test
    public void Comtrade() throws InterruptedException {
    driver.get("https://www.ctshop.rs/customer/account/create");
    Thread.sleep(10000);
    List<WebElement>popupBanners = shadow.findElements("#PsCloseButton");
    for (int i =1; i>=0;i--) {
        popupBanners.get(i).click();
    }

    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
    driver.findElement(By.id("firstname")).sendKeys("Petar");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
    driver.findElement(By.id("lastname")).sendKeys("Petrovic");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
    driver.findElement(By.id("email_address")).sendKeys("acdc@rchp.ad");
    wdWait.until(ExpectedConditions.elementToBeClickable(By.id("is_subscribed")));
    WebElement checkBox = driver.findElement(By.id("is_subscribed"));
    if (checkBox.isSelected()) {
        checkBox.click();
    }
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
    driver.findElement(By.id("password")).sendKeys("Mario1899!");
    wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
    driver.findElement(By.id("confirmation")).sendKeys("Mario1899!");
    driver.findElement(By.xpath("//button[contains(text(), 'Prihvatam')]")).click();
    wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Pošalji')]"))).click();


    }
    @Test
    public void ComtradeUnsuccessfulRegistration()  throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(10000);

        List<WebElement>popupBanners = shadow.findElements("#PsCloseButton");
        for (int i = popupBanners.size(); i>0;i--) {
            popupBanners.get(i-1).click();
        }

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Petar");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Petrovic");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("acdc@rchp.ad");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("is_subscribed")));
        WebElement checkBox = driver.findElement(By.id("is_subscribed"));
        if (checkBox.isSelected()) {
            checkBox.click();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Mario1899!");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Dario1899!");
        driver.findElement(By.xpath("//button[contains(text(), 'Prihvatam')]")).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Pošalji')]"))).click();

    }
    @Test
    public void assertTest() {
        driver.get("https://www.ctshop.rs/customer/account/create");
        //Assert true uvek obavezan da bismo proverili da li je nesto prikazano na strani (poruka,slika,text)
        Assert.assertTrue(driver.findElement(By.xpath("//strong[text() = 'Kreirajte nalog']")).isDisplayed());
        // Assert Equals obavezan kada proveravamo text kako bismo znali da je text tacan i poklapa se sa BRD (Dokumentacija)
        Assert.assertEquals("KREIRAJTE NALOG",driver.findElement(By.xpath("//strong[text() = 'Kreirajte nalog']")).getText());



    }
    @Test
    public void uspesnaRegistracijaPravnoLice() throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(10000);
        List<WebElement>popupBanners = shadow.findElements("#PsCloseButton");
        for (int i = popupBanners.size(); i>0;i--) {
            popupBanners.get(i - 1).click();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Petar");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Petrovic");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("acdc@prock.ad");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("is_subscribed")));
        WebElement checkBox = driver.findElement(By.id("is_subscribed"));
        if (checkBox.isSelected()) {
                checkBox.click();
            }

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pravnolice")));
        dropdown = new Select(driver.findElement(By.id("pravnolice")));
        dropdown.selectByValue("1");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firma"))).clear();
        driver.findElement(By.id("firma")).sendKeys("Krstic");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("pib"))).clear();
        driver.findElement(By.id("pib")).sendKeys("123456789");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Mario1899!");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Mario1899!");
        driver.findElement(By.xpath("//button[contains(text(), 'Prihvatam')]")).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Pošalji')]"))).submit();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
        Assert.assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.",driver.findElement(By.cssSelector(".alert-success")).getText());

    }
    @Test
    public void assertDomaciZadatak() throws InterruptedException {
        driver.get("https://www.ctshop.rs/customer/account/create");
        Thread.sleep(10000);

        List<WebElement>popupBanners = shadow.findElements("#PsCloseButton");
        for (int i = popupBanners.size(); i>0;i--) {
            popupBanners.get(i-1).click();
        }

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Petar");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Petrovic");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("acdc@rchp.ad");
        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("is_subscribed")));
        WebElement checkBox = driver.findElement(By.id("is_subscribed"));
        if (checkBox.isSelected()) {
            checkBox.click();
        }
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("Mario1899!");
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("Mario1899!");
        driver.findElement(By.xpath("//button[contains(text(), 'Prihvatam')]")).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Pošalji')]"))).submit();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-warning")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-warning")).isDisplayed());
        Assert.assertEquals("Već postoji nalog sa unetom email adresom! Molimo ulogujte se!",driver.findElement(By.cssSelector(".alert-warning")).getText());
        Assert.assertNotEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.",driver.findElement(By.cssSelector(".alert")).getText());
        Assert.assertTrue( driver.findElements(By.cssSelector(".alert-success")).isEmpty());
    }



}
