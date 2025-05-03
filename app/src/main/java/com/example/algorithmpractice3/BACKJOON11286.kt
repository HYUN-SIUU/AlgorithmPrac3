package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

/**
 * 절댓값 힙
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    var queue = PriorityQueue<Int> { o1, o2 -> if(abs(o1) == abs(o2)) o1-o2 else abs(o1) - abs(o2) }
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val x = br.readLine().toInt()

        if (x == 0) {
            if (queue.isEmpty()) {
                sb.append(0).append("\n")
            }
            else {
                sb.append(queue.poll()).append("\n")
            }
        }
        else {
            queue.offer(x)
        }
    }
    println(sb)
}