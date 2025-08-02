아래는 **문제 정리 → 풀이 아이디어 → 검증 예시 → Java 구현**까지 한 번에 볼 수 있게 정리한 문서입니다.
(이미지 기반 원문을 토대로 재정리했으며, 예시 결과와 동일하게 동작합니다.)

---

## 문제 요약

* 코인 종류가 `m`개 있고, 각 코인 `t(1..m)`의 **단가**가 주어진다.
* 작업이 `n`개 주어지며, 각 작업은

    * 시작일 `s`, 종료일 `e`, 코인종류 `t` 를 가진다.
    * 작업 기간은 **반열린 구간 `[s, e)`** 로 해석한다 → **기간 = `e - s` 일**
      (예: `2 5`면 3일. 예시 출력과 일치)
    * 해당 작업의 **수익 = (e - s) × price\[t]**.
* **동시에 하나의 작업만 수행 가능**하며, **겹치는 작업은 함께 선택할 수 없다.**
  단, 어떤 작업이 `e`에 끝나고 다른 작업이 `e`에 시작하는 것은 **가능**하다(겹치지 않음).
* 목표: 겹치지 않게 작업을 골라 **총 수익의 최댓값**을 구하라.

---

## 입력 형식

1. 첫 줄: `m n`
2. 다음 `m`줄: `price[1], price[2], …, price[m]`
3. 다음 `n`줄: 각 작업 `s e t` (시작일, 종료일, 코인종류)

## 출력 형식

* 가능한 **최대 총 수익**(정수)

---

## 예시

### 예제 1

```
입력
2 5
2
3
2 5 1
4 5 2
4 6 1
7 11 2
6 10 1

출력
18
```

### 예제 2

```
입력
3 5
2
3
1
1 4 1
3 6 3 
5 8 2
7 10 1
9 12 2

출력
24
```

### 예제 3

```
입력
5 7
1
2
3
4
5
1 5 2
3 8 1
2 4 3
3 9 2
4 10 5
7 11 4
5 7 3

출력
36
```

---

## 풀이 아이디어

이 문제는 전형적인 **가중 구간 선택(Weighted Interval Scheduling)** 문제다.

### 해법 A: 정렬 + 이진탐색 DP (O(n log n))

1. 작업을 `end(=e)` 기준 오름차순 정렬
2. 각 작업 `i`에 대해, `end ≤ start[i]` 를 만족하는 마지막 작업 `p(i)`를 **이진탐색**으로 찾음
3. 점화식: `dp[i] = max(dp[i-1], dp[p(i)] + profit[i])`

> 입력이 매우 클 때 범용적으로 좋은 방법.

### 해법 B: **날짜 축 DP** (O(maxDay + n)) — 본 풀이

* 날짜의 최댓값 `maxDay`가 과도하게 크지 않다면 더 단순하고 빠르다.
* `dp[d] = d일까지 얻을 수 있는 최대 수익`으로 두고 날짜를 0부터 순회:

    * 전이 1: `dp[d] = max(dp[d], dp[d-1])` (아무 작업도 안 하고 하루 진행)
    * 전이 2: `d`에 시작하는 모든 작업 `(s=d, e, t)`에 대해
      `dp[e] = max(dp[e], dp[d] + (e - d) * price[t])`
* 마지막에 `dp[maxDay]`가 정답.

**정당성**

* `[s,e)` 정의이므로, `end == 다음 작업의 start`인 경우 겹치지 않음 → `dp[e]`로의 전이가 정확하다.
* 날짜가 증가할수록 `dp`는 비감소하며, 시작일별로만 전이를 추가하므로 모든 합법적 선택이 고려된다.

---

## 복잡도

* 날짜 축 DP: `O(maxDay + n)` 시간, `O(maxDay)` 공간
* (입력 조건상 `maxDay`가 크지 않은 것으로 해석되어 채택)

---

## 구현 (기존 템플릿 유지)

> **주의**: 입력이 아주 크면 `Scanner` 대신 `FastReader`를 쓰는 것이 안전합니다.
> 아래 코드는 질문에서 사용하신 템플릿(Scanner, `RawCoin` 등)을 **그대로 살려** 핵심만 채운 버전입니다.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class RawCoin {
        int startDay, endDay, type;
        RawCoin(int startDay, int endDay, int type) {
            this.startDay = startDay;
            this.endDay   = endDay;
            this.type     = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] coinPrice = new int[m];          // 0-indexed
        for (int i = 0; i < m; i++) coinPrice[i] = sc.nextInt();

        List<RawCoin> raw = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt() - 1;          // 입력 1..m → 내부 0..m-1
            raw.add(new RawCoin(s, e, t));
        }
        sc.close();

        // 최대 날짜
        int maxDay = 0;
        for (RawCoin r : raw) if (r.endDay > maxDay) maxDay = r.endDay;

        // 시작일별 작업 리스트
        @SuppressWarnings("unchecked")
        List<RawCoin>[] jobsByDay = new ArrayList[maxDay + 1];
        for (int d = 0; d <= maxDay; d++) jobsByDay[d] = new ArrayList<>();
        for (RawCoin r : raw) jobsByDay[r.startDay].add(r);

        // dp[d] = d일까지의 최대 수익
        long[] dp = new long[maxDay + 1];  // 기본 0으로 초기화

        for (int day = 0; day <= maxDay; day++) {
            // 하루 진행(아무 작업도 안 함)
            if (day > 0) dp[day] = Math.max(dp[day], dp[day - 1]);

            // 오늘 시작하는 모든 작업 처리
            for (RawCoin job : jobsByDay[day]) {
                int end = job.endDay;
                long profit = (long) (job.endDay - job.startDay) * coinPrice[job.type]; // [s,e)
                if (end <= maxDay) {
                    dp[end] = Math.max(dp[end], dp[day] + profit);
                }
            }
        }

        System.out.println(dp[maxDay]);
    }
}
```

---

## 코너 케이스 체크리스트

* `e == s` 인 작업(기간 0) → 수익 0, 선택해도 영향 없음.
* `end == next.start` → 겹치지 않으므로 함께 선택 가능.
* 동일한 `[s,e,t]` 작업이 여러 번 나와도 각 작업은 독립적으로 선택 대상.
* 오버플로 방지 → 수익 계산은 `long` 사용.

---

필요하시면 **정렬+이진탐색 DP(O(n log n)) 코드**나, **선택된 작업 목록 복원** 로직도 바로 추가하겠습니다.
마지막으로 확인: 구간 정의가 **\[s, e)**(반열린)으로 확정이면 위 코드가 정답입니다. 혹시 **\[s, e]**(닫힌)이어야 한다면 `profit = (e - s + 1) * price[t]` 로만 바꾸면 됩니다. 그렇게 바꿔 드릴까요?
