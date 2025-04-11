package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

/**
 * DFS와 BFS
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    var graph = Array(n+1) { IntArray(n+1) {0} }
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }

    var stack = Stack<Int>()
    var check = BooleanArray(graph.size) { false }
    sb.append(getDFS(graph, v, stack, check)).append("\n")

    check.forEachIndexed { index, b -> check[index] = false}
    sb.append(getBFS(graph, v, check))

    println(sb)
}

fun getDFS(graph:Array<IntArray>, start: Int, stack: Stack<Int>, check: BooleanArray): String {
    var route = StringBuilder()

    check[start] = true
    stack.add(start)
    route.append("$start ")

    for (i in 1..graph.size - 1) {
        if (graph[start][i] == 1 && !check[i]) {
            route.append("${getDFS(graph, i, stack, check)}" )
        }
    }

    return route.toString()
}

fun getBFS(graph: Array<IntArray>, start: Int, check: BooleanArray): String {
    val route = StringBuilder()
    val queue: Queue<Int> = LinkedList()

    queue.add(start)
    check[start] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        route.append("$node ")

        for (i in 1 until graph.size) {
            if (graph[node][i] == 1 && !check[i]) {
                queue.add(i)
                check[i] = true
            }
        }
    }

    return route.toString()
}
