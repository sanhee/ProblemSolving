

# [오픈채팅방](https://programmers.co.kr/learn/courses/30/lessons/42888)
-  answer index를 초기에 잘못 설정해서 약간 헤맴 그거 말곤 어려움 없었음


```java
class Solution {
    public String[] solution(String[] record) {

        // key: ID, value: Nickname
        Map<String, String> enterMap = new HashMap<>();

        for (String log : record) {
            String[] splitLog = log.split(" ");

            String command = splitLog[0];
            String userId = splitLog[1];
            String userNickname = "";

            if (splitLog.length > 2) {
                userNickname = splitLog[2];
            }

            if (command.equals("Enter") || command.equals("Change")) {
                enterMap.put(userId, userNickname);
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String log : record) {
            String[] splitLog = log.split(" ");

            String command = splitLog[0];
            String userId = splitLog[1];

            switch (command) {
                case "Enter":
                    answerList.add(enterMap.get(userId) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answerList.add(enterMap.get(userId) + "님이 나갔습니다.");
                    break;

            }
        }

        return answerList.stream().toArray(String[]::new);
    }
}
```