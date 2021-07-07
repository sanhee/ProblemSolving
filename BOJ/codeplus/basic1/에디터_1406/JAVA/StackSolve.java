package com.example.BOJ.codeplus.basic1.에디터_1406.JAVA;

import java.io.*;
import java.util.Stack;

/**
 * Created by 68936@naver.com on 2021-03-13 오전 7:49
 * Blog : https://velog.io/@san
 * Github : https://github.com/sanhee
 */
public class StackSolve {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>(); // 커서를 기준으로 왼쪽에 있는 문자열을 저장하는 공간
        Stack<Character> rightStack = new Stack<>();

        char[] inputString = br.readLine().toCharArray();

        for (char c : inputString) {
            leftStack.push(c);  //m 첫 커서가 문자열 맨 오른쪽에 위치한다고 하였으므로,
        }

        int testcaseCount = Integer.parseInt(br.readLine());

        while (testcaseCount-- > 0) {  //m 0이하가 될 경우 벗어나는 루프

            String inputCommand = br.readLine();  // ex)  P x

            switch (inputCommand.charAt(0)) {

                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop()); // 커서를 기준으로 좌우의 문자들이 중심이 돼야하므로, 커서가 왼쪽으로 움직이면 leftStack 맨 위 요소가 rightStack에 올라가야한다.
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop()); //커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    }
                    break;
                case 'B': // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    leftStack.push(inputCommand.charAt(2));
                    break;
                default:
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop()); // LEFT STACK 맨 하단이 문자열의 첫번째 출력이 돼야하므로,
        }
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());  //m 우측스택은 최상단에 있는 것이 출력 기준이므로, 따로 리버스를 해줄 필요가 없다.
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
