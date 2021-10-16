

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
         Arrays.sort(times);
         long min=1;//최적의 경우 1초로 초기화
         long max=(long)times[times.length-1]*n;//최악의 경우로 초기화
         long mid=0;
         long sum;
         long answer = max;
         while(min<=max){
             sum=0;
             mid=(min+max)/2;
             for(int time:times){
                 sum+=mid/time;//심사관 당 맡을 수 있는 입국자 수
             }
             if(sum>=n){//더 맡을 수 있으므로 시간 줄임
                 if(mid<answer){
                     answer=mid;
                 }
                 max=mid-1;                
             }
             else{//불가하므로 시간 늘림
                 min=mid+1;
             }
         }
         return answer;
     }
 }
```
