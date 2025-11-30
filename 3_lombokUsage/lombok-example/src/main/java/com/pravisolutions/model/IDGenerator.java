package com.pravisolutions.model;

import java.util.Random;

public class IDGenerator {

    public static String Generate() {
        Random r = new Random();
        int max=200,min=100;
        System.out.println("Generated numbers are within "+ min +" to "+ max);
        int ID = (r.nextInt(max - min + 1) + min);
        return Integer.toString(ID);
    }
}
