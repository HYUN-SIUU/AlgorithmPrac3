package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

/**
 * 숨바꼭질
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine().split(" ").map { it.toInt() }
    val n = input[0]
    val k = input[1]

    if (n >= k) {
        println(n-k)
    }
    else {
        val size = 100000
        var time = IntArray(size + 1) { -1 }
        var queue:Queue<Int> = LinkedList()

        time[n] = 0
        queue.add(n)

        while (queue.isNotEmpty()) {
            val x = queue.poll()

            if (x == k) {
                break
            }

            val nextMove = listOf(x-1, x+1, 2*x)
            for (next in nextMove) {
                if (next in 0..size && time[next] == -1) {
                    time[next] = time[x] + 1
                    queue.add(next)
                }
            }
        }
        println(time[k])
    }
}