
# 조이스틱

> https://programmers.co.kr/learn/courses/30/lessons/42860

## 참고풀이

가장 어려웠던 부분..
- 좌,우 이동 최소값
- `horizontalMove = Math.min(horizontalMove, index+index+length-nextIndex);`
- 연속된 A를 만난 경우,
1. 현재위치에서 다시 되돌아기 (index+index)
2. length - nextIndex = 문자열 길이 - 연속된 A 문자열 길이 = 남은 길이
3. Math.min(문자열길이, 되돌아가서 구한 길이)
    

```java
public class Solution {
    public int solution(String name) {

        final int length = name.length();
        int verticalMove = 0;

        // 좌,우 이동 기본값 (문자열 길이)
        int horizontalMove = name.length() - 1;

        for (int index = 0; index < length; index++) {
            char cur = name.charAt(index);
            // 상,하 move 중 최소값
            verticalMove += Math.min(cur - 'A', 'Z' - cur + 1);

            int nextIndex = index+1;

            // A가 연속일 경우
            while (nextIndex < length && name.charAt(nextIndex) == 'A'){
                nextIndex++;
            }

            horizontalMove = Math.min(horizontalMove, index+index+length-nextIndex);
        }

        return verticalMove+horizontalMove;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().solution("ABABAAAAAAABA"));
    }
}
```


## 내 풀이 - 실패, 혼돈
- 나는 이걸 직접 다 만들어서 카운트 할 생각 했었는데 미친 생각이었다 ㅋㅋ..

```java
public class Solution {
    public int solution(String name) {
        StringBuilder sb = new StringBuilder();
        char[] nameArray = name.toCharArray();

        for (int i = 0; i < name.length(); i++) {
            sb.append("A");
        }

        String base = sb.toString();

        List<Character> list = new LinkedList<>();

        for (char c : base.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> iterator = list.listIterator();

        int n = next(iterator, nameArray);
        int p = prev(iterator, nameArray);

        return Math.min(n,p)-1;
    }

    private static int next(ListIterator<Character> iterator, char[] nameArray) {
        int count = 0;
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            char cur = iterator.next();

            if (cur == nameArray[index]) {
                continue;
            }
            count++;

            int upCount = up(cur, nameArray[index]);
            int downCount = down(cur, nameArray[index]);
            count += Math.min(upCount, downCount);
        }
        return count;
    }

    private static int prev(ListIterator<Character> iterator, char[] nameArray) {
        int count = 0;
        while (iterator.hasPrevious()) {
            int index = iterator.previousIndex();
            char cur = iterator.previous();

            if (cur == nameArray[index]) {
                continue;
            }
            count++;
            int upCount = up(cur, nameArray[index]);
            int downCount = down(cur, nameArray[index]);
            count += Math.min(upCount, downCount);
        }
        return count;
    }

    private static int down(char cur, char target) {
        int downCount = 0;

        for (int i = 1; i < 27; i++) {
            char temp = ' ';

            if (cur + i > 'Z') {
                temp = ((char) (cur - 25 + i - 1));
            } else {
                temp = ((char) (cur + i));
            }

            if (temp == target) {
                downCount += i;
                break;
            }
        }

        return downCount;
    }

    private static int up(char cur, char target) {
        int upCount = 0;

        for (int i = 1; i < 27; i++) {
            char temp = ' ';

            if (cur - i < 'A') {
                temp = ((char) (cur + 25 - i + 1));
            } else {
                temp = ((char) (cur - i));
            }

            if (temp == target) {
                upCount += i;
                break;
            }
        }

        return upCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("ABABAAAAAAABA"));
    }
}

```