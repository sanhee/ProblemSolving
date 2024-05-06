package com.example.BOJ.완전탐색.N과M_3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class SolutionKt

var N = 0
var M = 0
var stringBuilder = StringBuilder()
lateinit var selected: IntArray

fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    selected = IntArray(M)
}

fun recFunc(column: Int) {
    if (column == M) {
        selected.forEach { stringBuilder.append(it).append(" ") }
        stringBuilder.append("\n")
    } else {
        for (num in 1..N) {
            selected[column] = num
            recFunc(column = column + 1)
        }
    }
}

fun main() {
    init()
    recFunc(column = 0)
    print(stringBuilder.toString())
}
