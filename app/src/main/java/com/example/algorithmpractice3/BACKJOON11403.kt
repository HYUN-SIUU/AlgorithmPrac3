package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/**
 * 경로 찾기
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val n = br.readLine().toInt()
    var graph = Array(n) { LinkedList<Int>() }
    for (i in 0..n-1) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in 0..n-1) {
            if (input[j] == 1) {
                graph[i].add(j)
            }
        }
    }

    var check = Array(n) { IntArray(n) {0} }
    for (i in 0..n-1) {
        for (j in 0..n-1) {
            if (isConnect(graph, i, j)) {
                check[i][j] = 1
            }
        }
    }

    for (array in check) {
        for (result in array) {
            sb.append(result).append(" ")
        }
        sb.append("\n")
    }
    println(sb)
}

fun isConnect(graph:Array<LinkedList<Int>>, i: Int, j: Int): Boolean {
    if (graph[i].contains(j)) {
        return true
    }
    else {
        var queue = LinkedList<Int>()
        var check = BooleanArray(graph.size) {false}
        for (k in graph[i]) {
            queue.add(k)
            check[k] = true
        }
        while (queue.isNotEmpty()) {
            var current = queue.poll()
            for (k in graph[current]) {
                if (k == j) {
                    return true
                }
                if (!check[k]) {
                    queue.add(k)
                    check[k] = true
                }
            }
        }
        return false
    }
}