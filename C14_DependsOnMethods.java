package tests.day09_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {
 WebDriver driver;

@BeforeClass
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();

}
    @Test
    public void logoTest1(){
        //●	https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //1.	Test : Amazon ana sayfaya gittiginizi test edin
        WebElement logoElementi=driver.findElement(By.xpath("//div[@id='nav-logo']"));
        Assert.assertTrue(logoElementi.isDisplayed());


    }

    @Test (dependsOnMethods ="logoTest1") //iki test i birbirine baglar ondeki, lokomotıf test calısmazsa dıgerlerı calısmaz
    public void aramaTesti(){
        //2.	Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin  arama yapin ve aramanizin gerceklestigini Test edin
    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

    String actualTitle=driver.getTitle();
    String expectedTıtle="Nutella";
    Assert.assertTrue(actualTitle.contains(expectedTıtle));



    }

    @Test   (dependsOnMethods = "aramaTesti")
    public void fiyatTesti(){
        //  3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement urunFiyatElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]"));
        String urunFiyatiString=urunFiyatElementi.getText();
        String arananFiyat="$14.99";
        Assert.assertTrue(urunFiyatiString.contains(arananFiyat));
    }
    @AfterClass
    public void teardown(){

    driver.close();
    }
}
