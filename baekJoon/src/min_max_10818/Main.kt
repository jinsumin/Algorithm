package min_max_10818

import java.util.*

/**
 * Created by Crab on 2020-03-25.
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (x in 1..n) {
        val a = scanner.nextInt()
        if (a > max) {
            max = a
        }
        if (a < min) {
            min = a
        }
    }
    println("$min $max")
}
