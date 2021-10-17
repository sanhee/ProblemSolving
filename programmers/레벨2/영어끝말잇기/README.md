
# [영어 끝말잇기](https://programmers.co.kr/learn/courses/30/lessons/12981)

- 런타임 에러가 있었는데, 처음부터 끝말잇기 규칙에 맞지않은 단어가 오는 경우 map에 해당하는 카운트가 없어서 일반적인 get을 하면 문제가 나는거였음
- 인덱스 벗어났다고 알려줬으면 좀 더 쉽게 찾았을 텐데,,(처음부터 꼼꼼하게 설계하자 ㅎㅎ)

```java
public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        // ID, COUNT
        Map<Integer, Integer> userPlayCount = new HashMap<>();

        List<String> history = new LinkedList<>();

        int index = 1;
        for (String word : words) {
            if( word.length() > 1 && lastAndFirstCheck(word,history) && !history.contains(word)){
                history.add(word);

                int key = index % n;
                if (key == 0) {
                    userPlayCount.put(n, userPlayCount.getOrDefault(n, 0)+1);
                }else{
                    userPlayCount.put(key, userPlayCount.getOrDefault(key, 0)+1);
                }
                index++;
            }else{
                int key = index % n;
                if (key == 0) {
                    answer[0] = n;
                    //answer[1] = userPlayCount.get(n)+1;
                    answer[1] = userPlayCount.getOrDefault(n, 0)+1;
                }else{
                    answer[0] = key;
                    //answer[1] = userPlayCount.get(key)+1;
                    answer[1] = userPlayCount.getOrDefault(key, 0)+1;
                }
                break;
            }
        }
        return answer;
    }

    private boolean lastAndFirstCheck(String word, List<String> history) {
        if(!history.isEmpty()) {
            String lastHistoryWord = history.get(history.size() - 1);
            return word.charAt(0) == lastHistoryWord.charAt(lastHistoryWord.length() - 1);
        }
        return true;
    }
}
```