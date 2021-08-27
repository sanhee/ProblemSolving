
# [다음 큰 숫자](https://programmers.co.kr/learn/courses/30/lessons/12911)
```java
public class Solution {
    public int solution(int n) {
        int answer = 0;

        final int bitCount = Integer.bitCount(n);
        int nextBitCount = Integer.bitCount(n+1);
        String bit = Integer.toBinaryString(n+1);

        for (int i = n + 2; nextBitCount != bitCount; i++) {
            nextBitCount = Integer.bitCount(i);
            bit = Integer.toBinaryString(i);
        }

        return Integer.parseInt(bit, 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(78));
    }
}
```