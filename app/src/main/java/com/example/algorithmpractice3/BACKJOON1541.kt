package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

/**
 * 잃어버린 괄호
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val expression = br.readLine().split("-")
    var finalCal:Queue<Int> = LinkedList()
    for (i in 0..expression.size-1) {
        var temp:Queue<Char> = LinkedList()
        var num:Queue<Int> = LinkedList()
        for (s in expression[i]) {
            when (s) {
                '+' -> {
                    var k = ""
                    while (!temp.isEmpty()) {
                        k += temp.poll()
                    }
                    num.add(k.toInt())
                }
                else -> {
                    temp.add(s)
                }
            }
        }
        var k = ""
        while (!temp.isEmpty()) {
            k += temp.poll()
        }
        num.add(k.toInt())

        var final = 0
        while (!num.isEmpty()) {
            final += num.poll()
        }
        finalCal.add(final)
    }

    var result = finalCal.poll()
    while (!finalCal.isEmpty()) {
        result -= finalCal.poll()
    }
    println(result)
}