
# [국영수](https://www.acmicpc.net/problem/10825)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final FastReader scan = new FastReader();
    static Student[] students;
    static int N;

    static class Student {

        int koreanScore;
        int englishScore;
        int mathScore;
        String name;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
            this.name = name;
        }

    }

    private static void input() {
        N = scan.nextInt();
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            students[i] = new Student(
                    scan.next(),
                    scan.nextInt(),
                    scan.nextInt(),
                    scan.nextInt()
            );
        }
    }

    private static void scoreSort() {
        Arrays.sort(students, (Student s1, Student s2) -> {
            if (s1.koreanScore != s2.koreanScore) {
                return s2.koreanScore - s1.koreanScore;
            } else if (s1.englishScore != s2.englishScore) {
                return s1.englishScore - s2.englishScore;
            } else if (s1.mathScore != s2.mathScore) {
                return s2.mathScore - s1.mathScore;
            }
            return s1.name.compareTo(s2.name);
        });
    }

    public static void main(String[] args) {

        input();
        scoreSort();

        Arrays.stream(students).forEach(student -> System.out.println(student.name));
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