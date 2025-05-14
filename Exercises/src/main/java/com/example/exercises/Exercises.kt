package com.example.exercises

/**
 * Exercise 1: Complete the code to make the program print "Mary is 20 years old".
 */
fun exercise1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

/**
 * Exercise 2: Create two lists and print the sum of their sizes.
 */
fun exercise2() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf("a", "b")
    println("Total size: ${list1.size + list2.size}")
}

/**
 * Exercise 3: Create a map from numbers to words (1 to 3), and print the word for number 2.
 */
fun exercise3() {
    val numbersMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    println(numbersMap[2])
}

/**
 * Exercise 4: Dice game — if both rolls are equal, print "You win", else "You lose".
 */
fun exercise4() {
    val dice1 = (1..6).random()
    val dice2 = (1..6).random()
    println("Dice: $dice1 and $dice2")
    println(if (dice1 == dice2) "You win" else "You lose")
}

/**
 * Exercise 5: Match button input with action using 'when'.
 */
fun exercise5(button: String) {
    val action = when (button) {
        "A" -> "Jump"
        "B" -> "Run"
        "X" -> "Attack"
        "Y" -> "Defend"
        else -> "Unknown"
    }
    println(action)
}

/**
 * Exercise 6: Print numbers 1 to 100 with FizzBuzz logic.
 */
fun exercise6() {
    for (i in 1..100) {
        when {
            i % 15 == 0 -> println("fizzbuzz")
            i % 3 == 0 -> println("fizz")
            i % 5 == 0 -> println("buzz")
            else -> println(i)
        }
    }
}

/**
 * Exercise 7: Count how many slices of pizza until you reach 8.
 */
fun exercise7() {
    var slices = 0
    do {
        println("You ate a slice.")
        slices++
    } while (slices < 8)
    println("You are full.")
}

/**
 * Exercise 8: Write a function that repeats an action N times.
 */
fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) action()
}

/**
 * Exercise 8 usage: Print "Hello" 5 times.
 */
fun exercise8() {
    repeatN(5) { println("Hello") }
}

/**
 * Exercise 9: Create a list of URLs from list of user IDs using lambdas.
 */
fun exercise9() {
    val userIds = listOf(1, 2, 3)
    val urls = userIds.map { id -> "https://example.com/user/$id" }
    println(urls)
}

/**
 * Exercise 10: Create a data class for Employee and print details.
 */
data class Employee(var name: String, var salary: Double)

fun exercise10() {
    val emp = Employee("Alice", 50000.0)
    println(emp)
}

/**
 * Exercise 11: Use safe call operator to get string length.
 */
fun exercise11() {
    val input: String? = null
    val length = input?.length
    println("Length: $length")
}

/**
 * Exercise 12: Use Elvis operator to assign a default if value is null.
 */
fun exercise12() {
    val username: String? = null
    val displayName = username ?: "Guest"
    println("Hello, $displayName")
}

/**
 * Run all exercises
 */
fun main() {
    println("Exercise 1:")
    exercise1()
    println("\nExercise 2:")
    exercise2()
    println("\nExercise 3:")
    exercise3()
    println("\nExercise 4:")
    exercise4()
    println("\nExercise 5:")
    exercise5("X")
    println("\nExercise 6:")
    exercise6()
    println("\nExercise 7:")
    exercise7()
    println("\nExercise 8:")
    exercise8()
    println("\nExercise 9:")
    exercise9()
    println("\nExercise 10:")
    exercise10()
    println("\nExercise 11:")
    exercise11()
    println("\nExercise 12:")
    exercise12()
}
