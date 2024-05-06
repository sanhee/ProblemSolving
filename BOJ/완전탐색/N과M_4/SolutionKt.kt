package com.example.BOJ.완전탐색.N과M_4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

var N = 0
var M = 0
var result = StringBuilder()
lateinit var selected: IntArray

class SolutionKt

fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    selected = IntArray(M + 1)
}

fun recFunc(colunm: Int) {
    if (colunm == M + 1) {
        selected.indices
            .filter { it > 0 }
            .forEach { result.append("${selected[it]} ") }
        result.append("\n")
    } else {
        val prevNumber = selected[colunm - 1]
        val startNumber: Int = if (prevNumber == 0) {
            1
        } else {
            prevNumber
        }
        for (num in startNumber..N) {
            selected[colunm] = num
            recFunc(colunm = colunm + 1)
        }
    }
}

fun main() {
    init()
    recFunc(1)
    println(result.toString())
}
