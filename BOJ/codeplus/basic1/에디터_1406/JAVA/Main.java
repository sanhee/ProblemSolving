package com.example.BOJ.codeplus.basic1.에디터_1406.JAVA;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> inputCharacterList = new LinkedList<>();

        char[] inputArray = br.readLine().toCharArray();
        for(Character c : inputArray){
            inputCharacterList.add(c);
        }
        int cursor = inputCharacterList.size(); //m 명령어가 수행되기 전에 커서는 문장의 [맨 뒤]에 위치
        int commandCount = Integer.parseInt(br.readLine());

        while(commandCount-- > 0){
            //char[] arrayCommand = br.readLine().toCharArray();
            char[] arrayCommand = br.readLine().toCharArray();

            switch (arrayCommand[0]){
                case 'L':  //m 커서를 [왼쪽]으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if(cursor <= 0 ){
                        cursor = -1;
                        break;
                    }
                    cursor--;
                    break;
                case 'D': //m 커서를 [오른쪽]으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if(cursor >= inputCharacterList.size() ){  //m 이부분을 잘못 생각해서 한참 헤맸다. 쓸데없이 초기 문자열 최대 크기를 구하는 바람에...
                        break;                                //m cursor = originMaxFigureOfString; 과거 문자열 최대 크기에서 움직이는 실수를 했다..
                    }
                    cursor++;
                    break;
                case 'B': //m 커서 [왼쪽]에 있는 문자를 [삭제]함 (커서가 문장의 맨 앞이면 무시됨)
                    if(cursor <= 0){
                        cursor = 0;

                        break;
                    }
                    if(cursor >= inputCharacterList.size()){
                        inputCharacterList.remove(inputCharacterList.size()-1);
                        --cursor;
                        break;
                    }
                    inputCharacterList.remove(--cursor);
                    break;
                case 'P': //m $라는 문자를 커서 [왼쪽]에 추가함
                    inputCharacterList.add(cursor,arrayCommand[2]); //m 이부분도 잘못 생각해서 한참 해맷다.
                                                                    //m List의 add 함수는 index에 데이터를 넣고, 기존 데이터를 뒤로 밀어내기 때문에
                                                                    //m 커서가 위치한 곳에 데이터를 추가해야, 커서 왼쪽에 문자가 추가된 것처럼 보일 수 있다.
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

