# 위장
> https://programmers.co.kr/learn/courses/30/lessons/42578


# 참고한 다른사람 풀이
- 문제 핵심은 key당 몇개의 요소를 가지고 있는지를 파악하고, 그때의 경우의 수 곱의 법칙을 활용할 수 있는지였다..
  - 배워놓고 써먹질 못하는 거 보면 헛배운듯
- 옷을 안입을 경우를 고려해야 한다.

```java
public class Solution {
    public int solution(String[][] clothes) {

        // 경우의 수  위해 1로 초기화
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        // map에 각 key 마다 요소의 개수를 카운트하는 로직
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 경우의 수, 곱의 법칙
        // iterator.next() + 1 인 이유는 옷을 안입을 경우도 고려
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            answer *= iterator.next() + 1;
        }

        // 하루에 최소 한 개의 의상 입는다는 조건을 지키기 위해 -1 -> 완전히 다 벗을 수는 없음
        return answer - 1;
    }
}
```


# 시도했지만 포기한 풀이
- key당 문자열 그대로 받아서 작성한 창피한 코드
- dfs를 통해 조합 하려했지만, map이라서 index 제어를 하지 못해서 막힘..ㅋㅋㅋ

```java
public class Solution {

    public List<String> elements;
    public List<String> results;

    public int solution(String[][] clothes) {
        final int KEY = 1;
        final int VALUE = 0;

        int answer = clothes.length; // 경우의 수중 배열의 길이만큼은 확정임.

        Map<String, List<String>> map = new LinkedHashMap<>();

        // 해쉬맵에 멀티밸류 넣는 로직
        for (String[] clothe : clothes) {
            if (!map.containsKey(clothe[KEY])) {
                map.put(clothe[KEY], new ArrayList<>(Collections.singletonList(clothe[0])));
            } else {
                List<String> values = map.get(clothe[KEY]);
                values.add(clothe[VALUE]);

                map.put(clothe[KEY], values);
            }
        }

        elements = new ArrayList<>();
        results = new ArrayList<>();

        for (String key : map.keySet()) {
            List<String> values = map.get(key);
            for (String value : values) {
                dfs(key, value, map);
            }
        }

        return answer + results.size();
    }

    private int dfs(String key, String value, Map<String, List<String>> map) {
        int count = 0;


        return count;
    }


    public static void main(String[] args) {
        String[][] clothes = new String[][]{
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        new Solution().solution(clothes);
    }
}
```