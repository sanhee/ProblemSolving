# [입국심사](https://programmers.co.kr/learn/courses/30/lessons/43238?language=java)

## 참고풀이
- Parametric Search를 활용한 이분탐색 
  
- 원래문제: 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
- 리버스: 시간을 최소로 할 때, 모든 사람이 심사를 받을 수 있나?
  - yeeeeeeeees/noooooooo 가능

```java
import java.util.Arrays;

class Solution {
  public long solution(int n, int[] times) {
    return search(n, times);
  }

  private long search(int n, int[] times) {
    // 이분탐색을 위한 정렬
    Arrays.sort(times);

    // 최소 시간을 탐색 (Parametric Search)
    long left = 0;
    // 최악의 경우
    long right = (long) n * times[times.length - 1];

    long answer = 0;

    while (left <= right) {
      long minTime = (left + right) / 2;
      long result = 0;

      for (int i = 0; i < times.length; i++) {
        result += minTime / times[i];
      }

      // 시간이 부족한 경우
      if(result < n){
        left = minTime+1;
      }else{
        right = minTime-1;
        answer = minTime;
      }
    }
    return answer;
  }

}
```
