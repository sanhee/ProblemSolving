package com.example.BOJ.codeplus.basic1.에디터_1406.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> inputCharacterList = new LinkedList<>(); // LinkedList는 이전 노드와 다음 노드를 참조하는 상태만 변경하면 되기 때문 O(1) 복잡도

        char[] inputArray = br.readLine().toCharArray(); // charAt와 속도차이는 안나는거 같다.
        for (Character c : inputArray) {
            inputCharacterList.add(c);
        }

        int commandCount = Integer.parseInt(br.readLine());
        ListIterator<Character> cursor = inputCharacterList.listIterator();
        while (cursor.hasNext()) {
            cursor.next(); //m 명령어가 수행되기 전에 커서는 문장의 [맨 뒤]에 위치
        }

        while (commandCount-- > 0) {
            String stringCommand = br.readLine(); // 굳이 필요없는 char array를 제거
            switch (stringCommand.charAt(0)) {
                case 'L':  //m 커서를 [왼쪽]으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case 'D': //m 커서를 [오른쪽]으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case 'B': //m 커서 [왼쪽]에 있는 문자를 [삭제]함 (커서가 문장의 맨 앞이면 무시됨)
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P': //m $라는 문자를 커서 [왼쪽]에 추가함
                    cursor.add(stringCommand.charAt(2));
                    break;
            }
        }

        for (Character c : inputCharacterList) {
            bw.write(c);
        }
        bw.flush();

        br.close();
        bw.close();

    }
}

