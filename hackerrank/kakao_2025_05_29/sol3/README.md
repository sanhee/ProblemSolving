### 3. 조르디와 춘식이의 잃어버린 조직도

조르디와 춘식이는 카카오의 내년도 사업 계획을 성공적으로 완수하기 위해 새로운 조직도를 구상하고 있었습니다.  
기존 팀을 개편하기 위해 새로운 팀을 신설하고, 일부 팀을 폐지하는 작업을 진행했습니다.  
그뿐만 아니라, 조직 개편 도중 특정 팀의 규모를 파악하기 위해 해당 팀과 그 하위 조직의 개수를 **하위 조직 수**로 출력해 달았습니다.

그런데…!

예상치 못한 사고로 인해 최종 조직도와 **하위 조직 수 로그**가 유실되고, 시스템에 남아 있는 것은 **작업 요청 로그**뿐이었습니다.  
조르디와 춘식이는 사라진 조직도를 되살리고자 기존 조직도에 작업 요청 로그를 기반으로 다시 작업을 요청하게 됩니다.  
그 과정에서, 작업 순서에 따라 출력된 **하위 조직 수 로그**를 다시 구해주세요.

---

시스템에는 *n*개의 조직으로 이루어진 **기존 조직도** `existingTeamEdges`와 *q*개의 작업 요청으로 이루어진 **작업 로그** `queries`가 입력됩니다.

작업 요청은 아래 3가지 중 하나입니다.

1. `create_team <team-x> <team-y>` : `<team-y>` 조직의 **하위**에 `<team-x>` 조직을 **신설**
2. `delete_team <team-x>`           : `<team-x>` 조직과 **모든 하위 조직**을 **폐지**
3. `count_teams <team-x>`           : `<team-x>` 조직과 **모든 하위 조직**(자기 자신 포함)의 **개수 출력**

`count_teams <team-x>` 가 호출될 때마다 얻은 값을 **순서대로** 담아 정수형 배열로 반환합니다.

#### 참고
1. `team-1`은 **항상 최상위 조직**이며 `team-1`에 대한 `delete_team` 요청은 발생하지 않습니다.
2. `existingTeamEdges` 안에서 간선들의 **순서는 조직 간 상하관계를 보장하지 않습니다.**

---

#### 예시

```text
existingTeamEdges = [["team-1","a"],
                     ["b","team-1"],
                     ["team-1","c"],
                     ["a","d"],
                     ["a","e"],
                     ["e","f"],
                     ["c","g"]]

queries = ["create_team d h",
           "delete_team e",
           "count_teams a"]
```

아래 트리와 작업 표는 위 예시를 시각화한 것입니다.

```
          team-1
         /  |   \
        a   b    c
      /  \       \
     d    e       g
          |
          f
```

| 요청 순서 | 작업 유형     | 작업 내용                               | 요청 결과 |
|:--------:|:-------------:|----------------------------------------|:---------:|
| 1        | create_team   | `d` 하위에 `h` 팀 신설                | ─ |
| 2        | delete_team   | `e` 및 하위 `f` 조직 폐지             | ─ |
| 3        | count_teams   | `a`를 포함한 하위 조직의 수 계산 & 출력 | **3** |

---

### 함수 설명

`getTeams` 함수는 `count_teams` 호출 결과를 **순서대로** 담은 `int[]`을 반환합니다.

```text
int[] getTeams(
    string existingTeamEdges[n][m],  // 기존 조직 간선 정보
    string queries[q]                // 작업 요청 로그
)
```

#### 반환 값
`int[]` : 각 `count_teams` 요청에 대한 계산 결과

#### 제약 사항
* 1 ≤ *n*, *q* ≤ 10³
* `team-1`은 최상위 조직이며 `team-1`을 삭제하지 않습니다.
* 조직명은 소문자 영문 또는 0-9 숫자로만 구성됩니다.
* 입력값에 **중복 조직명**은 존재하지 않습니다.
* 삭제된 조직은 이후 작업에서 참조되지 않으며 `create_team`의 상위 조직으로도 사용되지 않습니다.
* `existingTeamEdges` 는 항상 트리 구조임을 보장합니다.

---

## Input Format For Custom Testing

1. 첫 번째 줄 : `existingTeamEdges`의 **행 수** *n* 과 **열 수** *m*
2. 다음 *n* 줄 : 각 줄마다 두 개의 문자열 (상위, 하위) — `existingStructureEdges` 와 동일 형식
3. 그다음 줄 : 정수 *q* — `queries` 의 크기
4. 마지막 *q* 줄 : 각 줄마다 하나의 문자열 — `queries[i]`

---

## Sample Case 0

### 입력
```text
3
2
team-1 team-2
team-2 team-3
team-2 team-4
3
create_team team-1 team-5
count_teams team-2
count_teams team-1
```

### 출력
```text
3
5
```

### 설명
```
         team-1
         /    \
      team-2  team-5
     /  |      
team-3 team-4  
```

| 요청 순서 | 작업 유형   | 작업 내용                          | 요청 결과 |
|:--------:|:-----------:|------------------------------------|:---------:|
| 1        | create_team | `team-1` 하위에 `team-5` 신설       | ─ |
| 2        | count_teams | `team-2` 하위 조직의 수 출력        | **3** |
| 3        | count_teams | `team-1` 하위 조직의 수 출력        | **5** |

---

## Sample Case 1

### 입력 (요약)
```text
existingTeamEdges size = 3
team-3 team-4
team-1 team-3
team-3 team-2
queries size = 10
create_team team-1 team-5
count_teams team-3
delete_team team-5
count_teams team-2
delete_team team-4
count_teams team-1
create_team team-1 team-6
```

### 출력
```text
1
3
1
3
1
```

(각 작업에 따른 트리 변화 및 결과 표는 스크린샷 참고)

---

```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'getSubTeams' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts the following parameters:
     *  1. 2D_STRING_ARRAY existingTeamEdges
     *  2. STRING_ARRAY     queries
     */
    public static List<Integer> getSubTeams(
        List<List<String>> existingTeamEdges,
        List<String> queries
    ) {
        // Write your code here
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int existingTeamEdgesRows =
            Integer.parseInt(bufferedReader.readLine().trim());
        int existingTeamEdgesColumns =
            Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> existingTeamEdges = new ArrayList<>();

        IntStream.range(0, existingTeamEdgesRows).forEach(i -> {
            try {
                existingTeamEdges.add(
                    Stream.of(
                        bufferedReader.readLine()
                                      .replaceAll("\s+$", "")
                                      .split(" "))
                          .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        List<Integer> result =
            Result.getSubTeams(existingTeamEdges, queries);

        bufferedWriter.write(
            result.stream()
                  .map(Object::toString)
                  .collect(Collectors.joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
```
