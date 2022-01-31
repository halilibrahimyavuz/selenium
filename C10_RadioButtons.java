package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtons {
    //var olan secenenklerden sadece bır tanesını secebılırseınız
    // secme sekmesı tek bır secenbek ıcın aktıf olur
    WebDriver driver;

@After
public void teardown() throws InterruptedException {
    Thread.sleep(3000);
   driver.close();
}



    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void test01(){
    //-	https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-	“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //-	“radio buttons” elementlerini locate edin
        //	-	Secili degilse cinsiyet butonundan size uygun olani secin
        driver.findElement(By.name("sex")).click();


    }
}
