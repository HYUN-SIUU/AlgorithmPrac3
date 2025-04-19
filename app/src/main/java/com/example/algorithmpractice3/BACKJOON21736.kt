package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

/**
 * 헌내기는 친구가 필요해
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var university = Array(n) { IntArray(m) {0} }
    var x = 0
    var y = 0
    for (i in 0..n-1) {
        val line = br.readLine().toCharArray()
        for (j in 0..m-1) {
            when(line[j].toString()) {
                "O" -> {
                    university[i][j] = 0
                }
                "X" -> {
                    university[i][j] = -1
                }
                "I" -> {
                    university[i][j] = 1
                    x = i
                    y = j
                }
                "P" -> {
                    university[i][j] = 2
                }
            }
        }
    }

    var check = Array(n) { IntArray(m) {0} }
    var friend = 0
    var queue:Queue<IntArray> = LinkedList()
    queue.add(intArrayOf(x, y))
    check[x][y] = 1
    do {
        val (x, y) = queue.poll()

        if (university[x][y] == 2) {
            friend++
            university[x][y] = 1
        }

        if (x != 0 && university[x-1][y] != -1 && check[x-1][y] == 0) {
            queue.add(intArrayOf(x-1, y))
            check[x-1][y] = 1
        }
        if (y != m-1 && university[x][y+1] != -1 && check[x][y+1] == 0) {
            queue.add(intArrayOf(x, y+1))
            check[x][y+1] = 1
        }
        if (x != n-1 && university[x+1][y] != -1 && check[x+1][y] == 0) {
            queue.add(intArrayOf(x+1, y))
            check[x+1][y] = 1
        }
        if (y != 0 && university[x][y-1] != -1 && check[x][y-1] == 0) {
            queue.add(intArrayOf(x, y-1))
            check[x][y-1] = 1
        }
    } while (!queue.isEmpty())

    if (friend == 0) {
        println("TT")
    }
    else {
        println(friend)
    }
}