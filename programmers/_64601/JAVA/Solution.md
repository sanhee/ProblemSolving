
> ### 문제
 - [바로가기](https://programmers.co.kr/learn/courses/30/lessons/64061)
 
 
> ### 요약
   1. board는 N X N 배열
   1. 좌우 상관없이 Y축으로 elements가 쌓임
   1. board [가변] [고정] 으로 y축만 이동하며, x축 에서 가장 가까운 0보다 큰 값을 찾음
   1. 값이 발견되면 stack push
   1. stack에 넣기 전 stack 마지막 요소와 현재 넣을 요소를 비교해 동일할 경우 pop을 하고 push는 하지않는다. 
   
  
> ### JAVA 풀이
```java

public class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int moveLength = moves.length;
        int yLen = board.length;
        Stack<Integer> stack = new Stack<>();

        for(int m=0; m<moveLength; m++){

            int selectPos = moves[m]-1;

            for(int y=0;y<yLen;y++){

                if(board[y][selectPos] > 0) { //m 값이 존재할 경우

                    if(!stack.empty() && (stack.lastElement() == board[y][selectPos])){
                        stack.pop();
                        answer +=2;
                    }
                    else {
                        stack.push(board[y][selectPos]);
                    }
                    board[y][selectPos] = 0;

                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {  

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int expect = 4;

        int answer = new Solution().solution(board,moves) == expect ? 1 : -1 ;

        System.out.println(answer);
    }

}


```