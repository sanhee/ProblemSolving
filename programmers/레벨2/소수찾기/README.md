
# [소수찾기](https://programmers.co.kr/learn/courses/30/lessons/42839)

# 풀이

```java
import java.util.Set;

public class Solution {

    Set<Integer> combSet = new HashSet<>();

    boolean isPrime(int number){
        if(number < 2 ){
            return false;
        }
        for(int i=2; i*i<=number;i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }

    private void recursive(String comb, String others) {
        if(!comb.equals("")){
            combSet.add(Integer.parseInt(comb));
        }

        for(int i=0; i<others.length(); i++){
            recursive(comb+others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        recursive("", numbers);

        Iterator<Integer> iterator = combSet.iterator();

        while (iterator.hasNext()){
            int num = iterator.next();

            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
}

```
