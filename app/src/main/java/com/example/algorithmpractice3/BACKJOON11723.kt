package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 집합
 */

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val n = reader.readLine().toInt()
    var set = mutableSetOf<Int>()
    for (i in 1..n) {
        var input = reader.readLine().split(" ")
        var cmd = input[0]

        when(cmd) {
            "add" -> {
                val num:Int = input[1].toInt()
                set.add(num)
            }
            "remove" -> {
                val num:Int = input[1].toInt()
                if (num in set) {
                    set.remove(num)
                }
            }
            "check" -> {
                val num:Int = input[1].toInt()
                if (num in set) {
                    sb.append(1).append("\n")
                }
                else {
                    sb.append(0).append("\n")
                }
            }
            "toggle" -> {
                val num:Int = input[1].toInt()
                if (num in set) {
                    set.remove(num)
                }
                else {
                    set.add(num)
                }
            }
            "all" -> {
                for (i in 1..20) {
                    set.add(i)
                }
            }
            "empty" -> {
                set.clear()
            }
        }
    }
    print(sb)
}