package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 좌표 압축
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val n = br.readLine().toInt()
    val num = br.readLine().split(" ").map { it.toInt() }
    var copy = IntArray(n)
    for (i in 0..n-1) {
        copy[i] = num[i]
    }
    var map = HashMap<Int, Int>()

    copy.sort()
    var value = 0
    for (i in 0..n-1) {
        if (map.containsKey(copy[i])) {
            continue
        }
        else{
            map.put(copy[i], value)
            value++
        }
    }

    for (i in 0..n-1) {
        sb.append(map.getValue(num[i])).append(" ")
    }
    println(sb)
}