
# [H-Index](https://programmers.co.kr/learn/courses/30/lessons/42747)


## 나의 풀이(첫시도, 실패)

### 생각흐름
```text
goal : h
[3, 0, 6, 1, 5]
h=0: 인용 횟수 x
h=1: 5편 중, h=1, h이상 인용:4, h이하 인용: 1
h=3: 5편 중, h=3, h이상 인용:3, h이하 인용: 2
h=5; 5편 중, h=5, h이상 인용:2, h이하 인용: 3
h=6; 5편 중, h=6, h이상 인용:1, h이하 인용: 4

1. 0을 제외 하고, 리스트에 담음
2. 리스트의 최대 길이름 구함
  - (1,3,5,6)
  - max: 4
3-1. h= 리스트 순회하면서 대입
3-2. h 이상 인용 = max - (현재 리스트의 인덱스+1) +1
3-3. h 이하 인용 = 현재 리스트의 인덱스+1
4. h 이하 인용 <= h <= h 이상 인용 이라면 answer 변수에 math.max로 넣음
```


```java
public class Solution {
    public int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);

        List<Integer> list = new ArrayList<>();

        for(int c : citations){
            if(c > 0){
                list.add(c);
            }
        }

        int answer = 0;

        for(int h : list){
            int above = list.size() - (list.indexOf(h)+1) + 1;
            int below = list.indexOf(h)+1;

            if(below <= h && h <= above){
                answer = Math.max(answer, h);
            }
        }

        return answer;
    }
}

```



## 2차 시도

```text
1. 생각못한 케이스 [1,1,1]
-  인덱스로 제어하다보니..

2. 조건 잘못 했었음
 - 카운트로 해야함
 
if(below <= h && above <= h){
    answer = Math.max(answer, above);
}

```


```java

public class Solution {
    public int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);

        List<Integer> list = new ArrayList<>();
        List<Integer> history = new ArrayList<>();

        for (int c : citations) {
            if (c > 0) {
                list.add(c);
            }
        }

        int answer = 0;

        for (int h : list) {
            if (history.contains(h)) {
                continue;
            }
            history.add(h);

            int above = list.size() - (list.indexOf(h) + 1) + 1;
            int below = list.indexOf(h) + 1;

            // what?
            if (below <= h && above <= h) {
                answer = Math.max(answer, above);
            }
        }

        return answer;
    }
}
```