package com.example.programmers.레벨1.체육복;

// 2021-07-20 pm 12:14 ~.. 1:17..

// 학생들의 번호는 체격 순
// 앞이나 뒷번호 친구에게만 빌려줄 수 있다.
// 최대한 많은 학생이 체육수업을 들어야 합니다.
// 체육 수업 수강생 = 학생수 - 잃어버린 체육복 수 + 여벌 체육복
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        final int countOflost = lost.length;
        boolean[] check = new boolean[reserve.length+1]; // 체육복 빌려준거 카운트

        int answer = n-countOflost;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<countOflost; i++){
            for(int j=0; j<reserve.length; j++){
                if(!check[j] && (reserve[j] >= lost[i]-1 && reserve[j] <= lost[i]+1)){
                    answer++;
                    check[j] = true;
                    break;
                }
            }
        }

        return answer;
    }
}
