package com.example.codility.test

class Soltuion

fun solutionTask1(S: String, L: Array<String>): Int {
    // 문자열 S로부터 각 문자의 등장 횟수를 계산하여 맵으로 저장
    val scnt = S.groupingBy { it }.eachCount().toMutableMap()

    // 각 이름을 만들 수 있는 최대 횟수를 계산하기 위해 maxret 초기화
    var maxret = 0

    // 이름 배열 L의 각 이름에 대해 반복
    L.forEach { name ->
        // 이름을 구성하는 각 문자의 빈도수를 계산
        val ncnt = name.groupingBy { it }.eachCount()

        // 현재 이름을 최대 몇 번 만들 수 있는지 계산하는 변수
        var curret = Int.MAX_VALUE

        // 이름 구성 문자를 순회하면서 각 문자를 몇 번 사용할 수 있는지 확인
        ncnt.forEach { (char, count) ->
            // S 문자열에 해당 문자가 없다면 0번 만들 수 있음
            if (char !in scnt) {
                curret = 0
                return@forEach
            }
            // 현재 문자를 사용하여 이름을 만들 수 있는 최대 횟수 계산
            curret = minOf(curret, scnt[char]!! / count)
        }

        // 지금까지 계산된 이름들 중 최대 생성 가능 횟수를 갱신
        maxret = maxOf(maxret, curret)
    }

    // 계산된 최대 횟수 반환
    return maxret
}

fun solutionTask2(A: IntArray, R: Int): Int {
    if (A.size == R) return 0 // 예외 처리: R이 A의 크기와 같은 경우, 반환할 수 있는 유형의 수는 0입니다.
    val n = A.size
    val freq = HashMap<Int, Int>() // 각 원소의 빈도 수를 저장할 HashMap
    var uniqueCount = 0 // 유니크한 원소의 수

    // 초기 윈도우 설정 (전체 배열에서 마지막 R 원소를 제외한 부분)
    for (i in 0 until n - R) {
        freq[A[i]] = freq.getOrDefault(A[i], 0) + 1
        if (freq[A[i]] == 1) uniqueCount++ // 새로운 원소가 추가되면 유니크 카운트 증가
    }

    var maxUnique = uniqueCount // 최대 유니크 원소의 수

    // 슬라이딩 윈도우
    for (i in 0 until R) {
        val outElement = A[i] // 윈도우에서 제거될 원소
        val inElement = A[n - R + i] // 윈도우에 추가될 원소

        // 제거될 원소 처리
        freq[outElement] = freq[outElement]!! - 1
        if (freq[outElement] == 0) {
            uniqueCount-- // 제거된 원소가 더 이상 존재하지 않으면 유니크 카운트 감소
            freq.remove(outElement)
        }

        // 추가될 원소 처리
        freq[inElement] = freq.getOrDefault(inElement, 0) + 1
        if (freq[inElement] == 1) uniqueCount++ // 새로 추가된 원소가 유니크하면 카운트 증가

        maxUnique = maxOf(maxUnique, uniqueCount) // 최대 유니크 원소 수 업데이트
    }

    return maxUnique // 최대 유니크 원소 수 반환
}

fun main() {
    // println(solutionTask1(S = "LILLYBILLYBOO", L = arrayOf("BILL", "MARIA", "LILLY")))
    // println(solutionTask1(S = "LILLYBILLYBOOB", L = arrayOf("BILL", "LLY", "LLY")))

    // println(solutionTask2(A = intArrayOf(2, 3, 1, 4, 2, 2), R = 3))
    println(solutionTask2(A = intArrayOf(2, 3, 1, 1, 2), R = 2))
}
