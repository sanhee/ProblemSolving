package com.example.BOJ.codeplus.basic1.에디터_1406.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Character> inputCharacterArrayList = new ArrayList<>(); // 순차저장 장점

        char[] inputCharArray = br.readLine().toCharArray();
        for (Character c : inputCharArray) {
            inputCharacterArrayList.add(c);
        }

        int commandCount = Integer.parseInt(br.readLine());
        ListIterator<Character> cursor = inputCharacterArrayList.listIterator();
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

        for (Character c : inputCharacterArrayList) {
            bw.write(c);
        }
        bw.flush();

        br.close();
        bw.close();

    }
}

