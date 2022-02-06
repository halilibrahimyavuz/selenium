package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists  {
    //webdrıverda degıl pc de gezinecegım o yuzden extedns e gerek yok
    //webdrıver olusturmaya gerek yok
    @Test
    public void test01(){
        //getProperty----> kulanıcıyı verir.My.computer ın yuolunu verır
        //bundan sonrakı butun yollar her pc de aynıdır. download- desktop vs

        System.out.println(System.getProperty("user.home")); //--> C:\Users\Halil İbrahim Yavuz
        //masaustunde oluturdugumuz denem klasorunun path ı lazım
        //deneme klasorunun path i--->C:\Users\Halil İbrahim Yavuz\Desktop

        // yanı dınamık olarak masa ustundekı deneme klasorunun pathını yazmak ıstersek
        String path=System.getProperty("user.home")+"\\Desktop\\deneme";

        System.out.println(path); //--->C:\Users\Halil İbrahim Yavuz\Desktop\deneme

        //masaustunde deneme klasoru ıcerısınde selenıum.xlsx isilimli dosyaq varmı teste et
        // 1--> once dosyaya  ulasmak ıcı dınamık path olustur

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme";
        System.out.println(dosyaYolu); //--->C:\Users\Halil İbrahim Yavuz\Users\Halil İbrahim Yavuz\Desktop\deneme



        //user.dir ---> projenın ıcnde bulundugu yolu verır
        System.out.println("user.dir --->"+System.getProperty("user.dir"));
        //projemın yerı: user.dir --->C:\Users\Halil İbrahim Yavuz\IdeaProjects\com.TestNGBatch44

        System.out.println(Files.exists(Paths.get(dosyaYolu))); //boolean dondurur

        //projemızde pom.xml oldugunu test edınız
        //C:\Users\Halil İbrahim Yavuz\IdeaProjects\com.TestNGBatch44\pom.xml
        System.out.println(System.getProperty("user.dir")); //projemın yolunu verır
        //C:\Users\Halil İbrahim Yavuz\IdeaProjects\com.TestNGBatch44
        String  ponPAth=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(ponPAth)));
    }






}
