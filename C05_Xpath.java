package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //1-	https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2-	Add Element butonuna basin
        Thread.sleep(2000);
        WebElement addElemetButonu=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElemetButonu.click();

        //3-	Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("delete button gorunuyor testi PASS");
        }else{
            System.out.println("Delete button gorunuyor testı FAİLED");
        }

        //4-	Delete tusuna basin
        Thread.sleep(2000);
        deleteButonu.click();

        //5-	“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addYAzisiElementi=driver.findElement(By.xpath("//h3"));
        WebElement addYAzisiElementi2=driver.findElement(By.tagName("h3"));

      if (addYAzisiElementi.isDisplayed()){
          System.out.println("add yaızısı gorunuyor testi PASS");
      }else{
          System.out.println("add yazısı  gorunuyor testı FAİLED");
      }

      }

    }

