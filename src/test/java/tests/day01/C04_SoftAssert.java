package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C04_SoftAssert {


// "https://amazon.com" sayfasına gidiniz
/// Title'in "Amazon" icerdigini test edin
/// Arama kutusunun erisilebilir oldugunu test edin
// Arama kutusuna Nutella yazıp aratın
/// Sonuc yazısının gorunur oldugunu test edin
/// Sonuc yazısının "Nutella" icerdigini test edin

// test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin

    WebDriver driver;

    @BeforeClass
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

@Test
    public void test01(){
    // "https://amazon.com" sayfasına gidiniz

driver.get("https://amazon.com");

/// Title'in "Amazon" icerdigini test edin

    SoftAssert softAssert=new SoftAssert();
    String amazonTitle=driver.getTitle();
    softAssert.assertTrue(amazonTitle.contains("Amazonnn"), "TİTLE AMAZON İCERMİYOR");
/// Arama kutusunun erisilebilir oldugunu test edin

    WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
     softAssert.assertTrue(aramaKutusu.isEnabled(), "ARAMA KUTUSUNA ERİSİLEMİYOR");
// Arama kutusuna Nutella yazıp aratın

aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
/// Sonuc yazısının gorunur oldugunu test edin

    WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    softAssert.assertTrue(sonucYazisi.isDisplayed(),"SONUC YAZİSİ GORUNMUYOR");
/// Sonuc yazısının "Nutella" icerdigini test edin

  softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"SONUC YAZSI Nutella ICERMİYOR");
 softAssert.assertAll();
    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin

}

}
