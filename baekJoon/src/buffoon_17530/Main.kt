package buffoon_17530

import java.util.*

/**
 * Created by Crab on 2020-03-13.
 */
fun main(args:Array<String>): Unit {
    val scanner: Scanner = Scanner(System.`in`)
    val numberOfPeople = scanner.nextInt()
    val array: Array<Int> = Array(numberOfPeople) { scanner.nextInt()}
    val carlos = array[0]
    var flag = false
    for(i in 1 until numberOfPeople) {
        if(array[i] > carlos) {
            flag = true
            break
        }
    }
    if(flag) {
        println("N")
    } else {
        println("S")
    }
}