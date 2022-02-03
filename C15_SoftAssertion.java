package tests.day09_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {
    WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

   @Test
    public void test(){
       // 1. “http://zero.webappsecurity.com/” Adresine gidin,
       driver.get("http://zero.webappsecurity.com/");

       // 2. Sign in butonuna basin
       driver.findElement(By.xpath("//button[@id='signin_button']")).click();

       // 3. Login kutusuna “username” yazin
       driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

       // 4. Password kutusuna “password” yazin
       driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

       // 5. Sign in tusuna basin
       driver.findElement(By.xpath("//input[@name='submit']")).click();
       driver.navigate().back(); //guvenlık uarısını gecmek ıcın gerı ye gıdıyoruz

       // 6. online bankıng menusu ııcnde ki Pay Bills sayfasina gidin
       driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
       driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

       // 7. “Purchase Foreign Currency” tusuna basin
       driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();

       // 8. “Currency” drop down menusunden Eurozone’u secin
       WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='pc_currency']"));
       Select select=new Select(dropdownElementi);
       select.selectByValue("EUR");

       // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
       SoftAssert softAssert=new SoftAssert();
       String actualOption=select.getFirstSelectedOption().getText();
       String expectedOption="Eurozone (euro)";
       softAssert.assertEquals(actualOption,expectedOption,"secılen optıonu kontrol edınız");

       // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One","Australia (dollar)","Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
       List<WebElement> optionsListesiElementi=select.getOptions();
       String optionsListesiStringOlarak="";
       for (WebElement each:optionsListesiElementi) {
           optionsListesiStringOlarak+="\""+each.getText()+"\",";

       }
       optionsListesiStringOlarak=optionsListesiStringOlarak.substring(0,optionsListesiStringOlarak.length()-1);
       String actualListeStringOlarak="\"Select One\",\"Australia (dollar)\",\"Canada (dollar)\",\"Switzerland (franc)\",\"China (yuan)\",\"Denmark (krone)\",\"Eurozone (euro)\",\"Great Britain (pound)\",\"Hong Kong (dollar)\",\"Japan (yen)\",\"Mexico (peso)\",\"Norway (krone)\",\"New Zealand (dollar)\",\"Sweden (krona)\",\"Singapore (dollar)\",\"Thailand (baht)\"";

       softAssert.assertEquals(actualListeStringOlarak,optionsListesiStringOlarak,"Optıon listeleri birbiri ile uyusmuyor");

        softAssert.assertAll();
   }


   @AfterMethod
    public void teardown(){
        driver.close();

   }
  }
