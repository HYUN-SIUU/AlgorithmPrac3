package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/**
 * 쉬운 최단거리
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var graph = Array(n) { IntArray(m) }
    var result = Array(n) { IntArray(m) {-1} }
    var x = 0
    var y = 0
    for (i in 0..n-1) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0..m-1) {
            graph[i][j] = input[j]
            if (input[j] == 2) {
                x = i
                y = j
            }
            if (input[j] == 0) {
                result[i][j] = 0
            }
        }
    }

    result[x][y] = 0
    var queue = LinkedList<IntArray>()
    queue.add(intArrayOf(x, y))
    while(queue.isNotEmpty()) {
        var (a, b) = queue.poll()

        if (a != 0 && graph[a-1][b] == 1 && result[a-1][b] == -1) {
            result[a-1][b] = result[a][b] + 1
            queue.add(intArrayOf(a-1, b))
        }
        if (b != m-1 && graph[a][b+1] == 1 && result[a][b+1] == -1) {
            result[a][b+1] = result[a][b] + 1
            queue.add(intArrayOf(a, b+1))
        }
        if (a != n-1 && graph[a+1][b] == 1 && result[a+1][b] == -1) {
            result[a+1][b] = result[a][b] + 1
            queue.add(intArrayOf(a+1, b))
        }
        if (b != 0 && graph[a][b-1] == 1 && result[a][b-1] == -1) {
            result[a][b-1] = result[a][b] + 1
            queue.add(intArrayOf(a, b-1))
        }
    }

    for (line in result) {
        for (num in line) {
            sb.append(num).append(" ")
        }
        sb.append("\n")
    }
    println(sb)
}