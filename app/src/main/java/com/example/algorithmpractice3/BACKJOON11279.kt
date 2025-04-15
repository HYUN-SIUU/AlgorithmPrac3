package com.example.algorithmpractice3

/**
 * 최대 힙
 */

fun main() {
    var sb = StringBuilder()

    val n = readln().toInt()
    var heap = ArrayList<Int>()
    for (i in 1..n) {
        val num = readln().toInt()

        when(num) {
            0 -> {
                if (heap.isEmpty()) {
                    sb.append(0).append("\n")
                }
                else {
                    sb.append(heap.get(heap.size-1)).append("\n")
                    heap.removeAt(heap.size-1)
                }
            }
            else -> {
                if (heap.isEmpty()) {
                    heap.add(num)
                }
                else {
                    var index = heap.binarySearch(num)
                    if (index < 0) {
                        index *= -1
                        heap.add(index-1, num)
                    }
                    else {
                        heap.add(index, num)
                    }
                }
            }
        }
    }
    println(sb)
}