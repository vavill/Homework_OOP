package com.example.homework_oop.stage2

import kotlin.random.Random

class Dog(
    name: String,
    energy: Int,
    weight: Int,
    maxAge: Int
) : Animal(
    name,
    energy,
    weight,
    maxAge
) {
    override fun move() {
        super.move()
        println("$name is running\n")
    }

    override fun reproduce(): Animal {
        println("$name was born.\nEnergy: $energy\nWeight: $weight\nMax age:$maxAge\n")
        return Dog(
            name,
            Random.nextInt(1, 10),
            Random.nextInt(1,5),
            maxAge
        )
    }
}