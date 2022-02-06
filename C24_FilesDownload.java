package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownload extends TestBase {

    @Test
    public void isExistTest(){

        //.	Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyayolu=System.getProperty("user.home")+"\\İndirilenler\\selenium.xlsx";
        Assert.assertFalse(Files.exists(Paths.get(dosyayolu)));
        // Dosya yükleme işlemini anlamak için önce manuel olarak test yapilmali.


    }
    @Test
    public void downloadTesti() throws InterruptedException {
//3.	downloadTest () metodunun icinde aşağıdaki testi yapalim:
        //-	https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //-	download.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='selenium.xlsx']")).click();
        Thread.sleep(5000);


    }

}
