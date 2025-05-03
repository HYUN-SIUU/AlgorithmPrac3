package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue

/**
 * 단지번호붙이기
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine().toCharArray().map { it - '0' }.toIntArray() }

    var section = 2
    var house = PriorityQueue<Int>()
    for (i in 0..n-1) {
        for (j in 0..n-1) {
            if (graph[i][j] == 1) {
                checkSection(graph, i, j, section, house)
                section++
            }
        }
    }

    sb.append(house.size).append("\n")
    while (house.isNotEmpty()) {
        sb.append(house.poll()).append("\n")
    }
    println(sb)
}

fun checkSection(graph: Array<IntArray>, i: Int, j: Int, section: Int, house: PriorityQueue<Int>) {
    var queue = LinkedList<IntArray>()
    var num = 0
    var n = graph.size - 1

    queue.add(intArrayOf(i, j))
    graph[i][j] = section
    num++

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (k in 0..3) {
            val nx = x + dx[k]
            val ny = y + dy[k]

            if (nx in 0..n && ny in 0..n && graph[nx][ny] == 1) {
                queue.add(intArrayOf(nx, ny))
                graph[nx][ny] = section
                num++
            }
        }
    }
    house.add(num)
}
