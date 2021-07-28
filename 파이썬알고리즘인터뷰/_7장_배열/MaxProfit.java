package com.example.파이썬알고리즘인터뷰._7장_배열;

public class MaxProfit {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int minPrice = Integer.MAX_VALUE;


        for (int i = 0; i < prices.length; i++) {


            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);

        }

        return profit;

    }
}
