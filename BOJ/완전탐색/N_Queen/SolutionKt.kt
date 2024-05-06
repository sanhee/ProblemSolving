package com.example.BOJ.완전탐색.N_Queen

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var N = 0
lateinit var col: IntArray
var answer = 0

class SolutionKt

fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    col = IntArray(N)
}

// 같은 대각선에 포함되는지는 합은 행,열의 합과 차의 비교로 확인할 수 있다.
fun attackable(col1: Int, row1: Int, col2: Int, row2: Int): Boolean {
    if (row1 == row2) {
        return true
    } else if (row1 - col1 == row2 - col2) {
        return true
    } else if (row1 + col1 == row2 + col2) {
        return true
    }
    return false
}

fun recFunc(rowIndex: Int) {
    if (rowIndex == N) {
        answer++
    } else {
        for (c in 0..<N) {
            var possible = true

            for (prevRow in 0..rowIndex - 1) {
                if (attackable(rowIndex, c, prevRow, col[prevRow])) {
                    possible = false
                    break
                }
            }
            if (possible) {
                col[rowIndex] = c
                recFunc(rowIndex + 1)
                col[rowIndex] = 0
            }
        }
    }
}

fun main() {
    input()
    recFunc(0)
    print(answer)
}
