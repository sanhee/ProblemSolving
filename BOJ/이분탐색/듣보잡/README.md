

# [듣보잡](https://www.acmicpc.net/problem/1764)


# 첫 번째 시도(시간초과)

```java

public class Main {

    static FastReader scan = new FastReader();
    static int N; // 듣도 못한 사람 수
    static int M; // 보도 못한 사람 수
    static String[] name; // 듣도 못한 사람
    static String[] name2; // 보도 못한 사람

    public static void process() {

        List<String> list = Arrays.asList(name);
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (String n : name2) {
            if (list.contains(n)) {
                count++;
                sb.append(n).append("\n");
            }
        }

        System.out.println(count);
        System.out.println(sb);

    }

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        name = new String[N];
        name2 = new String[M];

        for (int i = 0; i < N; i++) {
            name[i] = scan.nextLine();
        }

        for (int i = 0; i < M; i++) {
            name2[i] = scan.nextLine();
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}

```



# 해답 본 뒤 풀이
 - 실수한 부분
   1. 이분 탐색에서 right를 구할 때 `배열의 길이-1`을 해줘야 하는데 까먹고 못해서, 찾느라 오래걸림
   2. 결과에서 오름차순 하는부분을 까먹고 안했음. 문제를 잘 읽어야 할 듯.
 

```java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static FastReader scan = new FastReader();
    static int N; // 듣도 보도 못한 사람의 수
    static String[] UNKNOWN_LIST;

    static void input() {
        N = scan.nextInt();
        UNKNOWN_LIST = new String[N];

        for (int i = 0; i < N; i++) {
            UNKNOWN_LIST[i] = scan.nextLine();
        }
    }

    static void process(){

        // 이분 탐색을 위한 오름차순 정렬
        Arrays.sort(UNKNOWN_LIST);

        int count = 0; // 두 배열에서 동일한 명단을 찾을 경우 COUNT++
        List<String> answer = new ArrayList<>();

        int M = scan.nextInt(); // 듣도 보도 못한 명단의 수

        for(int i=0; i<M; i++){
            String person = scan.nextLine();

            if(isExist(person)){
                count++;
                answer.add(person);
            }
        }

        System.out.println(count);
        System.out.println(answer.stream()
                                 .sorted(Comparator.naturalOrder())
                                 .map(String::valueOf)
                                 .collect(Collectors.joining("\n")));
    }

    // binary search
    private static boolean isExist(String person) {

        int left = 0;
        int right = UNKNOWN_LIST.length-1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if(UNKNOWN_LIST[middle].equals(person)){
                return true;
            }

            if(UNKNOWN_LIST[middle].compareTo(person) < 0){
                left = middle+1;
            }else{
                right = middle-1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        input();
        process();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}



```
