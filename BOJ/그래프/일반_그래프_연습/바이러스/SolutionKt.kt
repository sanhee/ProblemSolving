package com.example.BOJ.그래프.일반_그래프_연습.바이러스

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class SolutionKt

var countOfComputer: Int = 0
var countOfEdge: Int = 0
lateinit var adj: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    countOfComputer = br.readLine().toInt()
    countOfEdge = br.readLine().toInt()
    adj = Array(countOfComputer + 1) { ArrayList() }
    visited = BooleanArray(countOfComputer + 1)

    for (m in 0..countOfEdge) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        adj[x].add(y)
        adj[y].add(x)
    }
}

fun bfs(start: Int) {
    val Q: Queue<Int> = LinkedList()

    Q.add(start)
    visited[start] = true

    while (Q.isNotEmpty()) {
        val poll = Q.poll()

        for (otherComputer in adj[poll]) {
            if (visited[otherComputer]) {
                countOfEdge
            }
            Q.add(otherComputer)
            visited[otherComputer] = true
        }
    }
}

fun process() {
    bfs(1)
    var ans = 0

    for (i in 2..countOfComputer) {
        if (visited[i]) {
            ans++
        }
    }
    println(ans)
}

fun main() {
    input()
    process()
}
