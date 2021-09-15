

# [카드](https://www.acmicpc.net/problem/11652)

# 내 풀이
- 해쉬맵 

```java
public class Main {

    public static void main(String[] args) {

        FastReader scan = new FastReader();
        int N = scan.nextInt();

        Map<BigInteger, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            BigInteger cardNumber = scan.nextBigInt();
            int cardCount = map.getOrDefault(cardNumber, 0) + 1;

            map.put(cardNumber, cardCount);
        }

        List<Map.Entry<BigInteger, Integer>> entryList = new LinkedList<>(map.entrySet());

        // Object sort == tim sort -> stable 하므로,
        // 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println(entryList.get(0).getKey());
    }

    static class FastReader {

        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        BigInteger nextBigInt() {
            return new BigInteger(next());
        }
    }
}

```


# 다른 풀이

- sort와 카운트로 해결

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader scan = new FastReader();
        int N = scan.nextInt();
        long[] cards = new long[N];

        for(int i=0; i<N; i++){
            cards[i] = scan.nextLong();
        }

        Arrays.sort(cards);

        int currentCount = 1;
        int modeCount = 1;
        long mode = cards[0];

        for(int i=1; i<N; i++){

            if(cards[i] == cards[i-1]){
                currentCount++;
            }else{
                currentCount = 1;
            }

            if(modeCount < currentCount){
                modeCount = currentCount;
                mode = cards[i];
            }

        }

        System.out.println(mode);

    }

    static class FastReader {

        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}


```