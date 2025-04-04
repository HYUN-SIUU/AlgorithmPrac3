package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 파도반 수열
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val t = br.readLine().toInt()
    var pn = IntArray(t+1)
    var max = 1
    for (i in 1..t) {
        val n = br.readLine().toInt()
        pn[i] = n
        if (n > max) {
            max = n
        }
    }


    if (max < 5) {
        for (i in 1..t) {
            if (pn[i] < 4) {
                sb.append(1).append("\n")
            }
            else {
                sb.append(2).append("\n")
            }
        }
    }
    else {
        var array = LongArray(max+1)
        array[0] = 0
        array[1] = 1
        array[2] = 1
        array[3] = 1
        array[4] = 2
        for (i in 5..max) {
            array[i] = array[i-1] + array[i-5]
        }
        for (i in 1..t) {
            sb.append(array[pn[i]]).append("\n")
        }
    }
    println(sb)
}