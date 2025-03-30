package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 동전 0
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var (n, k) = br.readLine().split(" ").map() { it.toInt() }
    var coin = mutableListOf<Int>()
    for (i in 1..n) {
        val num = br.readLine().toInt()
        coin.add(num)
    }

    var index = 0
    for (i in 0..n-1) {
        if (k < coin[i]) {
            index = i - 1
            break
        }
        if (i == n-1) {
            index = i
        }
    }

    var count = 0
    for (i in index downTo 0) {
        while (k >= coin[i]) {
            k -= coin[i]
            count++
        }
    }
    println(count)
}