package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val e = br.readLine().toInt()
    var graph = Array(n+1) {IntArray(n+1) {0} }
    for (i in 1..e) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }

    var set = mutableSetOf<Int>()
    var stack = Stack<Int>()
    set.add(1)
    stack.push(1)
    for (i in 2..n) {
        if (graph[1][i] == 1) {
            set.add(i)
            stack.push(i)
        }
    }

    while (!stack.empty()) {
        val row = stack.pop()
        if (graph[row][0] == 1) {
            continue
        }
        for (i in 1..n) {
            if (graph[row][i] == 1) {
                set.add(i)
                stack.push(i)
            }
        }
        graph[row][0] = 1
    }
    println(set.size - 1)
}
