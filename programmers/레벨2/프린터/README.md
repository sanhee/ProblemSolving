

#[프린터](https://programmers.co.kr/learn/courses/30/lessons/42587#)
- 와,,,뭔가 억울하면서 멍청하다.
- 한 3개월전에 풀었을 때, 문제 이해를 제대로 못하고 잘못된 테스트케이스를 넣어놨는데 너무 오래전이라 커스텀 케이스가 있는줄 몰랐다..
- 커스텀케이스가 본 테스트케이스인줄 알고 문제가 너무 이해 안돼서 돌아가는 코드 3시간 가량 고치고 있었다............

```java
public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer[]> printQueue = new LinkedList<>();
        List<Integer[]> printList = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            Integer[] temp = new Integer[2];
            temp[0] = priorities[i];
            temp[1] = i;
            printQueue.add(temp);
        }


        while (!printQueue.isEmpty()) {
            Integer[] peek = printQueue.peek();

            // 자기보다 우선순위 큰게 있다면
            if (!check(peek[0], Arrays.copyOf(priorities, priorities.length))) {
                // 큐 맨뒤로 삽입
                printQueue.add(printQueue.poll());
            }else{
                priorities[peek[1]] = -1;
                printList.add(printQueue.poll());
            }
        }

        int index = 1;
        for (Integer[] poll : printList) {
            if (poll[1] == location) {
                answer = index;
            }
            index++;
        }

        return answer;

    }

    private boolean check(int target, int[] priorities) {
        Arrays.sort(priorities);

        int left = 0;
        int right = priorities.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (priorities[middle] <= target) {
                left = middle + 1;
            } else {
                return false;
            }
        }
        return true;
    }
}


```