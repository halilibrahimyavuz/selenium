package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    WebElement aramaKutusu;
    @Test
    public void test01() throws IOException {

        //amazon a gıdın
        driver.get("https://www.amazon.com");

        //3 farklı test methoduyla java , nutella bve elma aratıp sonuc sayfasını kaydedın
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        tümSayfaScreenShot();


    }
    @Test
    public void test02() throws IOException {

        //amazon a gıdın
        driver.get("https://www.amazon.com");

        //3 farklı test methoduyla java , nutella bve elma aratıp sonuc sayfasını kaydedın
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        tümSayfaScreenShot();


    }
    @Test
    public void test03() throws IOException {

        //amazon a gıdın
        driver.get("https://www.amazon.com");

        //3 farklı test methoduyla java , nutella bve elma aratıp sonuc sayfasını kaydedın
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Elma" + Keys.ENTER);
        tümSayfaScreenShot();


    }

}
