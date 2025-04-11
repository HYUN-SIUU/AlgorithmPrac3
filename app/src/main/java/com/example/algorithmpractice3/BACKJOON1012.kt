package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

/**
 * 유기농 배추
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        var ground = Array(n) { IntArray(m) }
        for (j in 1..k) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            ground[b][a] = 1
        }
        sb.append(findBug(ground)).append("\n")
    }
    println(sb)
}

fun findBug(ground: Array<IntArray>): Int {
    var bug = 0

    val n = ground.size
    val m = ground[0].size

    var stack = Stack<IntArray>()

    for (i in 0..n-1) {
        for (j in 0..m-1) {
            if (ground[i][j] == 1) {
                var a = i
                var b = j
                while (true) {
                    if (ground[a][b] == 1) {
                        ground[a][b]++
                    }

                    if (b != m-1 && ground[a][b+1] == 1) {
                        val array = IntArray(2)
                        array[0] = a
                        array[1] = b
                        stack.push(array)
                        b++
                    }
                    else if (a != n-1 && ground[a+1][b] == 1) {
                        val array = IntArray(2)
                        array[0] = a
                        array[1] = b
                        stack.push(array)
                        a++
                    }
                    else if (b != 0 && ground[a][b-1] == 1) {
                        val array = IntArray(2)
                        array[0] = a
                        array[1] = b
                        stack.push(array)
                        b--
                    }
                    else if (a != 0 && ground[a-1][b] == 1) {
                        val array = IntArray(2)
                        array[0] = a
                        array[1] = b
                        stack.push(array)
                        a--
                    }
                    else {
                        if (stack.isEmpty()) {
                            break
                        }
                        val array = stack.pop()
                        a = array[0]
                        b = array[1]
                    }
                }
                bug++
            }
        }
    }

    return bug
}
