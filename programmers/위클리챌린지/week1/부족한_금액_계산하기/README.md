
# [부족한 금액 계산하기](https://programmers.co.kr/learn/courses/30/lessons/82612)

- 복잡하고, 비효율적으로 푼 듯..

```java
import java.util.*;

class Solution {
    public long cal(int originPrice, int price, int count, long total){
        if(count == 0){
            return total;
        }
        int calPrice = originPrice+price;
        total += calPrice;
        return cal(originPrice, calPrice, --count, total);
    }

    public long solution(int price, int money, int count) {

        long totalPrice = cal(price, 0, count, 0);

        if((long)money > totalPrice){
            return 0;
        }
        return Math.abs((long)money-totalPrice);
    }
}

```

## 다른 사람 풀이

```java
class Solution {

    public long solution(int price, int money, int count) {

        long answer = money;

        for (int cnt = 0; cnt < count; ++cnt) {
            answer -= (price * (cnt + 1));
        }

        return (answer > 0 ? 0 : -answer);
    }
}
```


- 이건..못 써먹을 거 같다..

```java
class Solution {
    public long solution(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}
```