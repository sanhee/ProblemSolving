
# [사토르 마방진](https://www.acmicpc.net/problem/20112)

## 내 풀이
- for문 행진 

```java
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int maxCount = sc.nextInt();
        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < maxCount; i++) {
            List<Character> tempList = new ArrayList<>();
            for (char c : sc.next().toCharArray()) {
                tempList.add(c);
            }
            list.add(tempList);
        }

        Set<String> answer = new HashSet<>();
        for (List<Character> line : list) {
            StringBuilder sb = new StringBuilder();
            for (Character c : line) {
                sb.append(c);
            }
            answer.add(sb.toString());
        }

        for (int col = 0; col < maxCount; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < maxCount; row++) {
                sb.append(list.get(row).get(col));
            }
            answer.add(sb.toString());
        }

        if (answer.size() == maxCount) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}

```

## 다른사람 코드
- 그냥 라인 그래도 배열로 받고 charAt이용해서 row, col탐색하는게 인상깊음

```java
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] set = new String[N];

        for (int i = 0; i < N; i++) {
            set[i] = br.readLine();
        }

        String answer = "YES";

        for (int i = 0; i < N; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < N; j++) {
                sb.append(set[j].charAt(i));
            }

            if (!set[i].equals(sb.toString())) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}
```
