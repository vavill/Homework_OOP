package com.example.homework_oop.stage2

import kotlin.random.Random

abstract class Animal(
    var name: String,
    var energy: Int,
    var weight: Int,
    var maxAge: Int,
) {
    private var currentAge = 10
    val isTooOld: Boolean
        get() {
            return if (currentAge >= maxAge)
                true
            else
                false
        }


    fun sleep() {
        energy += 5
        currentAge++
        println("$name is sleeping\n")
    }

    fun eat() {
        energy += 3
        weight++
        if (tryIncrementAge(currentAge))
            currentAge++
        println("$name is eating\n")
    }

    open fun move() {
        energy -= 5
        weight--
        if (tryIncrementAge(currentAge))
            currentAge++
        println("$name is moving")
    }

    private fun tryIncrementAge(currentAge: Int): Boolean =
        !isTooOld && weight > 0 && energy > 0 && Random.nextBoolean()

    abstract fun reproduce(): Animal
}