package com.example.파이썬알고리즘인터뷰._12장_그래프;

import java.util.*;

public class 순열 {

    private List<Integer> prevElements;
    private List<List<Integer>> results;

    public List<List<Integer>> permute(int[] nums) {
        prevElements = new ArrayList<>();
        results = new ArrayList<>();
        List<Integer> elements = new ArrayList<>(nums.length);

        for (int n : nums) {
            elements.add(n);
        }

        dfs(elements);
        return results;
    }

    private void dfs(List<Integer> elements) {

        // 리프 노드일 때 결과 추가
        if (elements.size() == 0) {
            results.add(prevElements);
        }

        // 순열 생성 재귀 호출
        for (Integer e : elements) {
            List<Integer> nextElements = new ArrayList<>(elements);

            nextElements.remove(e);

            prevElements.add(e);
            dfs(nextElements);
            prevElements.remove(prevElements.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 순열().permute(new int[]{1, 2, 3}));
    }
}
