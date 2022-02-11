package tests.day15;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
public class C01_ScreenshotWebElement extends TestBase {

    @Test
    public void nutellaWebElementTesti() throws InterruptedException, IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella icin arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucSayisiStr=sonucYazisiElementi.getText();
        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));
        // testin calistiginin ispati icin tum sayfanin screenshot'ini alalim
        //1. adım ss cekecegımız webelementı locate edelım
        //2. adım: ss ı kaydedecegımız bır file olusturalım
        File webelementSS=new File("target/screenShot/webelement.jpeg");

        //3adım:
        File geciciresim=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);

            //4.adom gecıcı resmı kayıt ayaparagımöız yere kopyalayalım
        FileUtils.copyFile(geciciresim,webelementSS);




        Thread.sleep(5000);
    }
}
