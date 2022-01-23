package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.time.Duration;

public class C08_ImplicitlyWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize(); // bunu her testten once obje olusturu olusturmaz yapmak lazım
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 14. satır obje olusur olusmaz yazarız ki bütün işlemlere uygulasın
        // 15 sanıye max suredır acılmazsa o kadar sure bekler Thread.sleep(3000); yerıne kullanırız

        driver.get("https://www.amazon.com");
       // Thread.sleep(5000);




    }
}
