package com.example.BOJ.완전탐색.연산자끼워넣기

import java.io.BufferedReader
import java.io.InputStreamReader

class SolutionKt

var N = 0
lateinit var nums: IntArray
lateinit var operators: IntArray
var maxResult = Integer.MIN_VALUE
var minResult = Integer.MAX_VALUE

fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    operators = br.readLine().split(" ").map { it.toInt() }.toIntArray()
}

fun calculate(operand1: Int, operatorIdx: Int, operand2: Int): Int = when (operatorIdx) {
    0 -> operand1 + operand2
    1 -> operand1 - operand2
    2 -> operand1 * operand2
    else -> operand1 / operand2
}

fun recFunc(depth: Int, currentTotal: Int) {
    // 모든 연산을 한 경우, 연산자 개수는 N-1
    if (depth == N) {
        maxResult = maxOf(maxResult, currentTotal)
        minResult = minOf(minResult, currentTotal)
        return
    }
    for (operatorIdx in 0..3) {
        if (operators[operatorIdx] > 0) {
            operators[operatorIdx]--
            recFunc(
                depth = depth + 1,
                currentTotal = calculate(
                    operand1 = currentTotal,
                    operatorIdx = operatorIdx,
                    operand2 = nums[depth], // 첫 depth를 줄 때 다음 숫자 인덱스를 줘서 가능한 것
                ),
            )
            operators[operatorIdx]++
        }
    }
}

fun main() {
    input()
    // 연산을 시작할 때 첫 번째 수(nums[0])를 초기 값으로 설정하고,
    // depth가 1인 건, 그 다음에 오는 수(nums[1], nums[2], ..., nums[N-1])와 주어진 연산자들을 사용하여 연산을 수행해야 하기 때문
    // 첫 번째 수는 이미 연산에 사용된 상태로 간주되며, 다음 수와 연산자로 연산을 계속하는 구조
    recFunc(1, nums[0])
    println(maxResult)
    println(minResult)
}
