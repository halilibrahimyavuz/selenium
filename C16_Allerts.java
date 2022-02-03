package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {
    WebDriver driver;
    WebElement actualResultElementi;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //●	https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }

    @Test
    public void acceptAlertTest() {
        //● Bir metod olusturun: acceptAlert
        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept(); // okey tusuna bastık accept ıle
        // mesajının “You successfully clicked an alert” oldugunu test edin.
        actualResultElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultStringOlarak=actualResultElementi.getText();
        String expectedResultStringOlarak="You successfully clicked an alert";
        Assert.assertEquals(actualResultStringOlarak,expectedResultStringOlarak,"sonuc yazısını kontrol edınız");
    }

    @Test
    public void dismissAlert() {
        /// ● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın

    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    driver.switchTo().alert().dismiss();
        // ve result mesajının “successfuly” icermedigini test edin.
        actualResultElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=actualResultElementi.getText();
        String notExpectedResult="successfuly";
        Assert.assertFalse(actualResult.contains(notExpectedResult));
    }

    @Test
    public void sendKeysAllert() {
        //     / ● Bir metod olusturun: sendKeysAlert
        //    //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, ve
              driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Halil İbrahim YAVUZ");
        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //    result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=actualResultElementi.getText();
        String expectedResult="Halil İbrahim YAVUZ";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
