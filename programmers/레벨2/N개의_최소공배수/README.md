
# [N개의 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12953)

## gcd 구현
- 유클리드 호제법

```java
public class Solution {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
}
```

## gcd 라이브러리 이용

```java

import java.math.BigInteger;

class Solution {
    public static int lcm(int a, int b){
        BigInteger a1 = BigInteger.valueOf(a);
        BigInteger b1 = BigInteger.valueOf(b);

        int gcd = Integer.parseInt(String.valueOf(a1.gcd(b1)));
        return a*b/Integer.parseInt(String.valueOf(gcd));
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
}

```