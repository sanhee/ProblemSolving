
# 카펫
> https://programmers.co.kr/learn/courses/30/lessons/42842

# 접근방법

1. 갈색 펫이 테두리가 될 수 있는 노란색 카펫의 [가로, 세로] 길이를 탐색
   - `갈색 카펫 넓이` = `((노란색 카펫 가로 길이 + 2) * 2) + ((노란색 카펫 세로 길이) * 2)`
   - ![img_1.png](img_1.png)
    
  - 위 공식으로 구하면, 노란색 넓이의 조합은 [6x4], [4x6]와 같이 두 가지의 쌍으로 나올 수 있음.
    - `<문제조건> 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.`에 따라 가로길이의 가중치를 높이고, 모듈라 연산으로 노란색 넓이에 해당하는 길이를 구하면 됨.
2. `전체 카펫의 가로 x 세로 길이` = `(갈색 카펫 가로 + 2)  x (갈색 카펫 세로 +2) `


# 2차 시도 (성공)
- double을 사용하지 않고, 모듈라 검증이 된 것만 길이을 구함

```java
public class Solution {
    public int[] solution(int brown, int yellow) {
        int row;
        int coloumn;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                row = yellow / i;
                coloumn = i;

                if (checkAreaOfBrown(brown, row, coloumn)) {
                    return new int[]{row + 2, coloumn + 2};
                }
            }
        }
        return null;
    }

    public boolean checkAreaOfBrown(int brown, int rowOfYellow, int coloumnOfYellow) {
        int area = ((rowOfYellow + 2) * 2) + ((coloumnOfYellow) * 2);
        return brown == area;
    }
}
```

# 다른사람 풀이

- 충격 그자체다..

```java
class Solution {
    public int[] solution(int brown, int yellow) {
       int y = 3;
        int sumXY = (brown + 4) / 2;

        while ((sumXY - y) * y != brown + yellow) {
            y++;
        }

        return new int[]{sumXY - y, y};
    }
}

```


# 첫 시도 (실패) 

- 모듈라 검증을 해주지 않음에도, 소수점 관리를 안하고 있다보니 올바른 가로, 세로 길이가 구해지지 않았던 게 실패 원인이었다. 
- ex) 1/2,  1/3 .. 등 소수점이 나올 경우 고려를 해야함
- 각 필드의 자료형을 `double`로 선언해주면 문제 해결 할 수 있음.

```java
class Solution {
    public int[] solution(int brown, int yellow) {
        int row = yellow;
        int coloumn = 1;
 
        for(int i=2; i<yellow/2; i++){
            if(checkAreaOfBrown(brown, row, coloumn)){
                return new int[]{row+2, coloumn+2};
            }
            row = yellow/i;
            coloumn = i;
        }

        return new int[]{row+2, coloumn+2};
    }

    public boolean checkAreaOfBrown(int brown, int rowOfYellow, int coloumnOfYellow){
        int area = ((rowOfYellow+2)*2) + ((coloumnOfYellow)*2);
        return brown == area;
    }
}

```

![img.png](img.png)
