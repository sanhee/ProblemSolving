package com.example.LeetCode.longestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];


        for(int i=1; i<strs.length; i++){

            // 0번째 인덱스에서 발견될 때까지
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);

                if(prefix.isEmpty()){
                    return "";
                }
            }


        }

        return prefix;
    }
}