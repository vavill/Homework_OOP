package com.example.homework_oop.stage2

fun main() {
    val animals = mutableListOf<Animal>()

    repeat(5) {
        animals.add(Bird("Bird ${it + 1}", 20, 10, 30))
    }

    repeat(3) {
        animals.add(Dog("Dog ${it + 1}", 30, 20, 40))
    }

    repeat(2) {
        animals.add(Fish("Fish ${it + 1}", 25, 15, 30))
    }

    val reserve = NatureReserve(animals)
    reserve.action(50)

}