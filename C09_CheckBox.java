package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void teardown(){
driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        //a.	Verilen web sayfasına gidin.//https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

//b.	Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

//c.	Checkbox1 seçili değilse onay kutusunu tıklayın
      if (!checkbox.isSelected()){
          checkbox.click();
      }
//d.	Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(3000);
    }





}
