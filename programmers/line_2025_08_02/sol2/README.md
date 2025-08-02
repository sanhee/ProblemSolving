아래는 **문제 정리 → 풀이 전략 → 풀이 코드(Java) → 테스트 케이스** 순서의 마크다운입니다.

---

## 1) 문제 정리

### 목표

영어 소문자 문자열 `w`를 **최소한의 삭제**로 회문으로 만들 때,

* 필요한 최소 삭제 횟수가 `0, 1, 2, 3`이면 그 값을 출력
* **4글자 이상** 삭제가 필요하면 `-1`을 출력

### 입력

* 한 줄: 문자열 `w` (`5 ≤ |w| ≤ 100000`, 영어 소문자)

### 출력

* 정수 하나: `0`, `1`, `2`, `3` 중 최소값 또는 `-1`

### 판정 규칙(타입 의미)

* **0**: 이미 회문 (삭제 0회)
* **1**: 문자 1개 삭제로 회문 가능
* **2**: 문자 2개 삭제로 회문 가능
* **3**: 문자 3개 삭제로 회문 가능
* **-1**: 3회 이내로는 불가능(4회 이상 필요)

제한: 시간 10초 / 메모리 2GB

---

## 2) 풀이 전략

### 아이디어

* 양끝 포인터 `left`, `right`를 두고 비교(투 포인터).
* 문자가 같으면 내부로 이동.
* 다르면 “**왼쪽 삭제**” 또는 “**오른쪽 삭제**” 두 가지로 **분기**.
* 허용 삭제 횟수 `k`를 0→1→2→3 순서로 검사하여, **처음 성공하는 k가 정답**.
* `k ≤ 3`이라 분기 수가 최대 `2^3 = 8`로 작아 **DFS 재귀**가 간단하고 안전.

### 올바름 스케치

* 각 `k`에 대해 가능한 좌/우 삭제 선택을 모두 탐색 → `k`회 이내의 모든 경우 포함.
* `k`를 증가시키며 탐색 → **최소 삭제 횟수** 보장.

### 복잡도

* 각 경로는 포인터를 한 번씩만 전진 → **O(n)**
* 분기 최대 `2^k (k≤3)` → 상수 배수
* **시간:** `O(2^k · n)` = 사실상 **O(n)**
* **공간:** 재귀 깊이 `O(k)` = **O(1)**

---

## 3) 풀이 (Java)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine().trim();

        char[] s = w.toCharArray();
        for (int k = 0; k <= 3; k++) {
            if (canWithinK(s, k)) {
                System.out.println(k);
                return;
            }
        }
        System.out.println(-1); // 3회 이내로 불가능
    }

    // s를 k회 이하 삭제로 회문 만들 수 있으면 true
    private static boolean canWithinK(char[] s, int k) {
        return dfs(s, 0, s.length - 1, k);
    }

    /**
     * dfs(left, right, remain):
     *  s[left..right]를 remain회 이하 삭제로 회문 가능하면 true
     */
    private static boolean dfs(char[] s, int left, int right, int remain) {
        // 일치 구간은 한 번에 스킵
        while (left < right && s[left] == s[right]) {
            left++;
            right--;
        }

        if (left >= right) return true;  // 이미 회문
        if (remain == 0) return false;   // 더 삭제 불가

        // 불일치 지점: 왼쪽 삭제 or 오른쪽 삭제로 분기
        return dfs(s, left + 1, right, remain - 1)
            || dfs(s, left, right - 1, remain - 1);
    }
}
```

---

## 4) 테스트 케이스

| #  | 입력 `w`                                   | 기대 출력 | 설명                         |
| -- | ---------------------------------------- | ----: | -------------------------- |
| 1  | `abccba`                                 |     0 | 이미 회문                      |
| 2  | `abca`                                   |     1 | `c` 삭제 → `aba`             |
| 3  | `raceacar`                               |     1 | 가운데 `a` 하나 삭제 → `racecar`  |
| 4  | `abccbaxy`                               |     2 | 끝의 `x`,`y` 제거 → `abccba`   |
| 5  | `abccbaxyz`                              |     3 | `x`,`y`,`z` 제거 → `abccba`  |
| 6  | `abcdefg`                                |    -1 | LPS≈1 → 최소 6회 필요(3회 이내 불가) |
| 7  | `aaaaa`                                  |     0 | 동일 문자 반복은 회문               |
| 8  | `abcxba`                                 |     1 | `x` 삭제 → `abcba`           |
| 9  | `abxyc yxba` (공백 없이 `abxycyxba`)         |     2 | `y`,`c` 중 2개 제거로 회문 가능     |
| 10 | (매우 큼) `a`×50000 + `b` + `a`×49999 + `c` |     1 | 마지막 `c`만 제거하면 회문 (성능 확인용)  |

> 참고: 입력 조건상 빈 문자열은 주어지지 않습니다. 만약 방어적으로 처리한다면 빈 문자열을 **회문(0)** 으로 간주할 수 있습니다.

---

## 5) 추가 일반화/확장 포인트

* **가변 K**: 정책이 바뀔 수 있으니 `minDeletionUpToK(w, K)`로 일반화 가능. (K가 커지면 분기가 폭증 → DP(LPS 기반) 고려)
* **비재귀형**: 재귀가 싫다면 스택/큐로 동일 로직 구현 가능(상태: `(l, r, used)`).
* **입력 방어**: `null/공백` 처리(문제 제약 밖이지만 실무 방어 코드로 유용).

---

필요하시면 위 코드에 **간단 테스트 러너**(예: `#TEST` 입력 시 내장 케이스 실행)도 붙여드릴게요. 어떤 형태로 돌려보고 싶으세요? 제가 맞춰서 제공하겠습니다.
