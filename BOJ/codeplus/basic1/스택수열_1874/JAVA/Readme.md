## 스택 수열

[1874번: 스택 수열](https://www.acmicpc.net/problem/1874)

- 스택에 push 되는 순서는 `오름차순` 이다.
- pop되는 순서대로 수열 A가 만들어지기 때문에
    - A의 `첫 수`부터 순서대로 만들어보면 된다.

- m = 스택에 추가되어야 하는 수 = `스택에 들어간 마지막 수`
- A[i] = 만들어야 하는 수열 A의 수

- `m<A[i]` :  A[i]를 `pop` 해야 하기 때문에, m부터 A[i]까지의 모든 수를 순서대로 `push`

- `m>A[i]` : 불가능한 경우, pop되는 순서대로 수열 A가 만들어지기 때문이다.
- `m == A[i]`:  `pop` 을 해서 A[i]를 만들면 된다.

## 리뷰

```java
문제는 해설을 듣고나서 풀이를 해서 그렇게 큰 어려움은 없었다.
나중에도 풀 수 있을정도라면 성공한 셈인것 같다.

다른건 아니고 음.. BufferedWriter가 있어서 메모리 공간을 낭비 안하려고, 
StringBuilder를 사용하는 것을 지양하려 했다. 그런데 BufferedWrite의 write 메소드를 사용하고, 
제출하니까 `출력초과`과 발생하여 어쩔 수 없이 SB를 사용하게 되었다..왜그럴까?
```

## 내 코드

```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int cursor = 0; // 스택에 들어간 마지막 수
        StringBuilder sb = new StringBuilder();
        int testCaseNum = Integer.parseInt(br.readLine());

        while (testCaseNum-- > 0) {

            int inputSequence = Integer.parseInt(br.readLine()); // 입력된 수열

            if(cursor < inputSequence){
                while (cursor != inputSequence) {
                    stack.push(++cursor);
                    sb.append("+").append("\n");
                }
            }
            if(cursor >= inputSequence) { //스택에 들어갔던 마지막 수가 입력된 수열보다 크거나 같을 경우
                if(stack.pop()==inputSequence){
                    sb.append("-").append("\n");
                }else{ // pop 을 할때마다 수열이 만들어지므로, 불가능한 경우
                    sb=new StringBuilder();
                    sb.append("NO");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
```