package com.example.BOJ.codeplus.basic1.에디터_1406.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> inputCharacterList = new LinkedList<>();

        char[] inputArray = br.readLine().toCharArray();
        for(Character c : inputArray){
            inputCharacterList.add(c);
        }
        int originMaxFigureOfString = inputCharacterList.size();
        int cursor = inputCharacterList.size()+1; //m 명령어가 수행되기 전에 커서는 문장의 [맨 뒤]에 위치
        int commandCount = Integer.parseInt(br.readLine());

        while(commandCount-- > 0){
            char[] arrayCommand = br.readLine().toCharArray();

            switch (arrayCommand[0]){
                case 'L':  //m 커서를 [왼쪽]으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if(cursor <= 0 ){
                        cursor = 0;
                        break;
                    }
                    cursor--;
                    break;
                case 'D': //m 커서를 [오른쪽]으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if(cursor >= originMaxFigureOfString ){
                        cursor = originMaxFigureOfString;
                        break;
                    }
                    cursor++;
                    break;
                case 'B': //m 커서 [왼쪽]에 있는 문자를 [삭제]함 (커서가 문장의 맨 앞이면 무시됨)
                    if(cursor <= 0 ){
                        cursor = 0;
                        break;
                    }
                    inputCharacterList.remove(--cursor);
                    break;
                case 'P': //m $라는 문자를 커서 [왼쪽]에 추가함
                    if(cursor <= 0){
                        cursor = 0;
                        break;
                    }
                    inputCharacterList.add(cursor-1,arrayCommand[2]);
                    cursor++;
                    break;
            }
        }

        for(char c : inputCharacterList) {
            bw.write(c);
        }
        bw.flush();

        br.close();
        bw.close();
    }
}

