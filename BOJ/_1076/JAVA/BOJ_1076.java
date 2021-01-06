package com.example.BOJ._1076.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1076 {


    public static void main(String[] args) throws IOException {

        HashMap<String,Integer> resistance = new HashMap<>();
        resistance.put("black",0);
        resistance.put("brown",1);
        resistance.put("red",2);
        resistance.put("orange",3);
        resistance.put("yellow",4);
        resistance.put("green",5);
        resistance.put("blue",6);
        resistance.put("violet",7);
        resistance.put("grey",8);
        resistance.put("white",9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = resistance.get(br.readLine())*10;
        int base = resistance.get(br.readLine());
        int exponent = resistance.get(br.readLine());

        System.out.println((value+base)*(long)Math.pow(10,exponent));

    }
}
