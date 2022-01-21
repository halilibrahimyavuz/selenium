package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://www.amazon.com");
        //driver.get ile aynı işlemi yapar ama daha hızlıdır

        driver.navigate().to("https://www.techproeducation.com");

        driver.navigate().back();// geldıgı sayfaya doner yanı techprodan oncekı amazon sayfasına dondu bır ıslem gerıye gıttı
        driver.navigate().forward();// bır ılerıye dogru gıdecek amazondan tekrar techproya gıdecek

        driver.navigate().refresh(); // sayfayı yenıleme komutu





    }
}
