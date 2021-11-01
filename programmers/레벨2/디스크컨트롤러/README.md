

## 첫 시도
- heap에 원하는 것처럼 정렬이 안됨

```java
public class Solution {

    static class Job {
        int requestTime;
        int processTime;

        public Job(int requestTime, int processTime) {
            this.requestTime = requestTime;
            this.processTime = processTime;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        // 요청시간 순으로 오름차순 정렬
        Arrays.sort(jobs, (int[] a, int[] b) -> a[0] - b[0]);

        PriorityQueue<Job> heap = new PriorityQueue<>(Comparator.comparingInt(j -> j.processTime));

        for (int[] job : jobs) {
            heap.add(new Job(job[0], job[1]));
        }
        System.out.println();
        System.out.println(heap);

        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(new Solution().solution(jobs) + ": 9");

        jobs = new int[][]{{0, 3}, {2, 4}, {9, 1}};
        System.out.println(new Solution().solution(jobs) + ": 11/3");
    }
}

```

## 참고

- 그림 그리면서 저런 흐름은 파악했었는데, 구현을 못했음.
- 다음엔 할 수 있을듯!

```java
public class Solution {


    public int solution(int[][] jobs) {

        // 요청시간 순으로 오름차순 정렬
        Arrays.sort(jobs, (int[] a, int[] b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((job1,job2)->job1[1]-job2[1]);

        int answer = 0;
        int end = 0; // 수행되고 난 후
        int jobIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 개수

        // 요청이 모두 수행될때까지 반복
        while(count < jobs.length){

            // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                heap.add(jobs[jobIdx++]);
            }

            // 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
            // (end를 요청의 가장 처음으로 맞춰줌)
            if(heap.isEmpty()){
                end = jobs[jobIdx][0];
            }
            // 작업이 끝나기 전(end 이전) 들어온 요청 중 수행시간이 짧은 요청부터 수행
            else{
                int[] temp = heap.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }

        return (int) Math.floor(answer/ jobs.length);
    }
    

```
