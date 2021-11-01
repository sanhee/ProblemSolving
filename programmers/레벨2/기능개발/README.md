

# [기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586)

## 복습1 - 2021.11.02 : 41분 소요..
```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int remainProgress = 100 - progresses[i];
            int remainDay = 0;

            if (remainProgress % speeds[i] == 0) {
                remainDay = remainProgress / speeds[i];
            } else {
                remainDay = remainProgress / speeds[i] + 1;
            }
            queue.add(remainDay);
        }

        while (!queue.isEmpty()){
            int peek = queue.peek();
            int count = 0;

            while (!queue.isEmpty() && queue.peek() <= peek){
                ++count;
                queue.poll();
            }
            answerList.add(count);
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

}

```