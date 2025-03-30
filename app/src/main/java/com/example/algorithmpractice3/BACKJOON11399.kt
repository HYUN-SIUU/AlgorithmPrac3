package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * ATM
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val input = br.readLine().split(" ")

    var time = mutableListOf<Int>()
    for (i in 0..n-1) {
        time.add(input[i].toInt())
    }
    time.sort()

    var total = 0
    var nn = n
    for (i in 0..n-1) {
        total += time[i] * nn
        nn--
    }
    println(total)
}