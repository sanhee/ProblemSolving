package com.example.test._240309.sol1

class SolutionKt

fun solution(N_arg: Int) {
    var N: Int = N_arg
    var enable_print = 0

    while (N > 0) {
        if (enable_print == 0 && N % 10 != 0) {
            enable_print = 1
        }
        if (enable_print == 1) {
            print(N % 10)
        }
        N = N / 10
    }
}

fun main() {
    solution(54321) // 11001
}
