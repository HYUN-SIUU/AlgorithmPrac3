import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 카잉 달력
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val t = br.readLine().toInt()

    repeat(t) {
        val (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }
        var answer = -1

        var current = x
        while (current <= lcm(m, n)) {
            if ((current - 1) % n + 1 == y) {
                answer = current
                break
            }
            current += m
        }

        sb.append(answer).append("\n")
    }

    println(sb)
}

fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a, b)
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}
