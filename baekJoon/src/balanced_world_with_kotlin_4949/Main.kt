package balanced_world_with_kotlin_4949

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

/**
 * Created by Crab on 2020-03-16.
 */

object Main {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        var string: String
        while (bufferedReader.readLine().also { string = it } != ".") {
            val stack = Stack<Char>()
            var condition = true
            for (element in string) {
                if (element == '(' || element == '[') {
                    stack.push(element)
                }
                if (element == ')' || element == ']') {
                    if (stack.size == 0) {
                        condition = false
                        break
                    }
                    if (element == ')') {
                        if (stack.peek() != '(') {
                            condition = false
                            break
                        } else {
                            stack.pop()
                        }
                    }
                    if (element == ']') {
                        if (stack.peek() != '[') {
                            condition = false
                            break
                        } else {
                            stack.pop()
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                println("no")
                continue
            }
            if (condition) {
                println("yes")
            } else {
                println("no")
            }
        }
    }
}