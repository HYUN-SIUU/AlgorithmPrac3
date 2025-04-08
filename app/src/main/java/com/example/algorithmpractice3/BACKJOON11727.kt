package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 2*n 타일링 2
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    if (n == 1) {
        println(1)
    }
    else {
        var pibo = IntArray(n+1)
        pibo[1] = 1
        pibo[2] = 3
        for (i in 3..n) {
            pibo[i] = (pibo[i-1] % 10007) + (pibo[i-2] % 10007) + (pibo[i-2] % 10007)
        }
        println(pibo[n] % 10007)
    }
}