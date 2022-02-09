package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class EnableTest extends TestBase {

    @Test
    public void isEnable() throws InterruptedException {
        //1.	Bir class olusturun : EnableTest
        //2.	Bir metod olusturun : isEnabled()
        //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.	Textbox’in etkin olmadigini(enabled) dogrulayın
        Thread.sleep(3000);

        WebElement textBoxElementi=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxElementi.isEnabled());

        //5.	Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));


        //6.	“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Thread.sleep(3000);
        Assert.assertTrue((driver.findElement(By.xpath("//p[@id='message']"))).isDisplayed());

        //7.	Textbox’in etkin oldugunu(enabled) dogrulayın.
        Thread.sleep(3000);
        Assert.assertTrue(textBoxElementi.isEnabled());

    }


}
