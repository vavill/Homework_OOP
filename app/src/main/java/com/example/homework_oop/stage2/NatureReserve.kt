package com.example.homework_oop.stage2

import kotlin.random.Random

class NatureReserve(private var animals: MutableList<Animal>) {
    init {
        println("Welcome to Nature Reserve!\n")
    }

    fun action(times: Int) {
        repeat(times) {
            val copyAnimals = ArrayList(animals) // copy for avoid concurrentmodificationexception
            val iterator = copyAnimals.iterator()

            while (iterator.hasNext()) {
                val animal = iterator.next()
                randomAction(animal)

                if (animal.isTooOld) {
                    println("††† ${animal.name} died †††")
                    iterator.remove()
                }
            }
            animals = copyAnimals
        }

        println("\nSurvivors:")
        if (animals.isEmpty())
            println("no one survived   o7")
        else
            animals.forEachIndexed { index, animal ->
                println("${index + 1}. ${animal.name}")
            }
        println("\n${animals.size} animals left in Nature reserve".uppercase())
    }

    private fun randomAction(animal: Animal) {
        when (Random.nextInt(0, 4)) {
            0 -> {
                animal.sleep()
            }

            1 -> {
                animal.eat()
            }

            2 -> {
                animal.move()
            }

            3 -> {
                val _animal = animal.reproduce()
                val nameWithoutNumber = animal.name.substring(0, animal.name.length - 1)
                val list = animals.filter {
                    it.name.contains(nameWithoutNumber)
                }
                _animal.name = "$nameWithoutNumber ${list.size + 1}"
                animals.add(_animal)
            }
        }
    }


}