
> https://programmers.co.kr/learn/courses/30/lessons/12939

```java
import java.util.*;

class Solution {
    public String solution(String s) {
        String[] splited = s.split(" ");
        int[] n = new int[splited.length];
        
        int i = 0;
        for(String str : splited){
            n[i] = Integer.parseInt(str);
            i++;
        }
        
        Arrays.sort(n);
        System.out.println(Arrays.toString(n));
        
        return n[0]+" "+n[n.length-1];
    }
}

```