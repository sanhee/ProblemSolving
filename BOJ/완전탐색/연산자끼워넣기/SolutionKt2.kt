package com.example.BOJ.완전탐색.연산자끼워넣기

import java.io.BufferedReader
import java.io.InputStreamReader

class SolutionKt2

var N = 0
var maxResult = Integer.MIN_VALUE
var minResult = Integer.MAX_VALUE
lateinit var numbers: IntArray
lateinit var operators: IntArray

fun calculate(operand1: Int, operatorIndex: Int, operand2: Int): Int = when (operatorIndex) {
    0 -> operand1 + operand2
    1 -> operand1 - operand2
    2 -> operand1 * operand2
    else -> operand1 / operand2
}

fun recFunc(depth: Int, currentTotal: Int) {
    if (depth == N) { // 이미 이전 뎁스에서 numbers의 마지막 엘리먼트를 계산했음.
        maxResult = Math.max(maxResult, currentTotal)
        minResult = Math.min(minResult, currentTotal)
        return
    } else {
        for (op in 0..3) {
            if (operators[op] > 0) {
                operators[op]--

                recFunc(
                    depth = depth + 1,
                    currentTotal = calculate(operand1 = currentTotal, operatorIndex = op, operand2 = numbers[depth]),
                )
            }
        }
    }
}

fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    numbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    operators = br.readLine().split(" ").map { it.toInt() }.toIntArray()
}

fun main() {
    init()
    recFunc(1, numbers[0]) // 초기값을 지정해주면서 뎁스가 시작된걸로 가정
    println(maxResult)
    println(minResult)
}
