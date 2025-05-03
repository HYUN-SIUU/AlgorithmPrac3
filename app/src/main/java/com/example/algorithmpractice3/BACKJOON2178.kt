package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/**
 * 미로 탐색
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var graph = Array(n+1) { IntArray(m+1) }
    for (i in 1..n) {
        val input = br.readLine().toCharArray()
        for (j in 1..m) {
            graph[i][j] = input[j-1] - '0'
        }
    }

    var check = Array(n+1) { BooleanArray(m+1) {false} }
    var queue = LinkedList<IntArray>()
    queue.add(intArrayOf(1,1))
    check[1][1] = true
    var route = 0
    main@ while (true) {
        val size = queue.size
        for (i in 1..size) {
            val whkvy = queue.poll()
            val a = whkvy[0]
            val b = whkvy[1]
            if (a == n && b == m) {
                break@main
            }

            if (a != n && graph[a+1][b] == 1 && !check[a+1][b]) {
                queue.add(intArrayOf(a+1, b))
                check[a+1][b] = true
            }
            if (a != 0 && graph[a-1][b] == 1 && !check[a-1][b]) {
                queue.add(intArrayOf(a-1, b))
                check[a-1][b] = true
            }
            if (b != m && graph[a][b+1] == 1 && !check[a][b+1]) {
                queue.add(intArrayOf(a, b+1))
                check[a][b+1] = true
            }
            if (b != 0 && graph[a][b-1] == 1 && !check[a][b-1]) {
                queue.add(intArrayOf(a, b-1))
                check[a][b-1] = true
            }
        }
        route++
    }
    println(route+1)
}