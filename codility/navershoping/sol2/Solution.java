package com.example.codility.navershoping.sol2;

import java.util.*;

public class Solution {

    /**
     * 문제 해결 함수:
     * 주어진 메뉴, 주문 정보를 기반으로 4가지 할인+무할인 중 최저 결제 금액을 계산한다.
     */
    public int solution(Pizza[] menu, OrderItem[] order) {
        Map<String, Pizza> pizzaMenuMap = new HashMap<>();
        for (Pizza p : menu) {
            pizzaMenuMap.put(p.name, p);
        }

        int costNoDiscount = calcNoDiscount(pizzaMenuMap, order);
        int costDiscount1 = calcDiscountBuy3GetTheCheapestOneIsFree(pizzaMenuMap, order);
        int costDiscount2 = calcDiscountBuy5For100(pizzaMenuMap, order);
        int costDiscount3 = calcDiscountForEveryLargePizzaGetFreeSmallOne(pizzaMenuMap, order);
        int costDiscount4 = calcDiscountBuy3LargePayFor3Medium(pizzaMenuMap, order);

        return Arrays.stream(new int[] {
                costNoDiscount,
                costDiscount1,
                costDiscount2,
                costDiscount3,
                costDiscount4
        }).min().orElse(0);
    }

    /**
     * 0) 무할인일 때의 총 비용 계산
     */
    private int calcNoDiscount(Map<String, Pizza> pizzaMenuMap, OrderItem[] order) {
        int total = 0;
        for (OrderItem orderItem : order) {
            int price = getPizzaPrice(pizzaMenuMap, orderItem.name, orderItem.size);
            total += price * orderItem.quantity;
        }
        return total;
    }

    /**
     * 1) "3개 구매 시 가장 싼 피자 1개 무료" 할인 적용
     */
    private int calcDiscountBuy3GetTheCheapestOneIsFree(Map<String, Pizza> pizzaMenuMap, OrderItem[] order) {
        List<Integer> pizzaPriceList = new ArrayList<>();
        for (OrderItem orderItem : order) {
            int pizzaPrice = getPizzaPrice(pizzaMenuMap, orderItem.name, orderItem.size);
            for (int i = 0; i < orderItem.quantity; i++) {
                pizzaPriceList.add(pizzaPrice);
            }
        }

        if (pizzaPriceList.size() < 3) {
            return calcNoDiscount(pizzaMenuMap, order);
        }

        Collections.sort(pizzaPriceList);

        pizzaPriceList.remove(0);

        int total = 0;
        for (int price : pizzaPriceList) {
            total += price;
        }
        return total;
    }

