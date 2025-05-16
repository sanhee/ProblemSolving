## 문제 요약
- 길이 N인 정수 배열 A, B가 주어진다. (2 ≤ N ≤ 100,000, 원소 값 범위 ±10^9)
- “공정 인덱스” K(1 ≤ K ≤ N–1)란, 다음 네 부분합이 모두 같은 경우를 말한다.
    1. A[0..K–1]의 합
    2. A[K..N–1]의 합
    3. B[0..K–1]의 합
    4. B[K..N–1]의 합
- 가능한 모든 K의 개수를 반환하는 문제

## 핵심 아이디어
1. **전체 합 계산**
    - `totalA = Σ A[i]`, `totalB = Σ B[i]`
2. **불가능한 경우 빠르게 걸러내기**
    - `totalA != totalB`  → A와 B 합이 다르면 네 부분합을 같게 만들 수 없음
    - `totalA`가 홀수 → A 전체를 반으로 나누어 같은 부분합을 만들 수 없음 (B도 동일)
3. **누적 합 순회**
    - `half = totalA / 2`
    - `leftA`, `leftB`를 0으로 초기화하고, k=1…N-1 순회하며
        - `leftA += A[k-1]`, `leftB += B[k-1]`
        - 만약 `leftA == half && leftB == half` 이면 공정 인덱스 개수 증가
4. **왜 1부터 N-1인가?**
    - K=0 또는 K=N은 한쪽이 빈 배열이 되어 문제 조건에 맞지 않음

## 시간·공간 복잡도
| 구분           | 복잡도    | 근거                                                         |
| -------------- | --------- | ------------------------------------------------------------ |
| **시간**       | O(N)      | 전체 합 계산 O(N) + 부분합 순회 O(N)                         |
| **공간**       | O(1)      | 입력 외 고정 개수의 변수만 사용                               |

```java
// 요약된 주요 로직
long totalA = ..., totalB = ...;        // 전체 합 계산
if (totalA != totalB || totalA % 2 != 0) return 0;
long half = totalA / 2;
long leftA = 0, leftB = 0;
int fairCount = 0;
for (int k = 1; k < N; k++) {
    leftA += A[k-1];
    leftB += B[k-1];
    if (leftA == half && leftB == half) fairCount++;
}
return fairCount;
