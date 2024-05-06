package com.example.BOJ.정렬.국영수

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class SolutionKt

var N = 0
var students: MutableList<Student> = mutableListOf()

data class Student(
    val name: String,
    val korean: Int,
    val english: Int,
    val math: Int,
) : Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return when {
            this.korean != other.korean -> {
                other.korean - this.korean
            }

            this.english != other.english -> {
                this.english - other.english
            }

            this.math != other.math -> {
                other.math - this.math
            }

            else -> {
                this.name.compareTo(other.name)
            }
        }
    }
}

fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    for (i in 1..N) {
        val st = StringTokenizer(br.readLine())
        students.add(
            Student(
                name = st.nextToken(),
                korean = st.nextToken().toInt(),
                english = st.nextToken().toInt(),
                math = st.nextToken().toInt(),
            ),
        )
    }
}

fun main() {
    init()
    students.sort()
    students.forEach { println(it.name) }
}
