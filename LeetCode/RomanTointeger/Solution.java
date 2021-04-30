package com.example.LeetCode.RomanTointeger;

public class Solution {

    enum roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int value;

        roman(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        int result = new Solution().romanToInt("MCMXCIV");
        int expected = 1994;

        System.out.println((result == expected) + ":" + result);
    }

    public int romanToInt(String s) {
        String[] array = s.split("");

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("I")) {
                if (array.length > i + 1) {
                    if (array[i + 1].equals("V") || array[i + 1].equals("X")) {
                        result = roman.valueOf(array[i + 1]).getValue() - roman.valueOf(array[i]).getValue();
                        i= i+1;
                        continue;
                    } else {
                        result += roman.valueOf(array[i]).getValue();
                    }
                } else {
                    result += roman.valueOf(array[i]).getValue();
                }
            } else if (array[i].equals("X")) {
                if (array.length > i + 1){
                    if (array[i + 1].equals("L") || array[i + 1].equals("C")) {
                        result = roman.valueOf(array[i + 1]).getValue() - roman.valueOf(array[i]).getValue();
                        i= i+1;
                        continue;
                    } else {
                        result += roman.valueOf(array[i]).getValue();
                    }
                }else{
                    result += roman.valueOf(array[i]).getValue();
                }
            } else if (array[i].equals("C")) {
                if(array.length > i + 1) {
                    if (array[i + 1].equals("D") || array[i + 1].equals("M")) {
                        result = roman.valueOf(array[i + 1]).getValue() - roman.valueOf(array[i]).getValue();
                        i= i+1;
                        continue;
                    } else {
                        result += roman.valueOf(array[i]).getValue();
                    }
                }else{
                    result += roman.valueOf(array[i]).getValue();
                }
            } else{
                result += roman.valueOf(array[i]).getValue();
            }

        }

        return result;

    }
}
