

# [입국심사](https://programmers.co.kr/learn/courses/30/lessons/43238?language=java)

## 첫 시도(실패)

- 해쉬맵(시간, 기다려야 하는시간) 으로 관리해서, 키, 밸류를 합했을 때 가장 적은 시간이 걸리는 상담사를
  연결시켜주는 방식을 생각했는데 기본 케이스만 통과하고 실패했다.

- 제한조건도 전혀 고려하지 못해서 int로 사용했고, 엄청나게 비효율적인 코드
  ![img.png](img.png)



```java
public class Solution {
    private int process(int n, int[] times) {
        int answerTime = 0;
        Map<Integer, Integer> timeMap = new HashMap<>();

        int length = times.length;

        // map [시간, 기다려야 하는 시간]
        for (int time : times) {
            timeMap.put(time, time);
        }

        for (int person = length + 1; person <= n; person++) {

            Map.Entry<Integer, Integer> minMap = timeMap.entrySet()
                    .stream()
                    .min(Comparator.comparingInt(obj -> (obj.getValue() + obj.getKey())))
                    .get();

            int temp = minMap.getValue();
            answerTime += temp;

            for (int time : times) {
                if (time == minMap.getKey()) {
                    timeMap.put(time, time);
                } else {
                    int value = timeMap.get(time);
                    timeMap.put(time, Math.abs(value - temp));
                }
            }

            if(person == n){
                answerTime += minMap.getKey();
            }
        }

        return answerTime;
    }

    public long solution(int n, int[] times) {
        return process(n, times);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(new Solution().solution(n, times));
    }
}


```


## 다른 사람 풀이
- 진짜 이런 컨셉 전혀 생각 못한게 아쉽다...

```java
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = 0;
        long mid;

        for (int time : times) {
            if (time > right) {
                right = time;
            }
        }

        right *= n;

        while (left <= right) {
            long done = 0;
            mid = (left + right) / 2;

            for (int time : times) {
                done += mid / time;
            }

            if (done < n) {
// 해당 시간동안 심사를 다 하지 못한 경우
                left = mid + 1;
            }
            else {
// 시간이 여유있거나, 딱 맞는 경우
                if (mid < answer) {
// 가장 타이트한 시간을 찾아야 하므로
                    answer = mid;
                }

                right = mid - 1;
            }
        }

        return answer;
    }
}
```
