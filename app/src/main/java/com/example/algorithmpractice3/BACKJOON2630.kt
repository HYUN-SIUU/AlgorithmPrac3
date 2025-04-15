package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 색종이 만들기
 */

var white = 0
var blue = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = br.readLine().toInt()
    val paper = Array(n) { IntArray(n) }
    for (i in 1..n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            paper[i-1][j-1] = line[j-1]
        }
    }

    divide(paper, 0, 0, n)

    println(white)
    println(blue)
}

fun divide(paper: Array<IntArray>, x: Int, y: Int, size: Int) {
    if (check(paper, x, y, size)) {
        if (paper[x][y] == 0) white++
        else blue++
        return
    }

    val newSize = size / 2
    divide(paper, x, y, newSize)
    divide(paper, x, y + newSize, newSize)
    divide(paper, x + newSize, y, newSize)
    divide(paper, x + newSize, y + newSize, newSize)
}

fun check(paper: Array<IntArray>, x: Int, y: Int, size: Int): Boolean {
    val color = paper[x][y]
    for (i in x until x + size) {
        for (j in y until y + size) {
            if (paper[i][j] != color) return false
        }
    }
    return true
}
