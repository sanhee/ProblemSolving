아래는 요청하신 **문제 정리 → 풀이 전략 → 풀이 코드(Java) → 테스트 케이스** 순서의 마크다운입니다.

---

## 1) 문제 정리

* **함수 정의**
  `f(n)`: 자연수 `n`의 각 자릿수 제곱의 합
  예) `f(19) = 1^2 + 9^2 = 82`

* **목표**
  `n`에 `f`를 반복 적용했을 때

    * **1에 도달**하면 `HAPPY`
    * **1에 도달하지 못하고 값이 반복(사이클)** 되면 `UNHAPPY`

* **입력 형식**
  한 줄에 자연수 `n` (1 ≤ n ≤ 1,000,000,000)

* **출력 형식**
  `HAPPY` 또는 `UNHAPPY`

---

## 2) 풀이 전략

1. **핵심 아이디어**

    * `f(n)`은 결정적 함수이며, 한 번만 적용해도 최댓값이 `9^2 × 10 = 810`이므로
      이후에는 **작은 유한 집합(≤ 810)** 안에서만 값이 변함.
    * 그러므로 반복 적용 시, 언젠가는 **1에 도달**하거나 이미 본 값으로 돌아오는 **사이클**에 빠짐.

2. **구현 선택 (본 풀이)**

    * **방문 집합(Set) 방식의 사이클 탐지**

        * `visited`에 이전 값을 기록.
        * `n == 1`이면 `HAPPY`,
          `n`이 `visited`에 다시 등장하면 `UNHAPPY`.

3. **복잡도**

    * 한 번 `f(n)` 계산: 자릿수 개수 `d = O(log₁₀ n)`
    * 실제 반복 횟수는 매우 작음(첫 스텝 후 ≤ 810로 축소)
    * **시간 복잡도:** `O(t · log n)` (t는 반복 횟수, 상수에 가깝게 작음)
    * **공간 복잡도:** `O(k)` (방문한 값 수, 실제로도 매우 작음)

---

## 3) 풀이 코드 (Java)

```java
package com.example.programmers.line_2025_08_02.sol1;

import java.util.*;

public class Solution {
    // 각 숫자(0~9)의 제곱값 룩업 테이블
    private static final int[] DIGIT_SQUARES = {0,1,4,9,16,25,36,49,64,81};

    // 자릿수 제곱 합 f(n)
    private static int sumOfSquareOfDigits(long x) {
        int sum = 0;
        while (x > 0) {
            sum += DIGIT_SQUARES[(int)(x % 10)];
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        Set<Integer> visited = new HashSet<>();

        // 1에 도달하면 HAPPY, 1에 도달하기 전에 값이 반복되면 UNHAPPY
        while (n != 1 && !visited.contains((int)n)) {
            visited.add((int)n);
            n = sumOfSquareOfDigits(n);
        }

        System.out.println(n == 1 ? "HAPPY" : "UNHAPPY");
    }
}
```

> 참고: 과정(예: `19 -> 82 -> 68 -> 100 -> 1`)을 **출력하고 싶으시면** 요청해 주세요. 위 코드 기반으로 `verbose` 옵션을 추가해 간단히 확장해 드릴 수 있습니다.

---

## 4) 테스트 케이스

|  # | 입력 n       | 기대 출력   |
| -: | ---------- | ------- |
|  1 | 1          | HAPPY   |
|  2 | 2          | UNHAPPY |
|  3 | 4          | UNHAPPY |
|  4 | 7          | HAPPY   |
|  5 | 10         | HAPPY   |
|  6 | 19         | HAPPY   |
|  7 | 68         | HAPPY   |
|  8 | 82         | HAPPY   |
|  9 | 999999999  | UNHAPPY |
| 10 | 1000000000 | HAPPY   |

원하시면 위 10개 중 몇 개를 골라 **단계별 변환 과정**(분해식 포함)도 같이 출력하는 버전을 바로 제공해 드리겠습니다. 어떤 형식을 선호하시나요? (한 줄 체인 / 단계별 분해식)
