package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import kotlin.collections.ArrayList

/**
 * 최소 힙
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val n = br.readLine().toInt()
    var array = ArrayList<Long>()
    for (i in 1..n) {
        when (val cmd = br.readLine().toLong()) {
            0L -> {
                if (array.isEmpty()) {
                    sb.append(0).append("\n")
                }
                else {
                    sb.append(array[0]).append("\n")
                    array.removeAt(0)
                }
            }
            else -> {
                if (array.isEmpty()) {
                    array.add(cmd)
                }
                else {
                    if (cmd > array.get(array.size-1)) {
                        array.add(cmd)
                    }
                    else {
                        var index = array.binarySearch(cmd)
                        if (index < 0) {
                            index *= -1
                            array.add(index-1, cmd)
                        }
                        else {
                            array.add(index, cmd)
                        }
                    }
                }
            }
        }
    }
    println(sb)
}