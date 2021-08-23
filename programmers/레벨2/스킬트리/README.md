
# 스킬트리
- 정규표현식을 활용했더니 쉽게 풀렸다.
> https://programmers.co.kr/learn/courses/30/lessons/49993
```java
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        for(String tree : skill_trees){
            tree = tree.replaceAll("[^"+skill+"]","");
            for(int i=0; i<tree.length(); i++){
                if(tree.charAt(i) != skill.charAt(i)){
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }
```