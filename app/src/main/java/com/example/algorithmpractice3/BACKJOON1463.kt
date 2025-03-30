package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 1로 만들기
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = br.readLine().toInt()
    var dp = IntArray(n+1) { 0 }
    for (i in 2..n) {
        dp[i] = dp[i-1] + 1
        if (i % 2 == 0) {
            dp[i] = minOf(dp[i], dp[i/2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = minOf(dp[i], dp[i/3] + 1)
        }
    }
    println(dp[n])
}