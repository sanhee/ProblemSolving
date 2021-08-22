# 순위검색

>  https://programmers.co.kr/learn/courses/30/lessons/72412

## 풀이 강의 참고
- https://www.youtube.com/watch?v=eBQtFteduyw

![img_1.png](img_1.png)

- 효율성을 위해, 모든 쿼리 조합에 대한 테이블을 만든다.
-  전체 조합 개수 : 4x3x3x3 = 108
-  인덱스 구하기: (언어 인덱스 x 3 x 3 x 3) + ( 직군 인덱스 x 3x 3 ) + ( 경력 인덱스 x 3)  + 소울 푸드 인덱스

- 생성된 테이블에 유저 점수 삽입 `16번` 진행
  - `-`일 때 고려해서 경우의 수가 2개 됨.
    - 2 x 2 x 2 x 2 = 2^ 4 = 16 
    - 언어 경우의 수 x 직군 경우의 수 x ....
  - 모든 경우의 수에 대해서 점수를 중복으로 삽입
     - 이렇게 해둠으로써 어떤 쿼리가 들어오더라도, 이 인덱스로 찾아가면 하나의 리스트에 대해서만 바이너리 서치 할 수 있음.
    
## 내 풀이(실패)
- equals 도입
- 테스트케이스 통과, 효율성 실패

```java
class Solution {
    public int[] solution(String[] info, String[] query) {

        int infoLength = info.length;
        UserScore[] userScores = new UserScore[infoLength];

        for (int i = 0; i < infoLength; i++) {
            String[] dataArray = info[i].split(" ");
            userScores[i] = new UserScore(dataArray[0], dataArray[1], dataArray[2], dataArray[3], Integer.parseInt(dataArray[4]));
        }

        int queryLength = query.length;
        UserScore[] queryObject = new UserScore[queryLength];
        int[] result = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {
            String[] splitQuery = query[i].split(" and ");
            String[] split = splitQuery[3].split(" "); // 소울푸드, 점수

            if (splitQuery[0].equals("-") && splitQuery[1].equals("-") && splitQuery[2].equals("-") && split[1].equals("-")) {
                result[i] += infoLength;
                continue;
            }

            queryObject[i] = new UserScore(splitQuery[0], splitQuery[1], splitQuery[2], split[0], Integer.parseInt(split[1]));
            for (int j = 0; j < infoLength; j++) {

                if (queryObject[i].score > userScores[j].score) {
                    continue;
                }
                if (!queryObject[i].equals(userScores[j])) {
                    continue;
                }
                result[i]++;
            }

        }
        return result;
    }

    private class UserScore {
        final String lang;
        final String job;
        final String career;
        final String soulFood;
        final int score;

        public UserScore(String lang, String job, String career, String soulFood, int score) {
            this.lang = lang;
            this.job = job;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserScore userScore = (UserScore) o;

            return (score <= userScore.score && (Objects.equals(lang, "-") || Objects.equals(lang, userScore.lang)))
            && (Objects.equals(job, "-") || Objects.equals(job, userScore.job))
            && (Objects.equals(career, "-") || Objects.equals(career, userScore.career))
            && (Objects.equals(soulFood, "-") || Objects.equals(soulFood, userScore.soulFood));
        }

        @Override
        public int hashCode() {
            return Objects.hash(lang, job, career, soulFood, score);
        }
    }

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(new Solution().solution(info, query)));
    }
}
```