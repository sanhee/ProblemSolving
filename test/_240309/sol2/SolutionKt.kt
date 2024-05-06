package com.example.test._240309.sol2

import java.util.*
import kotlin.collections.ArrayList

class SolutionKt

fun bfs(start: Int, nodeCount: Int, adjacencyList: Array<ArrayList<Int>>, visited: BooleanArray): Boolean {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val poll = queue.poll()

        for (neighbor in adjacencyList[poll]) {
            if (!visited[neighbor]) {
                if (neighbor == poll + 1 || adjacencyList[poll].contains(poll + 1)) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                } else {
                    return false
                }
            }
        }
    }

    for (i in 1..nodeCount) {
        if (!visited[i]) return false
    }

    return true
}

fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
    val adjacencyList: Array<ArrayList<Int>> = Array(N + 1) { ArrayList() }
    val visited = BooleanArray(N + 1)

    for (idx in A.indices) {
        adjacencyList[A[idx]].add(B[idx])
        adjacencyList[B[idx]].add(A[idx])
    }
    adjacencyList.forEach { it.sort() }

    return bfs(
        start = 1,
        nodeCount = N,
        adjacencyList = adjacencyList,
        visited = visited,
    )
}

fun main() {
    println(
        solution(
            N = 4,
            A = intArrayOf(1, 2, 4, 4, 3),
            B = intArrayOf(2, 3, 1, 3, 1),
        ),
    )
}
