package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

/**
 * 연결 요소의 개수
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var graph = Array(n+1) { IntArray(n+1) {0} }
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }

    var check = BooleanArray(n+1) { false }
    var queue:Queue<Int> = LinkedList()
    var cc = 0
    for (i in 1..n) {
        if (!check[i]) {
            queue.add(i)
            check[i] = true
            while (!queue.isEmpty()) {
                var node = queue.poll()
                for (j in 1..n) {
                    if (graph[node][j] == 1 && !check[j]) {
                        queue.add(j)
                        check[j] = true
                    }
                }
            }

            cc++
        }
    }
    println(cc)
}