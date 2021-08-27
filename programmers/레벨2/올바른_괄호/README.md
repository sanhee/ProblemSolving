# [올바른 괄호](https://programmers.co.kr/learn/courses/30/lessons/12909)

```java
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for(char c : array ){
           if(stack.isEmpty()){
               stack.push(c);
           }else if(stack.peek() == '(' && c == ')'){
               stack.pop();
           }else{
               stack.push(c);
           }
        }

        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

```


## 다른 사람 풀이
- 스택을 안쓰고 푸는 방법이 신기했다.

```java
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}

```