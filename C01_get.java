package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle()); //title=başlık arama sekmesındekı yazıyı getırır.

        System.out.println(driver.getCurrentUrl()); //url de ne varsa getırır https://www.amazon.com/ getırdı

        System.out.println(driver.getWindowHandle()); // arama kımlıgı gıbı bırsey her aramada degıısık olur--->CDwindow-A0A16D55D6D6C0353D228279C8454F87

        System.out.println(driver.getPageSource());// gıttımız sıtenın arka kodlarınının hepsını getırır.












    }



}
