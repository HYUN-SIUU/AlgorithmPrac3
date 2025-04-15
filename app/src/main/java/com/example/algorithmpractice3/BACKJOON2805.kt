package com.example.algorithmpractice3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.time.times

/**
 * 나무 자르기
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var trees: List<Int> = br.readLine().split(" ").map { it.toInt() }
    trees = trees.sortedDescending()

    var index = 1
    while (index < trees.size) {
        if (trees[index-1] == trees[index]) {
            if (index == trees.size - 1) {
                break
            }
            else {
                index++
            }
        }
        else {
            break
        }
    }
    var h = trees[index]
    var need:Long = ((trees[0] - h) * index).toLong()

    while (true) {
        if (need >= m) {
            println(h)
            break
        }
        else {
            h--
            if (index != trees.size - 1) {
                if (h <= trees[index+1]) {
                    index++
                    while (index < trees.size - 1) {
                        if (trees[index] == trees[index+1]) {
                            index++
                        }
                        else {
                            break
                        }
                    }
                }
            }
            need += index+1
        }
    }
}