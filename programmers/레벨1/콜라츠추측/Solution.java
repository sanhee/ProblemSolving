package com.example.programmers.레벨1.콜라츠추측;

public class Solution {
    public int solution(int num) {
        long convertedNum = num;
        int count =0;
        while(convertedNum != 1){
            if(count > 500){
                return -1;
            }
            convertedNum = (convertedNum % 2 == 0) ? convertedNum / 2 : (convertedNum * 3) + 1;
            System.out.println("count("+count+"): "+convertedNum);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(626331));
    }
}
