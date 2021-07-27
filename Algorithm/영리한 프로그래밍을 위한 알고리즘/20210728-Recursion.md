

Recursive Thinking

- 절차적언어, 객체지향언어와 같은 프로그램을 작성하는 또다른 관점

- 반복문->재귀, 재귀->반복문 변환 가능

- 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야함.
- 모든 case는 결국 base case로 수렴



순환적 알고리즘 설계

- 암시적 매개변수를 명시적 매개변수로 변경

- for문은 검색할 끝은 명시돼있지만, 시작위치가 암시돼있음.

  ```java
  int search(int[] data,  int n, int target){
  	for(int i=0 ...)
      ...
  }
  ```

  

  

순차 탐색

- 반으로 쪼개서 순환하는 방식이 참신했다.



```java
int search(int [] data, int begin, int end, int target){
    if(begin > end){ // 탐색 결과가 없다면
       return -1;
    }else{
        int middle = (begin+end)/2;
        if(data[middle] == target){
            return middle;
        }
        // 재귀시작
        int index = search(data, begin, middle-1, target);
        
        if(index != -1){ // 탐색 결과가 없다면
            return index;
        }else{ // 반으로 나눈 반대편 탐색 시작
            return search(data, middle+1, end, target);
            
        }
    }
    
}


```

