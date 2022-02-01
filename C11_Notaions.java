package tests.day08;

import org.testng.annotations.Test;

public class C01_Notaions {



    @Test (priority = 9)
    public void youtubeTest(){
        System.out.println("youtube testi çalıstı");
    }


    @Test //priority atanmazsa = 0 kabul eder ve ona göre sıralar
            // 2 methodda da priority yoksa harf sırasına gore sıralamaya devam eder.
    public void amazonTest(){
        System.out.println("amazon  testi çalıstı");
    }

    @Test (priority = 5)
    public void bestBuyTest(){
        System.out.println("bestbuy testi çalıstı");

    }









}
