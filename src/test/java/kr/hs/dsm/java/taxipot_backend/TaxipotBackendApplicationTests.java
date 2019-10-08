package kr.hs.dsm.java.taxipot_backend;

import org.junit.Test;

public class TaxipotBackendApplicationTests {
    @Test
    public void contextLoads() throws Exception{
        System.out.println(isInRadious(0,5,0,12,13));
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
