package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 계단 오르기
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var score = IntArray(n+1)
    for (i in 1..n) {
        score[i] = br.readLine().toInt()
    }

    var dp = IntArray(n+1)
    if (n >= 1) dp[1] = score[1]
    if (n >= 2) dp[2] = score[1] + score[2]

    for (i in 3..n) {
        dp[i] = maxOf(
            dp[i - 2] + score[i],
            dp[i - 3] + score[i - 1] + score[i]
        )
    }
    println(dp[n])
}