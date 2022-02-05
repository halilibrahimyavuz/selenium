package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    //sayfalar arasında gecıs yaparken kullanılabılecegımız yontemdır.
    // her sayfanın kımlık numaraıs gıbı wındowHandle ı vardı her zmn bırıbırınde farklıldır  bu kodlar
    //1-switchTo().newWindow --->yenı bır pencere acar ancak bos bır sayfa
    //2- driver.get("https.www.wwww.com")---> acılan bos pencereyı bu adrese donderdı.

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void handleWindows() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String windowHandleDegeri1=driver.getWindowHandle();
        System.out.println("ilk sayfanin window handle degeri : " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere acilir
        driver.get("https://www.bestbuy.com");
        System.out.println("2.sayfanin handle degeri : " + driver.getWindowHandle());
        String windowHandleDegeri2=driver.getWindowHandle();

        Set<String> handleDegerleriSet=driver.getWindowHandles(); // set<String> oalrak dondurur o yuzden set olusturmmız lazım handelesss-- cogul
        System.out.println("set olarak handles lerın degerlerı : "+handleDegerleriSet);

        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB); // yenı bır pencere acar ancak yenı bır sayfada degıl sayfanın uzerınde tab acar
        driver.get("https://www.facebook.com"); //bos olan sayfaı facebook a yonlendırdık

        Thread.sleep(3000);

        // *********amazon'un acik oldugu sayfaya gecin ve nutella icin arama yapin**********

        driver.switchTo().window(windowHandleDegeri1); //--> handle degerını yazıyoruz gececegımız sayfanın sonra switchTo ile geciyoruz
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //+++++++ bestbuy acik olan sayfaya gecin ve title'in Best Buy icerdigini test edin++++++

        Thread.sleep(3000);
        driver.switchTo().window(windowHandleDegeri2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // facebook'un acik oldugu sayfaya gecin
        // ve url'in https://www.facebook.com oldugunu test edin
        // eger acik olan pencerelerden sadece bir tanesinin window handle degeri bilinmiyorsa
        // once tum handle degerlerini bulup bir set'e koyariz

        handleDegerleriSet=driver.getWindowHandles(); //mevcut olan sete atama yaparız atama yapınca oncekıler yok olur yenıler set e eklenır.

        // bu soru icin su anda set'te 3 window handle degeri var
        // 1. ve 2/ sayfanin window handle degerlerini biliyoruz
        // setimizde olup, ilk iki sayfa olmayan handle degeri 3.sayfanin handle degeri olacaktir

        String windowHandleDegeri3="";
        for (String each: handleDegerleriSet
        ) {
            if (!(each.equals(windowHandleDegeri1) || each.equals(windowHandleDegeri2)) ){
                windowHandleDegeri3=each;
            }
        }
        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleriSet);
        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Thread.sleep(5000);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
