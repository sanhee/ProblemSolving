package com.example.programmers.레벨2.소수찾기;

public class Solution {

    public boolean prime(int number){

        if(number < 2){
            return false;
        }

        for(int i=2; i*i<number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public int solution(String numbers) {
        int answer = 0;
        char[] array = numbers.toCharArray();

        dfs(0, array, new boolean[array.length]);

        return answer;
    }

    private void dfs(int index, char[] array, boolean[] visited) {

        for(int i = index; i < array.length; i++){
            if(array[i] == '0'){
                continue;
            }
            for(int j = 0; j < array.length; j++){


            }
        }
    }
}
