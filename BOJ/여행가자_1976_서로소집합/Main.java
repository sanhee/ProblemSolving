package com.example.BOJ.여행가자_1976_서로소집합;


/*
한국 도시 N개
임의의 두 도시 사이에 길이 있을 수 있고, 없을 수 있다.

여행 일정이 가능한 것인지

중간에 다른도시를 경유해서 여행할 수 ㅣㅇㅆ다.

 */

import java.util.Scanner;

public class Main {

    public static int N = 0; // 도시의 수
    public static int M = 0; // 여행계획에 속한 도시 수
    public static int[] parent = new int[100001]; // 부모 노드를 담기 위한 공간

    // 부모노드가 무엇인지 검사하는 메소드
    public static int findParent(int x) {
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    // 연결된 노드끼리 부모노드를 검사해서, 가장 작은 것으로 업데이트 시키는 메소드
    public static int unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();

        for(int i = 0 ; i< N ; i++){
            parent[i] = i;
        }

        // 부모노드 현재 자신 노드의 값으로 초기화
        for (int i = 0; i < N; i++) {
            String[] connectInfo = input.nextLine().split(" ");
            for (int j = 0; j < connectInfo.length; j++) {
                if (connectInfo[j].equals("0")) {
                    continue;
                }
                unionParent(i,j);
            }
        }

        boolean check = false;

        while(M-- >= 0) {

            String[] travelRoot = input.nextLine().split(" ");

            for (int k = 1; k < travelRoot.length; k++) {
                if (findParent(k - 1) != findParent(k)) {
                    check = true;
                    break;
                }
            }
        }

        if(!check){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
