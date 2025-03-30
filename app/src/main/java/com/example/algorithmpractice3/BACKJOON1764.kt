package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * 듣보잡
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var listen = mutableSetOf<String>()
    for (i in 1..n) {
        val name = br.readLine()
        listen.add(name)
    }

    var result = mutableListOf<String>()
    for (i in 1..m) {
        val name = br.readLine()
        if (name in listen) {
            result.add(name)
        }
    }
    result.sort()
    println(result.size)
    result.forEach { println(it) }
}