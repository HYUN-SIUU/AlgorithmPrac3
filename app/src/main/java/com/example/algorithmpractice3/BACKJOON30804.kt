package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 과일 탕후루
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val fruits  = br.readLine().split(" ").map { it.toInt() }

    var checkFruit = ArrayList<Int>()
    var checkNumber = ArrayList<Int>()
    var set = HashSet<Int>()

    set.add(fruits[0])
    var number = 1
    for (i in 1..n-1) {
        set.add(fruits[i])
        if (fruits[i] == fruits[i-1]) {
            number++
        }
        else {
            checkFruit.add(fruits[i-1])
            checkNumber.add(number)
            number = 1
        }
    }
    checkFruit.add(fruits[n-1])
    checkNumber.add(number)

//    var sb1 = StringBuilder()
//    for (k in checkFruit) {
//        sb1.append(k).append(" ")
//    }
//    println(sb1)
//    var sb2 = StringBuilder()
//    for (k in checkNumber) {
//        sb2.append(k).append(" ")
//    }
//    println(sb2)

    if (set.size <= 2) {
        println(n)
    }
    else {
        var max = 0
        for (i in 0 until checkFruit.size) {
            var bundleSet = HashSet<Int>()
            var temp = 0
            var j = i
            while (j < checkFruit.size) {
                bundleSet.add(checkFruit[j])
                if (bundleSet.size > 2) break
                temp += checkNumber[j]
                j++
            }
            max = maxOf(max, temp)
        }
        println(max)
    }
}