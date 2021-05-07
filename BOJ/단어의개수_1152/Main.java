package com.example.BOJ.단어의개수_1152;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] array = str.split(" ");

        int cnt = array.length;

        if(cnt != 0 && array[0].equals("")){
            cnt--;
        }

        if(cnt != 0 && array[array.length-1].equals("")){
            cnt--;
        }

        System.out.println(cnt);

    }
}
