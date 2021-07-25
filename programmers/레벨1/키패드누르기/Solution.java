package com.noeul.programmers.레벨1.키패드누르기;

// 01:49 ~

import java.util.Locale;

public class Solution {
    private static boolean isLeftLine(int number){
        switch (number){
            case 1:
            case 4:
            case 7:
                return true;
            default:
                return false;
        }
    }
    private static boolean isRightLine(int number){
        switch (number){
            case 3:
            case 6:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public int[] getPosition(int number){
        int[][] keypads = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};

        for(int row = 0; row < keypads.length; row++){
            for (int col = 0; col < keypads[0].length; col++){
                if(keypads[row][col] == number){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1}; // 올일 없음.
    }

    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        int[] leftPosition = new int[]{3,0}; // *
        int[] rightPosition = new int[]{3,2}; // #

        for(int num : numbers){
          if(isLeftLine(num)){
              answer.append("L");
              leftPosition = getPosition(num);
          }else if(isRightLine(num)){
              answer.append("R");
              rightPosition = getPosition(num);
          }else{ // 중간 라인 (2,5,8,0)
              int[] numberPosition = getPosition(num);

              // 직선의 방정식
              double op1 = Math.pow(numberPosition[0] - leftPosition[0],2);
              double op2 = Math.pow(numberPosition[1] - leftPosition[1],2);
              double leftDiff = Math.sqrt(op1+op2);

              op1 = Math.pow(numberPosition[0] - rightPosition[0],2);
              op2 = Math.pow(numberPosition[1] - rightPosition[1],2);
              double rightDiff = Math.sqrt(op1+op2);


              // 만약 두 엄지손가락의 거리가 같다면
              if(leftDiff == rightDiff){
                  if(hand.equals("left")){
                      answer.append("L");
                      leftPosition = getPosition(num);
                  }else{
                      answer.append("R");
                      rightPosition = getPosition(num);
                  }
              }
              else if(leftDiff < rightDiff){
                  answer.append("L");
                  leftPosition = getPosition(num);
              }else if(leftDiff > rightDiff){
                  answer.append("R");
                  rightPosition = getPosition(num);
              }
          }
        }
        return answer.toString();
    }
}
