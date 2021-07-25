package com.example.programmers.레벨1.체육복;

// 2021-07-20 pm 12:14 ~.. 1:17..
// 2021-07-26 pm 01:16 ~ 01.55

// 학생들의 번호는 체격 순
// 앞이나 뒷번호 친구에게만 빌려줄 수 있다.
// 최대한 많은 학생이 체육수업을 들어야 합니다.
// 체육 수업 수강생 = 학생수 - 잃어버린 체육복 수 + 여벌 체육복

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        // 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int result = n;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) { // 여벌을 가져왔지만, 본인껄 도난당한 경우
                    lost[i] = -lost[i]; // 연산에서 배제
                    reserve[j] = -reserve[j]; // 연산에서 배제
                    result++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] < 0 ) {
                result--;
                continue;
            }
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] < 0 ) {
                    continue;
                }
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    result++;
                    reserve[j] = -reserve[j]; // 연산에서 배제
                    break;
                }
            }
            result--;
        }

        return result;

    }

    public static void main(String[] args) {


        if (new Solution().solution(5, new int[]{5, 3, 1}, new int[]{2, 4}) == 4) {
            System.out.println("통과1");
        } else {
            System.out.println(new Solution().solution(5, new int[]{5, 3, 1}, new int[]{2, 4}));
        }

        if (new Solution().solution(7, new int[]{7, 4, 3, 5, 2, 1}, new int[]{6, 5}) == 3) {
            System.out.println("통과2");
        } else {
            System.out.println(new Solution().solution(7, new int[]{7, 4, 3, 5, 2, 1}, new int[]{6, 5}));
        }

    }
}
