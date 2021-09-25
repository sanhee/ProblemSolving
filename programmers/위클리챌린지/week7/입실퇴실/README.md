
# [입실 퇴실](https://programmers.co.kr/learn/courses/30/lessons/86048)

## 내 풀이
- K가 저번에 풀이해준 로직을 토대로 작성해보았다.
- 37개의 테스트케이스 중 2개가 런타임 에러가 발생하면서 통과하지 못했다...

```java
public class Solution {
    static int upperPoint = 0;
    static int lowerPoint = 0;

    public int[] solution(int[] enter, int[] leave) {

        final List<Integer> enteredList = new ArrayList<>();

        int[] result = new int[enter.length];

        while (upperPoint < (enter.length) && lowerPoint < (leave.length)) {
            if (enteredList.isEmpty()) {
                upper(enter, enteredList, result);
                lower(leave, enteredList);
            } else {
                lower(leave, enteredList);
                upper(enter, enteredList, result);
            }
        }

        return result;
    }

    private void upper(int[] enter, List<Integer> enteredList, int[] result) {
        if (upperPoint > enter.length - 1) {
            return;
        }

        int current = enter[upperPoint];

        result[current - 1] = enteredList.size();

        if (!enteredList.isEmpty()) {
            for (int entered : enteredList) {
                result[entered - 1]++;
            }
        }

        enteredList.add(current);
        upperPoint++;
    }

    private void lower(int[] leave, List<Integer> enteredList) {
        if (lowerPoint > leave.length - 1) {
            return;
        }

        while (enteredList.contains(leave[lowerPoint])) {
            enteredList.remove((Integer) leave[lowerPoint]);
            lowerPoint++;
        }
    }
}
```