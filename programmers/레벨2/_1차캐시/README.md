
# [[1차] 캐시](https://programmers.co.kr/learn/courses/30/lessons/17680)

```java

public class Solution {
    public int solution(int cacheSize, String[] cities) {

        final int cacheHitTime = 1;
        final int cacheMissTime = 5;

        int executeTime = 0;

        if (cacheSize == 0) {
            return cities.length * cacheMissTime;
        }

        Deque<String> cache = new ArrayDeque<>();


        for (String city : cities) {

            city = city.toUpperCase();

            if (cache.contains(city)) {
                executeTime += cacheHitTime;
                cache.remove(city);
                cache.add(city);
            } else if (cache.size() == cacheSize) {
                cache.pollFirst();
                cache.add(city);
                executeTime += cacheMissTime;
            } else {
                cache.add(city);
                executeTime += cacheMissTime;
            }

        }

        return executeTime;
    }

}
```