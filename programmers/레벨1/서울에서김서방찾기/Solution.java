package com.example.programmers.레벨1.서울에서김서방찾기;

class Solution {
    public String solution(String[] seoul) {
        int index = -1;

        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                index = i;
                break;
            }
        }
        return "김서방은 "+index+"에 있다";
    }
}
