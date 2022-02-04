package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void iframeTest() throws InterruptedException {
//●	https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //	○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda 	yazdirin.
        WebElement textElemeti=driver.findElement(By.tagName("h3"));
        System.out.println("ekrandaki text :"+textElemeti.getText());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(textElemeti.isEnabled(),"Iframe yazısı gorunmuyor");//enable ile ersılılebılır demek



        //○ Text Box’a “Merhaba Dunya!” yazin.
        //yazı yazmak ıstedıgmı text box IFRAME nın ıcınde oldugundan dırekt ulasamıyoruz
        //çönce ıfrae ı locate edıp onun ıcıne swıtch yapmalıyız.

        //ıframe e gırıs yapıldı cıkmayı unutma

        WebElement ıframeElemeti=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(ıframeElemeti);

        WebElement textBoxElementi=driver.findElement(By.tagName("p"));
        Thread.sleep(2000);
        textBoxElementi.clear();//once text box u temızledık
        textBoxElementi.sendKeys("Merhaba Dünya");
        //ıframden cıkıs yap
        driver.switchTo().defaultContent(); // basa donduk

        //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin,
        WebElement elementalSelenıumTextElementi=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        softAssert.assertTrue(elementalSelenıumTextElementi.isDisplayed(),"elemental selenıum text gorunmıyor");

        // ve konsolda yazdirin.
        System.out.println("text box altındakı yazı"+elementalSelenıumTextElementi.getText());

        softAssert.assertAll();
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }

}
