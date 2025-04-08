package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 구간 합 구하기 4
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val num = br.readLine().split(" ").map { it.toInt() }

    var prefixSum = LongArray(n+1)
    for (i in 1..n) {
        prefixSum[i] = prefixSum[i-1] + num[i-1]
    }
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        sb.append(prefixSum[b]-prefixSum[a-1]).append("\n")
    }
    println(sb)
}