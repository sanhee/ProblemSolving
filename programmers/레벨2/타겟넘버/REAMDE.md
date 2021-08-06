
# 타겟 넘버(BFS/DFS)
- 감이 오지 않아서, 풀이를 참고해서 풀었다.근데 아래 있던 예제가 블로그에서는 bfs라고 소개됐는데, 재귀가 있어서 나는 dfs라고 생각했다. 자세한건 나중에 찾아봐야지.. 
  - https://velog.io/@jaesika/프로그래머스-DFS-타겟넘버

> https://programmers.co.kr/learn/courses/30/lessons/43165
```java

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, numbers[0], target, 1) + dfs(numbers, -numbers[0], target, 1); 
    }
    
    public static int dfs(int[] numbers, int sum, int target, int index){
        if(index == numbers.length){
            if(target == sum){
                return 1;
            }else{
                return 0;
            }
        }
        int result = 0;
        
        result += dfs(numbers, sum+numbers[i], target, index+1);
        result += dfs(numbers, sum-numbers[i], target, index+1);
        
        result result;
    }
    
}

```