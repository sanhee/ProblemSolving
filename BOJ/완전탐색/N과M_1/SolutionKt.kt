package com.example.BOJ.완전탐색.N과M_1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

var N = 0
var M = 0
lateinit var selected: IntArray // M 사이즈 만큼
lateinit var visited: BooleanArray // 중복을 막기 위한 자료구조
var result = StringBuilder()

fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    selected = IntArray(M)
    visited = BooleanArray(N + 1) // 인덱스 위치가 곧 숫자를 의미, 중복 제거를 위한 자료 구조
}

fun recFunc(column: Int) {
    // 수열을 M개에 대해 모두 고른 경우
    if (column == M) {
        selected.forEach { result.append(it).append(" ") }
        result.append("\n")
    } else {
        // 1 부터 N 까지의 자연 수를 고른다.
        for (i in 1..N) {
            selected[column] = i
            if (!visited[i]) {
                visited[i] = true
                recFunc(column = column + 1)
                visited[i] = false
            }
        }
    }
}

fun main() {
    init()

    recFunc(column = 0)
    print(result.toString())
}
