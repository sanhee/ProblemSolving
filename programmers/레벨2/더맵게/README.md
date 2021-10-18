
# [더 맵게](https://programmers.co.kr/learn/courses/30/lessons/42626)

# 내 풀이 (실패)
- 문제를 너무 어렵게 생각했다..

```java
public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 스코빌 지수가 낮은 음식의 마지막 인덱스를 구해옴 (오름차순, 이분탐색)
        int range = search(scoville, K);

        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 조기 리턴
        if (range == 0) {
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] copiedArray = Arrays.copyOf(scoville, range+1);

        for(int element : copiedArray){
            queue.add(element);
        }

        int count = 0;
        while (!queue.isEmpty()){
            int poll = 0;
            int poll2 = 0;

            // 오름차순으로 정렬돼있는 큐의 가장 앞에 있는 요소가 타겟보다 크다면, 모든 요소가 크다는 것을 알 수 있음
            if(queue.peek() >= K){
                break;
            }

            poll = queue.poll();

            if(!queue.isEmpty()){
                poll2 = queue.poll();
            }
            else{
                // queue에서 꺼낸 타겟보다 작은 요소가 있는데, 다음 요소가 없을 경우 크게 만들 방법이 없음
                return -1;
            }

            int mixed = poll + (poll2 * 2);

            // 섞었는데도 타겟보다 작을 경우 다시 큐에 넣음
            if(mixed < K){
                queue.add(mixed);
            }

            count++;
        }

        return count;
    }

    private int search(int[] scoville, int target) {
        Arrays.sort(scoville);

        int left = 0;
        int right = scoville.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;
            if (scoville[middle] < target) {

                return middle;

            } else {
                right = middle - 1;
            }
        }

        return 0;
    }
}

```

# 참고 풀이

```java
public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int e : scoville) {
            heap.add(e);
        }

        int count = 0;
        while (!heap.isEmpty() && heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }

            int operand1 = heap.poll();
            int operand2 = heap.poll();

            int mixed = operand1 + (operand2 * 2);
            heap.add(mixed);

            count++;
        }
        return count;
    }
}
```