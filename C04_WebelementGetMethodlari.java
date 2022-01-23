package day03_WebelementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebelementGetMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://a.testaddressbook.com");

        WebElement singInLinki=driver.findElement(By.id("sign-in"));
        System.out.println("size :"+singInLinki.getSize()); // size getır
        System.out.println("ariaRole nedır  :"+singInLinki.getAriaRole()); // gorevı ne rolu ne dır =link
        System.out.println("accessible Name :"+singInLinki.getAccessibleName());
        System.out.println("attrıbute value sı :"+singInLinki.getAttribute( "id"));
        System.out.println("Locatıon :"+singInLinki.getLocation());
        System.out.println("genisşlik :"+singInLinki.getRect().width);
        System.out.println("colorur "+singInLinki.getCssValue("color"));
        driver.close();
    }
}
