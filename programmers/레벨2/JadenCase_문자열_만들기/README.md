
# JadenCase 문자열 만들기
- https://programmers.co.kr/learn/courses/30/lessons/12951

# 참고 풀이
```java
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char firstWord = s.charAt(0);
        answer.append(Character.toUpperCase(firstWord));

        // 이전 인덱스를 통해 공백을 봐야하기 때문에 1부터 시작함.
        for(int i=1; i<s.length(); i++){
            char cursor = s.charAt(i);

            // 이전 인덱스에 해당하는 글자가 공백이라면
            if(s.charAt(i-1) == ' '){
                answer.append(Character.toUpperCase(cursor));
            }else{
                answer.append(Character.toLowerCase(cursor));
            }
        }
        return answer.toString();
    }
}
```

# 내 풀이 
- 테스트케이스 1개 통과 못함...
- 공백기준으로 잘라서, 공백 문자열일 경우에 대한 예외처리를 못한 게 문제인듯..

```java
class Solution {
     public String solution(String s) {
        String[] split = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String str : split) {
            if (str.length() == 0) {
                sb.append(str).append(" ");
                continue;
            }
            
            str = str.toLowerCase();
            char firstWord = str.charAt(0);

            if (Character.isAlphabetic(firstWord)) {
                sb.append(Character.toUpperCase(firstWord)).append(str.substring(1)).append(" ");
            }else {
                sb.append(str).append(" ");
            }
        }
        return sb.toString().trim();
    }
}

```