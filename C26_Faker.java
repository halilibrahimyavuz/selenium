package tests.day14;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {



    @Test
    public void facebooKayıtTesti() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“firstName” giris kutusuna bir isim yazin
        WebElement nameButtonElementi=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();//ıkı kez sıfre ıstıyor ve aynı olmak zounda faker dan 2 tane aynı sıfre cıkmaz

        actions.click(nameButtonElementi)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("1972")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        WebElement erkekLementi=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement kadınELementi=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));

        Assert.assertTrue(erkekLementi.isSelected());
        Assert.assertFalse(kadınELementi.isSelected());

        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin
Thread.sleep(4000);
    }

}
