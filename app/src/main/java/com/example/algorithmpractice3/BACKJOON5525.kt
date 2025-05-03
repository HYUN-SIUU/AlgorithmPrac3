package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/**
 * IOIOI
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine().toCharArray()
    var queue = LinkedList<Int>()
    var i = 0
    while (i < m) {
        if (s[i] == 'I') {
            val pn = isPn(s, i)
            if (pn > 0) {
                queue.add(pn)
                i += 2*pn
            }
        }
        i++
    }

    var result = 0
    while (queue.isNotEmpty()) {
        val num = queue.poll()
        if (num >= n) {
            result += num - n + 1
        }
    }
    println(result)
}

fun isPn(s: CharArray, i: Int): Int {
    var index = i
    var pn = 0
    while (true) {
        if (index+2 >= s.size) {
            break
        }

        if (s[index+1] == 'O' && s[index+2] == 'I') {
            pn++
            index += 2
        }
        else {
            break
        }
    }

    return pn
}