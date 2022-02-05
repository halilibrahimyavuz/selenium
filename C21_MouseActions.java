package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C02_MouseActions extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //amazon ana sayfaya gıt

        driver.get("https://www.amazon.com");

        // sag ustte hello sıng ın mesunun ustune durup acılan menuden creat lıst e tıkla




























        Actions actions=new Actions(driver);
        WebElement helloSıgnInElementi=driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute']"));
        actions.moveToElement(helloSıgnInElementi).perform();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        //new lıstın acıldıgını test et

        Assert.assertTrue((driver.findElement(By.xpath("//*[@role='heading']"))).isDisplayed()," new lıst sayfası gozukmuyor");
    }


/*
   @Test
    public void amaonList() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement helloElement=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(helloElement).perform();
        WebElement listElementi=driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(listElementi).perform();
        String actualtitle= driver.getTitle();
        String arananMetin="Your List";
        Assert.assertTrue(actualtitle.contains(arananMetin));

        Thread.sleep(5000);
    }
 */

}
