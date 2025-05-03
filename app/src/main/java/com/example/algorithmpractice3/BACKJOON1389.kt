package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

/**
 * 케빈 베이컨의 6단계 법칙
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var friends = Array(n+1) { IntArray(n+1) {0} }
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        friends[a][b] = 1
        friends[b][a] = 1
    }

    var kb = IntArray(n+1) {0}

    for (i in 1..n) {
        var connect = BooleanArray(n+1) {false}
        var queue:Queue<Int> = LinkedList()

        connect[i] = true
        for (j in 1..n) {
            if (friends[i][j] == 1) {
                connect[j] = true
                queue.add(j)
                kb[i]++
            }
        }

        var level = 2
        while (!queue.isEmpty()) {
            val size = queue.size
            for (k in 1..size) {
                val person = queue.poll()
                for (j in 1..n) {
                    if (friends[person][j] == 1 && !connect[j]) {
                        connect[j] = true
                        queue.add(j)
                        kb[i] += level
                    }
                }
            }
            level++
        }
    }

    var min = kb[1]
    var index = 1
    for (i in 1..n) {
        if (min > kb[i]) {
            min = kb[i]
            index = i
        }
//        println(kb[i])
    }
    println(index)
}