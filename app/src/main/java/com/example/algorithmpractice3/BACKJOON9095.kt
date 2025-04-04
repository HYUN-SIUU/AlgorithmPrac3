package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    var dp = IntArray(11)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..10) {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }
    // 4 7
    // 5 13
    // 6 24
    // 7 44
    // 8 81
    // 9 149
    // 10 274

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val n = br.readLine().toInt()
        sb.append(dp[n]).append("\n")
    }
    println(sb)
}