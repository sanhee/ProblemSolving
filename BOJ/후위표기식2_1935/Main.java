package com.example.BOJ.후위표기식2_1935;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        char[] arrayPostfix = postfix.toCharArray();


        Stack<Double> stack = new Stack<>();

        for(int i=0; i< arrayPostfix.length;i++) {
            if(Character.isAlphabetic(arrayPostfix[i])){
                stack.push(Double.parseDouble(br.readLine()));
            }else if(stack.size()>1){
                char operator = arrayPostfix[i];
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                stack.push(calculator(operand1,operator,operand2));
            }
        }

        while (!stack.isEmpty()){
            bw.write(String.format("%.2f",stack.pop()));  // 소수 두번째 자리까지
        }

        bw.flush();
    }

    public static Double calculator(double operand1, char operator, double operand2){

        switch (operator){
            case '+':
                return operand1+operand2;
            case '-':
                return operand1-operand2;
            case '*':
                return operand1*operand2;
            case '/':
                return operand1/operand2;
        }
        return 0.0;
    }
}
