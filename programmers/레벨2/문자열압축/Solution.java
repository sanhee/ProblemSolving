package com.example.programmers.레벨2.문자열압축;


class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int stringLength = s.length();

        if(stringLength == 1){ // s의 길이가 1부터 시작함
            return 1;
        }


        // 압축할 수 있는 최대 단위(개수)는 문자열 / 2
        for(int i = 1; i <= stringLength/2 ; i++){

            String prevSplit = ""; // 압축 단위(i)로 쪼갠 문자열
            StringBuilder sb = new StringBuilder(); // 압축된 문자열을 담을 공간
            int countOfCompression = 1; // 압축 개수를 담을 공간

            // 위 반복문에서 압축 단위(i)를 받아온 걸 토대로 순회해서 문자열을 압축한다.
            for(int j=0; j < (stringLength/i); j++){   // ex)

                String currentSplit = s.substring(j*i, (j*i)+i);  // 0, (0*1)+1  -> (0,1)-(1,2)

                if(prevSplit.equals(currentSplit)){
                    countOfCompression++;
                    continue; // (0,1)과 (1,2)가 일치했다면, (2,3)을 검사하기 위해 continue
                }

                if(countOfCompression > 1){ // 쪼갠 문자열이 일치하지 않고, 카운트가 1보다 크다면?
                    sb.append(countOfCompression).append(prevSplit); // 2a 형식으로 저장하기 위함.
                    countOfCompression = 1; // 다른 압축 문자열 중복 체크를 위해, 카운트 초기화
                }else{
                    sb.append(prevSplit);
                }

                prevSplit = currentSplit;
            }
            // 쪼갠 문자열을 비교하고, continue를 하므로, 마지막 문자의 경우는 따로 처리 해줘야 한다.
            if(countOfCompression > 1){
                sb.append(countOfCompression).append(prevSplit);
            }else{
                sb.append(prevSplit);
            }

            // 문자열을 압축할 때 (stringLength/i), 0으로 안 나눠떨어질 경우에 대한 문자열 처리도 필요함.
            if(stringLength % i != 0){
                String currentSplit = s.substring(stringLength - (stringLength % i));
                sb.append(currentSplit); // 5 - (5%3)  = 5 - 2 = 3
            }

            // 길이가 짧은 문자열을 찾아야함.
            answer = Math.min(answer, sb.length());
            System.out.println(i+": "+sb.toString()+"("+sb.length()+")");
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution("xababcdcdababcdcd");
    }
}
