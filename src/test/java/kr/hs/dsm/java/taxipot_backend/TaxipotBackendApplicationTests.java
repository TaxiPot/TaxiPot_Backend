package kr.hs.dsm.java.taxipot_backend;

import org.junit.Test;

import java.util.Date;

public class TaxipotBackendApplicationTests {
    @Test
    public void contextLoads() throws Exception{
        Date date = new Date(1573570369412L);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDate());
        System.out.println(date.getHours());
        System.out.println(date.getMinutes());
        Date date1 = new Date();
        System.out.println(date1.getYear());
        System.out.println(date1.getMonth());
        System.out.println(date1.getDate());
        System.out.println(date1.getHours());
        System.out.println(date1.getMinutes());
        Date date3 = new Date(1572739200000L);
        System.out.println(date3.getYear());
        System.out.println(date3.getMonth());
        System.out.println(date3.getDate());
        System.out.println(date3.getHours());
        System.out.println(date3.getMinutes());
    }
    private double getCoordinates(float x, float y){
        return Math.pow((double)x,2) + Math.pow((double)y,2);
    }

    private boolean isInRadious(float x1, float x2, float y1, float y2, float radius) {
        System.out.println(Math.pow((double)radius,2));
        System.out.println(getCoordinates(x1-x2,y1-y2));
        return Math.pow((double)radius,2) >= getCoordinates(x1-x2,y1-y2);
    }
}
