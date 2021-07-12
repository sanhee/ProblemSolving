package com.example.programmers.레벨1.서울에서김서방찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String[] seoul) {
        List<String> seoulList = new ArrayList<>(Arrays.asList(seoul));
        return "김서방은 "+seoulList.indexOf("Kim")+"에 있다";
    }
}
