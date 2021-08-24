# 최솟값 만들기
>https://programmers.co.kr/learn/courses/30/lessons/12941
> 

- 한쪽은 오름차순, 한쪽은 내림차순으로~

```java
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int length = A.length;
        
        int result = 0;
        
        for(int i=0; i<length; i++){
            result += A[i]*B[(length-1)-i];
        }
        
        return result;
    }
}

```