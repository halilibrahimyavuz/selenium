package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

 @Test
    public void dropdownTesti(){
     //● https://the-internet.herokuapp.com/dropdown adresine gidin.
     driver.get("https://the-internet.herokuapp.com/dropdown");

     WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='dropdown']"));
     Select select=new Select(dropdownElementi);


     //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
     select.selectByIndex(1);
     System.out.println(select.getFirstSelectedOption().getText());

     //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
     select.selectByValue("2");
     System.out.println(select.getFirstSelectedOption().getText());

     //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

     select.selectByVisibleText("Option 1");
     System.out.println(select.getFirstSelectedOption().getText());

     //    4.Tüm dropdown değerleri(value) yazdırın
     List<WebElement> optionsList=select.getOptions();
     for (WebElement each: optionsList) {
         System.out.println(each.getText());
     }

     //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

     int actualSize=optionsList.size();
     int expectedSize=3;
     Assert.assertEquals(actualSize,expectedSize,"dropdown boyutlarını kontrol et");

    }
@AfterMethod
    public void teardown(){
        driver.close();
}
}
