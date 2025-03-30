package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 비밀번호 찾기
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map() { it.toInt() }
    val map = mutableMapOf<String, String>()
    for (i in 1..n) {
        val (site, password) = br.readLine().split(" ")
        map.set(site, password)
    }

    var sb = StringBuilder()
    for (i in 1..m) {
        val site = br.readLine()
        sb.append(map.get(site)).append("\n")
    }
    println(sb)
}