    /**
     * 2) "5개 구매 시 총 100원" 할인 적용
     *    - 이름별로 5개 이상인 경우를 찾아 그 5개를 100원으로 계산하는 경우 중 최저 비용을 찾음.
     *    - 5개 이상인 피자가 여러 종류라면, 각각 시도해 보고 가장 저렴한 경우 택하기.
     *    - 만약 5개 이상인 피자가 없다면 무할인 처리.
     */
    private int calcDiscountBuy5For100(Map<String, Pizza> pizzaMenuMap, OrderItem[] order) {
        Map<String, List<Integer>> pizzaNameToPriceListMap = new HashMap<>();

        int noDiscountCost = calcNoDiscount(pizzaMenuMap, order);

        for (OrderItem orderItem : order) {
            int unitPrice = getPizzaPrice(pizzaMenuMap, orderItem.name, orderItem.size);
            pizzaNameToPriceListMap.putIfAbsent(orderItem.name, new ArrayList<>());
            for (int i = 0; i < orderItem.quantity; i++) {
                pizzaNameToPriceListMap.get(orderItem.name).add(unitPrice);
            }
        }

        int minCost = noDiscountCost;

        for (Map.Entry<String, List<Integer>> entry : pizzaNameToPriceListMap.entrySet()) {
            List<Integer> priceList = entry.getValue();
            if (priceList.size() < 5) {
                continue;
            }

            priceList.sort(Collections.reverseOrder());

            int sumTop5 = 0;
            for (int i = 0; i < 5; i++) {
                sumTop5 += priceList.get(i);
            }

            int discountAmount = sumTop5 - 100;

            int totalCost = noDiscountCost - discountAmount;

            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

    /**
     * 3) "Large 피자 구매 시 같은 이름의 Small 피자 1개 무료" 할인
     *    - 한 이름에 대하여 Large 개수(L)와 Small 개수(S)가 있을 때,
     *      그 중 min(L, S)개 Small을 0원 처리.
     */
    private int calcDiscountForEveryLargePizzaGetFreeSmallOne(Map<String, Pizza> pizzaMenuMap, OrderItem[] order) {
        Map<String, Integer> largePizzaCountMap = new HashMap<>();
        Map<String, Integer> smallPizzaCountMap = new HashMap<>();

        int noDiscountCost = 0;

        for (OrderItem orderItem : order) {
            int unitPrice = getPizzaPrice(pizzaMenuMap, orderItem.name, orderItem.size);
            noDiscountCost += unitPrice * orderItem.quantity;

            if ("Large".equals(orderItem.size)) {
                largePizzaCountMap.put(orderItem.name, largePizzaCountMap.getOrDefault(orderItem.name, 0) + orderItem.quantity);
            } else if ("Small".equals(orderItem.size)) {
                smallPizzaCountMap.put(orderItem.name, smallPizzaCountMap.getOrDefault(orderItem.name, 0) + orderItem.quantity);
            }
        }

        int totalDiscount = 0;
        for (String name : smallPizzaCountMap.keySet()) {
            int smallPizzaCount = smallPizzaCountMap.get(name);
            int largePizzaCount = largePizzaCountMap.getOrDefault(name, 0);
            int smallFreeCount = Math.min(smallPizzaCount, largePizzaCount);

            // freeCount만큼 Small 가격이 무료
            int smallPrice = pizzaMenuMap.get(name).price_S;
            totalDiscount += (smallPrice * smallFreeCount);
        }

        return noDiscountCost - totalDiscount;
    }

    /**
     * 4) "Buy 3 Large, pay for 3 Medium" 할인
     *    - 주문 전체에서 Large 피자가 총 3개 이상이면,
     *      그 중 3개를 Medium 가격으로 계산(가장 할인 폭이 큰 Large 3개를 골라야 함).
     */
    private int calcDiscountBuy3LargePayFor3Medium(Map<String, Pizza> pizzaMenuMap, OrderItem[] order) {
        int noDiscountCost = calcNoDiscount(pizzaMenuMap, order);

        List<Integer> priceDiffList = new ArrayList<>();
        int largeCountTotal = 0;

        for (OrderItem o : order) {
            if ("Large".equals(o.size)) {
                largeCountTotal += o.quantity;
                int priceLarge = pizzaMenuMap.get(o.name).price_L;
                int priceMedium = pizzaMenuMap.get(o.name).price_M;
                int priceDiff = priceLarge - priceMedium;

                for (int i = 0; i < o.quantity; i++) {
                    priceDiffList.add(priceDiff);
                }
            }
        }

        if (largeCountTotal < 3) {
            return noDiscountCost;
        }

        priceDiffList.sort(Collections.reverseOrder());
        int discountSum = priceDiffList.get(0) + priceDiffList.get(1) + priceDiffList.get(2);

        return noDiscountCost - discountSum;
    }

    /**
     * 사이즈 문자열("Small"/"Medium"/"Large")에 따라 실제 가격을 반환
     */
    private int getPizzaPrice(Map<String, Pizza> pizzaMenuMap, String pizzaName, String size) {
        Pizza p = pizzaMenuMap.get(pizzaName);
        switch (size) {
            case "Small":
                return p.price_S;
            case "Medium":
                return p.price_M;
            case "Large":
                return p.price_L;
        }
        // 문제 정의 바깥의 입력은 없다고 가정
        return 0;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        // === 테스트 케이스 1 ===
        {
            Pizza[] menu1 = {
                    new Pizza() {{
                        name = "greek";
                        price_S = 7;
                        price_M = 5;
                        price_L = 10;
                    }},
                    new Pizza() {{
                        name = "texas";
                        price_S = 8;
                        price_M = 9;
                        price_L = 13;
                    }},
                    new Pizza() {{
                        name = "european";
                        price_S = 5;
                        price_M = 10;
                        price_L = 13;
                    }}
            };

            OrderItem[] order1 = {
                    new OrderItem() {{
                        name = "texas";
                        size = "Medium";
                        quantity = 1;
                    }},
                    new OrderItem() {{
                        name = "european";
                        size = "Small";
                        quantity = 2;
                    }}
            };

            int result1 = sol.solution(menu1, order1);
            System.out.println("[Discount 1 Example] Expected=14, Got=" + result1);
        }

        // === 테스트 케이스 2 ===
        {
            Pizza[] menu2 = {
                    new Pizza("margherita", 90, 80, 100),
                    new Pizza("hawaii", 80, 90, 120),
                    new Pizza("capricciosa", 50, 70, 130),
                    new Pizza("greek", 50, 70, 130)
            };
            OrderItem[] order2 = {
                    new OrderItem("greek", "Small", 5),
                    new OrderItem("margherita", "Small", 4),
                    new OrderItem("hawaii", "Large", 1),
                    new OrderItem("margherita", "Medium", 2),
                    new OrderItem("capricciosa", "Small", 7)
            };
            int result2 = sol.solution(menu2, order2);
            System.out.println("[Discount 2 Example] Expected=900, Got=" + result2);
        }

        // === 테스트 케이스 3 ===

        {
            Pizza[] menu3 = {
                    new Pizza("margherita", 7, 8, 10),
                    new Pizza("hawaii", 8, 9, 12),
                    new Pizza("capricciosa", 5, 7, 13)
            };
            OrderItem[] order3 = {
                    new OrderItem("margherita", "Small", 3),
                    new OrderItem("capricciosa", "Large", 2),
                    new OrderItem("hawaii", "Large", 3),
                    new OrderItem("margherita", "Large", 1),
                    new OrderItem("hawaii", "Medium", 1),
                    new OrderItem("capricciosa", "Small", 5),
                    new OrderItem("capricciosa", "Medium", 1),
            };
            int result3 = sol.solution(menu3, order3);
            System.out.println("[Discount 3 Example] Expected=117 Got=" + result3);
        }

        // === 테스트 케이스 4 ===

        {
            Pizza[] menu4 = {
                    new Pizza("boston", 7, 5, 10),
                    new Pizza("hawaii", 8, 9, 12),
                    new Pizza("newyorker", 8, 9, 130),
                    new Pizza("philadelphia", 5, 10, 13)
            };
            OrderItem[] order4 = {
                    new OrderItem("boston", "Small", 3),
                    new OrderItem("hawaii", "Large", 3),
                    new OrderItem("newyorker", "Large", 1),
                    new OrderItem("boston", "Large", 2),
                    new OrderItem("philadelphia", "Large", 2)
            };
            int result4 = sol.solution(menu4, order4);
            System.out.println("[Discount 4 Example] Expected=102, Got=" + result4);
        }

        // === 테스트 케이스 5 ===

        {
            Pizza[] menu5 = {
                    new Pizza("margherita", 7, 8, 10),
                    new Pizza("hawaii", 8, 9, 12),
                    new Pizza("capricciosa", 5, 7, 13)
            };
            OrderItem[] order5 = {
                    new OrderItem("margherita", "Small", 1),
                    new OrderItem("hawaii", "Large", 1),


            };
            int result5 = sol.solution(menu5, order5);
            System.out.println("[Discount 5 Example] Expected=19, Got=" + result5);
        }
    }

    /**
     * 피자 하나의 가격 정보를 담는 클래스(문제에서 주어진 그대로)
     */
    public static class Pizza {
        public String name;
        public int price_S;
        public int price_M;
        public int price_L;

        public Pizza(String name, int price_S, int price_M, int price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }

        public Pizza() {

        }
    }

    /**
     * 주문 항목 정보를 담는 클래스(문제에서 주어진 그대로)
     */
    public static class OrderItem {
        public String name;
        public String size;  // "Small", "Medium", "Large"
        public int quantity;

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }

        public OrderItem() {

        }
    }
}
