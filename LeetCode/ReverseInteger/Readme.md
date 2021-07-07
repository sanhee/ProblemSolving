## 문제링크

- [Reverse Integer - LeetCode](https://leetcode.com/problems/reverse-integer/)

> Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-231, 231 - 1]`, then return `0`.
**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

**Example 1:**

```
Input: x = 123
Output: 321
```

**Example 2:**

```
Input: x = -123
Output: -321
```

## 참고자료

### Integer 최대, 최소값 범위

- [[문돌이의IT] 자바(Java) 변수 타입 별 최대, 최소값 확인하기](https://improver.tistory.com/90)

# 접근 과정

입력 정수를

## 작성한 코드

- 의식의 흐름대로 작성했더니 지저분하다..다른사람 코드를 한번 봐야겠다.

```java
class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(""+x);
        int answer = 0;
        boolean negative = false;
        
        if (sb.charAt(sb.length()-1) == '-'){  //m -8463847412- 예외처리를 위해
            sb.deleteCharAt(sb.length()-1);
        }

        if(sb.charAt(0) == '-'){
            negative = true;
            sb.deleteCharAt(0);
        }
        sb.reverse();

        if(negative){
            if (sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
            sb.insert(0,"-");
        }
        if (sb.length()>1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        double temp = Double.parseDouble(sb.toString()); 

        if ( temp>Integer.MAX_VALUE || temp<Integer.MIN_VALUE) { // 정수범위 체크
            answer = 0; // 정수 범위를 벗어날 경우
        }
        else {
            answer = Integer.parseInt(sb.toString());
        }
        return answer;
        
    }
}
```

```java
*Success

Runtime: 10 ms, faster than 8.37% of Java online submissions for Reverse Integer.
Memory Usage: 37.7 MB, less than 13.07% of Java online submissions for Reverse Integer.
```
