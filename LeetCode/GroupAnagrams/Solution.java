package com.example.LeetCode.GroupAnagrams;

import java.util.*;

// 애너그램
// 1. 문자열의 길이와 각 요소가 같으면 애너그램
// 2. 문자열의 각 문자(char)를 유니코드로 대응되는 숫자로 변경하여 문자열 고유키를 만들어 해쉬맵의 키로 이용한다.
// 2-1. 고유키를 이어 붙일 경우 비교가 안되는 상황을 피하기 위해, 구분자 #을 추가한다. ex) #1#10
// 구분자가 필요한 이유, 각 문자열의 유일한 키값을 만들기 위해서임.

// ["bdddddddddd","bbbbbbbbbbc"] 를 비교한다고 하면,  각 문자의 카운트가 올라간다.
// #0#1#0#10#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0    -> b : 1개 , d: 10개

// #0#10#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0    -> b: 10개 , d: 1개

// 010100000000000000000000000  -> 이어 붙여져서 특정 문자의 카운트가 구분이 안됨.
// 010100000000000000000000000

public class Solution {
    public static void main(String[] args) {
        new Solution().groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        int[] id = new int[26]; // a~z 개수
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            Arrays.fill(id,0);

            for(char c : s.toCharArray()){
                id[c-'a']++;  // 소문자만 취급한다고 했음, 문자에 해당하는 유니코드 정수 인덱스를 구한다.
            }

            StringBuilder sb = new StringBuilder();

            for(int n : id){
                sb.append(n);
            }
            String key = sb.toString();
            System.out.println(key);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return (List<List<String>>) map.values();
    }
}
