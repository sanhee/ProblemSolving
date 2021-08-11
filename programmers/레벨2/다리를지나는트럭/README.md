
# 다리를 지나는 트럭

- 전체적인 흐름은 솔루션과 비슷하게 생각을 했는데, 구현하는 과정에서 생각처럼 잘 되지 않아서 다른 사람 풀이를 참고하게 됐다.
- 나는 Queue를 2개 만들어서, 지나가는 트럭과, 지나간 트럭을 구분하려고 했는데 굳이 그렇게 할 필요가 없었다.

> https://programmers.co.kr/learn/courses/30/lessons/42583
```java
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0;

        int index = 0;
        while (index != truck_weights.length) {

            if (bridge.size() == bridge_length) {
                currentWeight -= bridge.poll();
            } else if (currentWeight + truck_weights[index] > weight) {
                bridge.add(0);
                time++;
            } else {
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                time++;
                index++;
            }
        }

        return time+bridge_length;
    }
}

```


## 다른사람 풀이2

```java

class Solution {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
```