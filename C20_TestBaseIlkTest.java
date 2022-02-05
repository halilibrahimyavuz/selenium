package tests.day11;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {

    //utilities package altında TestBAse classı olsuturduk
    // bu class a beforeclass ve afterclass gıbı methodları koyuyoruz
    // ıhtıyacımız oldugunda extends yaparak o classa baglanıyoruz ve sureklı setup ve teardown methodları
    //olustrumaktan kurtulmus oluyoruz
    // chıld classda sadece yapacagımız ıslemı yapıyorz dıger ıslemler extend yapılan classtan otomatık gelıyor
    // framework olusturmak ıcın kullanıyoruz

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
