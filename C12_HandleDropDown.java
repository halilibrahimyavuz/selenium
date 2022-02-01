package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.util.SimpleElementVisitor6;
import java.time.Duration;
import java.util.List;

public class C02_HandleDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setup(){

        /*DROPDOWN
        ALT ALTA ACILAN PENCERELER  DE   var olan bırını secmek ıcın
        1.adım--->Dropdown web elementını locate edıp bır degıskene atıyruz
        2.adım:---> select clasından bır obje olusturalım
        3.adım: select objenısı kulanraak dropdown ıcınekı 3 secım mmethodundan ıstedıgımız kulanrak dropdown
                        da var olan optıonlardan bırını secebılırz
                         secım yapmamıza yardım eden 3 method vod dondurur dolayısıyla bısey dondurmezler
                      ancak o ısteden secılne kategorıyı secerler
         */

        WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.amazon.com");
    }

    @Test
    public void dropdownTesti() throws InterruptedException {
        //dropdown da var olan seçeneklerden birini seçmek için
        //1. adım: Dropdown web elementını locate edıp bır degıskene atıyruz
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2.adım: select clasından bır obje olusturalım
        //ve parametre olrak locate ettıhımız web elemnentı yazlwaım
        Select select=new Select(dropdownElementi);

        //3.adım: select objenısı kulanraak dropdown ıcınekı
        //3 secım mmethodundan ıstedıgımız kulanrak dropdown da var olan optıonlardan bırını secebılırz
        // secım yapmamıza yardım eden 3 method vod dondurur dolayısıyla bısey dondurmezler
        //ancak o ısteden secılne kategorıyı secerler

        select.selectByIndex(3); // 3. index te hangı secenek yanı kategorı varsa onu seecr --> Baby kategorısı ornegın

        //secxtıgımız optıon degerını yazdırma ıcın
        System.out.println(select.getFirstSelectedOption().getText());
            // secılen optıonu getırir web elemenbt olrak sonrada get.text ıle strıng cevırır

        Thread.sleep(3000);
        select.selectByVisibleText("Deals");// Deals kategorsıını secer

        List<WebElement> optionList=select.getOptions();
        for (WebElement each: optionList){
            System.out.println(each.getText());
        }
                   }

                   @AfterMethod
    public void teardown(){
        driver.close();

                   }

}
