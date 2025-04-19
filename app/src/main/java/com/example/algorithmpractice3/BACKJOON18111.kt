package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 마인크래프트
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, b) = br.readLine().split(" ").map { it.toInt() }
    var ground = Array(n) { IntArray(m) {0} }
    var max = 0
    var min = Int.MAX_VALUE
    for (i in 0..n-1) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for (j in 0..m-1) {
            ground[i][j] = line[j]
            if (line[j] > max) {
                max = line[j]
            }
            if (line[j] < min) {
                min = line[j]
            }
        }
    }

    var time = Int.MAX_VALUE
    var height = 0
    for (h in min..max) {
        var tempT = 0
        var tempB = b
        for (i in 0..n-1) {
            for (j in 0..m-1) {
                if (ground[i][j] > h) {
                    tempT += (ground[i][j] - h)*2
                    tempB += (ground[i][j] - h)
                }
                else if (ground[i][j] < h) {
                    tempT += (h - ground[i][j])
                    tempB -= (h - ground[i][j])
                }
            }
        }

        if (tempB >= 0) {
            if (time >= tempT) {
                time = tempT
                height = h
            }
        }
    }
    println("$time $height")
}