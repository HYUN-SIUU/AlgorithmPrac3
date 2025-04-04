package com.example.algorithmpractice3

/**
 * 패션왕 신해빈
 */

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val tc = br.readLine().toInt()
    for (i in 1..tc) {
        val n = br.readLine().toInt()
        var clothes = mutableMapOf<String, MutableSet<String>>()
        for (j in 1..n) {
            val (name, type) = br.readLine().split(" ")

            if (type in clothes) {
                clothes[type]?.add(name)
            } else {
                clothes[type] = mutableSetOf(name)
            }
        }

        var total = 1
        clothes.forEach { t, u ->
            total *= u.size + 1
        }
        sb.append(total-1).append("\n")
    }
    println(sb)
}