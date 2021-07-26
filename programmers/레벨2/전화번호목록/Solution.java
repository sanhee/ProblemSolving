package com.example.programmers.레벨2.전화번호목록;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phoneBook) {

        Map<String, Integer> hash = new HashMap<>();


        for(String key : phoneBook){
            hash.put(key, 0); // value 의미없음.
        }

        for(int i=0; i<phoneBook.length; i++){
            for(int j=1; j<phoneBook[i].length(); j++){

                if(hash.containsKey(phoneBook[i].substring(0,j))){
                    return false;
                }

            }

        }
        return true;
    }
}