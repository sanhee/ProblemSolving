
> ### 문제
 - [2019 카카오 개발자 겨울 인턴십 > 크레인 인형뽑기 게임](https://programmers.co.kr/learn/courses/30/lessons/64061)
 
> ### 소요시간
 - `💀 01:08:43` 

> ### 요약
   1. board는 N X N 배열
   1. 좌우 상관없이 Y축으로 elements가 쌓임
   1. board [가변] [고정] 으로 y축만 이동하며, x축 에서 가장 가까운 0보다 큰 값을 찾음
   1. 값이 발견되면 stack push
   1. stack에 넣기 전 stack 마지막 요소와 현재 넣을 요소를 비교해 동일할 경우 pop을 하고 push는 하지않는다. 
   
> ### 리뷰
 - for문의 break 를 깜박해서, x축 모든 유효값이 stack에 들어가 문제가 있었다.
 - stack의 lastElement 메소드를 처음 알게 되었다.
 - stack 을 자주 사용하지 않아, 필요한 메소드를 탐색하느라 시간이 소요한 것 같다.
 

> ### JAVA 풀이
```java

class Solution {

    private List<Integer> makePattern(List<Integer> patternList , Integer[] pattern, int[] answers){

        int quotient = 0;
        int remainder = 0;
        int patternLen = patternList.size();

        if(patternList.size()<answers.length){

            quotient = answers.length/patternList.size();

            while(quotient !=0){ // 몫이 1이상일 때 모든 패턴을 복사하기 위해
                if (quotient == 1) break;

                for(int i=0;i<patternLen;i++){
                    patternList.add(pattern[i]);
                }
                quotient--;
            }

            remainder =  answers.length % patternList.size(); //m 나머지 부분 더해주기

            for(int i=0;i<remainder;i++){
                patternList.add(pattern[i]);
            }
        }

        return patternList;
    }

    private int CheckScore(int[] answers, List<Integer> user) {
        int cnt = 0;

        for(int i=0;i<answers.length;i++){
            if(answers[i] == user.get(i)){ // index 랑 차이점 알아내기
                cnt++;
            }
        }
        return cnt;
    }
    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        Integer[] pattern1 = {1, 2, 3, 4, 5};
        Integer[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        Integer[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> pattern1_L = new ArrayList<>(Arrays.asList(pattern1));
        List<Integer> pattern2_L = new ArrayList<>(Arrays.asList(pattern2));
        List<Integer> pattern3_L = new ArrayList<>(Arrays.asList(pattern3));


        pattern1_L = makePattern(pattern1_L, pattern1, answers);
        pattern2_L = makePattern(pattern2_L, pattern2, answers);
        pattern3_L = makePattern(pattern3_L, pattern3, answers);


        int[] score = new int[3];
        score[0] = CheckScore(answers, pattern1_L);
        score[1] = CheckScore(answers, pattern2_L);
        score[2] = CheckScore(answers, pattern3_L);

        List<Integer> answerList = new ArrayList<>();

        int tempMax = 0;

            if ( (score[0] == score[1]) ){

                if(score[1] == score[2] ) {
                    answerList.add(1);
                    answerList.add(2);
                    answerList.add(3);

                }
                else if(score[1] > score[2]){
                    answerList.add(1);
                    answerList.add(2);
                }
                else if(score[1] < score[2]){
                    answerList.add(3);
                }
            }

            if(score[0] > score[1])  {
                if(score[0] > score[2]){
                    answerList.add(1);
                }
                else if(score[0] == score[2]){
                    answerList.add(1);
                    answerList.add(3);
                }
                else if(score[0] < score[2]){
                    answerList.add(3);
                }
            }

            else if (score[0] < score[1]){

                if(score[1] == score[2]){
                    answerList.add(2);
                    answerList.add(3);
                }
                else if(score[1] < score[2]){
                    answerList.add(3);
                }

            }


        answer = new int[answerList.size()];

        int size = 0;
        for(int i : answerList){
            answer[size++] = i;
        }

        System.out.println(Arrays.toString(answer));

        Arrays.sort(answer); // 배열 정렬

        return answer;
    }



    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};

        new Solution().solution(answers);

    }
}



```