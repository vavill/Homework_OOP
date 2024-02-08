package com.example.homework_oop.stage2

import kotlin.random.Random

class Fish(
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
        println("$name is swimming\n")
    }

    override fun reproduce(): Animal {
        println("$name was born.\nEnergy: $energy\nWeight: $weight\nMax age:$maxAge\n")
        return Fish(
            name,
            Random.nextInt(1, 10),
            Random.nextInt(1,5),
            maxAge
        )
    }
}