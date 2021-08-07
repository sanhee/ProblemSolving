# 주식가격

- 다른사람풀이는 이중포문을 쓴다거나, 내풀이랑 크게 다를게 없는 것 같아서 스크랩하지는 않았다.

> https://programmers.co.kr/learn/courses/30/lessons/42584?language=java

```java
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Queue<Integer> q = new LinkedList<>();
        int[] answers = new int[prices.length];
        
        for(int p : prices){
            q.add(p);
        }
        
        int index = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=index+1; i< prices.length; i++){
                answers[index]++;  
                
                if(cur > prices[i]){
                    break;
                }   
            }
            index++;
        }
        
        return answers;
    }
    
}
```