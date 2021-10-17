

# [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587#)
- 한 3개월전에 풀었을 때, 문제 이해를 제대로 못하고 잘못된 테스트케이스를 넣어놨는데 너무 오래전이라 커스텀 케이스가 있는줄 몰랐다..
- 처음 풀떄 어려웠던 점
  - 딱 한번만 순회해서 검사하면 되는줄 알았다.
    - 자기보다 큰게 있는지 검사하는 로직을 전체 순회하면서 딱 한번 검사하고, 최댓값이 나오면 바로 프린트를 출력하면 된다고 생각함
    - 반례
        - A,B,C,D,E - 1,2,8,3,4 일 경우
        - B,C,D,E,A -> C,D,E,A,B 에서 끝난 채로 출력하는 게 아니었음
        - C출력 ->  D,E,A,B -> E,A,B,D -> E출력 -> A,B,D -> B,D,A -> D,A,B -> D출력 ..


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