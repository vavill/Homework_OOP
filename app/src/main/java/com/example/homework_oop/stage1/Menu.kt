package com.example.homework_oop.stage1

interface MenuItem {
    val condition: List<String>
    fun display()
    fun execute()

    companion object Obj {
        var menuLevel = 0
    }
}

class ConsoleMenu(private val items: List<MenuItem>, private val listOfTv: List<TV>) {
    fun displayMenu() {
        when (MenuItem.menuLevel) {
            0 -> {
                items.forEachIndexed { index, item ->
                    println("$index. ${item.condition}")
                }
                println("99. Выйти")
            }

            1 -> {
                listOfTv.forEachIndexed { index, tv ->
                    println("$index. ${tv.brand} ${tv.model} ${tv.diagonal}\"")
                }
                println("${listOfTv.size}. Назад")
            }

            2 -> {
                val functionList = listOf(
                    "Вкл/Выкл TV",
                    "Настроить каналы",
                    "Показать каналы",
                    "Переключить канал",
                    "Канал вперед",
                    "Канал назад",
                    "Громкость +",
                    "Громкость -",
                )

                functionList.forEachIndexed { index, item ->
                    println("$index. $item")
                }

                println("${functionList.size}. Назад")
            }

        }

    }

    fun runMenu() {
        var choice: Int
        var chosenTV = 0
        do {
            displayMenu()
            print("\nВыберите пункт меню: ")
            choice = readLine()?.toIntOrNull() ?: -1

            when (MenuItem.menuLevel) {
                0 -> when {
                    choice in 0 until items.size -> items[choice].execute()
                    choice == 99 -> println("Выход из меню.")
                    else -> println("Некорректный выбор. Попробуйте снова.")
                }

                1 -> when {
                    choice in 0 until listOfTv.size -> {
                        MenuItem.menuLevel = 2
                        chosenTV = choice
                    }

                    choice == listOfTv.size -> {
                        MenuItem.menuLevel = 0
                    }

                    else -> println("Некорректный выбор. Попробуйте снова.")
                }

                2 -> when {
                    choice in 0 until 8 -> {
                        val tv = listOfTv[chosenTV]
                        when (choice) {
                            0 -> {
                                tv.turnOnOff()
                            }

                            1 -> {
                                if (tv.isChannelsSetUp)
                                    println("Каналы уже настроены\n")
                                else {
                                    print("Введите количество каналов (1-25): ")
                                    tv.setUpChannels(readln().toInt())
                                }
                            }

                            2 -> {
                                if (!tv.isChannelsSetUp)
                                    println("Сначала настройте каналы\n")
                                else
                                    tv.showChannels()
                            }

                            3 -> {
                                if (!tv.isChannelsSetUp)
                                    println("Сначала настройте каналы\n")
                                else {
                                    print("Введите номер канала: ")
                                    tv.changeChannel(readln().toInt())
                                }
                            }

                            4 -> {
                                if (!tv.isChannelsSetUp)
                                    println("Сначала настройте каналы\n")
                                else
                                    tv.changeChannelByStep("->")
                            }

                            5 -> {
                                if (!tv.isChannelsSetUp)
                                    println("Сначала настройте каналы\n")
                                else
                                    tv.changeChannelByStep("<-")
                            }

                            6 -> {
                                println("Увеличить громкость на: ")
                                tv.volumeUp(readln().toInt())
                            }

                            7 -> {
                                println("Уменьшить громкость на: ")
                                tv.volumeDown(readln().toInt())
                            }
                        }
                    }

                    choice == 8 -> MenuItem.menuLevel = 1

                    else -> println("Некорректный выбор. Попробуйте снова.")
                }
            }

        } while (choice != 99)
    }
}

class ListTVMenu(private val listOfTV: MutableList<TV>) : MenuItem {
    override val condition = listOf("Список TV")

    override fun display() {
        if (listOfTV.isNotEmpty()) {
            println("Список TV:")
            listOfTV.forEach { tv ->
                println("${tv.brand} ${tv.model} ${tv.diagonal}\"")
            }
            println()
        } else {
            MenuItem.menuLevel = 0
            println("\nСписок пуст.\n")
        }
    }

    override fun execute() {
        MenuItem.menuLevel = 1
        display()
    }
}

class AddTVMenu(private val listOfTV: MutableList<TV>) : MenuItem {
    override val condition = listOf("Добавить TV")
    override fun display() {
        println("Добавить TV")
    }

    override fun execute() {
        println("Введите бренд:")
        val brand: String = readLine() ?: ""

        println("Введите модель:")
        val model: String = readLine() ?: ""

        println("Введите размер диагонали:")
        val diagonal: Int = readLine()?.toIntOrNull() ?: 0

        listOfTV.add(TV(brand, model, diagonal))
        println("TV добавлен.\n")
    }
}
