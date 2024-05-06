package com.example.test._240309.sol3

fun solution(N: Int, S: String): Int {
    if (S.isEmpty()) return N * 2

    val reserved = S.split(" ")
        .map { it.takeWhile { char -> char.isDigit() } to it.last() }
        .groupBy({ it.first.toInt() }, { it.second })

    var availableSeats = 0

    for (row in 1..N) {
        val rowReservations: List<Char> = reserved[row] ?: emptyList()

        val fourSeater1 = setOf('B', 'C', 'D', 'E')
        val fourSeater2 = setOf('F', 'G', 'H', 'J')

        if (!rowReservations.intersect(fourSeater1).any()) {
            availableSeats++
        }

        if (!rowReservations.intersect(fourSeater2).any()) {
            availableSeats++
        }
    }

    return availableSeats
}

fun main() {
    println(solution(N = 2, S = "1A 2F 1C") == 2)
    println(solution(N = 22, S = "1A 3C 2B 20G 5A") == 41)
    println(solution(N = 1, S = "") == 2)
}
