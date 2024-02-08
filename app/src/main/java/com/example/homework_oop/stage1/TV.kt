package com.example.homework_oop.stage1

class TV(
    var brand: String,
    var model: String,
    var diagonal: Int,

    ) {
    private var isTVon: Boolean = false
    private var channels: List<String> = listOf()
    private var volume: Int = 10
    private var activeChannel: Int = 1
    private var numberOfChannels = 0
    var isChannelsSetUp = false

    companion object {
        const val MAX_VOLUME = 100
        const val MIN_VOLUME = 0
    }

    init {
        println("Приобретен новый TV:\n $brand $model $diagonal\"\n")
    }

    // включение/выключение ТВ
    fun turnOnOff() {
        isTVon = !isTVon

        if (isTVon)
            println("\nTV включен\n")
        else
            println("\nTV выключен\n")

        if (channels.isNotEmpty())
            displayActiveChannel()
    }

    // Громкость +
    fun volumeUp(changedValue: Int) {
        if (!isTVon) turnOnOff()
        if (volume + changedValue in MIN_VOLUME..MAX_VOLUME)
            volume += changedValue
        else if (volume + changedValue > MAX_VOLUME)
            volume = MAX_VOLUME
        displayVolume(volume)
    }

    // Громкость -
    fun volumeDown(changedValue: Int) {
        if (!isTVon) turnOnOff()
        if (volume - changedValue in MIN_VOLUME..MAX_VOLUME)
            volume -= changedValue
        else if (volume - changedValue < MIN_VOLUME)
            volume = MIN_VOLUME
        displayVolume(volume)
    }

    private fun displayVolume(volume: Int) {
        val progressBarLength = 20 // Длина полосы громкости
        val filledBars = (volume * progressBarLength) / 100

        println("Громкость: $volume")

        print("[")
        repeat(filledBars) { print("#") }
        repeat(progressBarLength - filledBars) { print("-") }
        println("]\n")
    }

    // Смена канала
    fun changeChannel(pressedNumber: Int) {
        if (!isTVon) turnOnOff()

        when {
            (pressedNumber > numberOfChannels) -> println("Канал $pressedNumber не настроен")
            (pressedNumber < 1) -> println("Введите номер канала от 1 до $numberOfChannels")
            (pressedNumber in 1..numberOfChannels) -> activeChannel = pressedNumber
            else -> println("Некорректный ввод!")
        }
        displayActiveChannel()
    }

    // Смена канала в порядке возр/убыв
    fun changeChannelByStep(direction: String) {
        if (!isTVon) turnOnOff()
        when (direction) {
            "->" -> {
                activeChannel++
                if (activeChannel > numberOfChannels)
                    activeChannel = 1
                println("\nПереключение канала вперед")
            }

            "<-" -> {
                activeChannel--
                if (activeChannel < 1)
                    activeChannel = numberOfChannels
                println("\nПереключение канала назад")
            }

            else -> println("Type -> or <-")
        }
        displayActiveChannel()
    }

    private fun displayActiveChannel() {
        println("Выбран канал: $activeChannel - ${channels[activeChannel - 1]}")
    }

    // Настройка каналов
    fun setUpChannels(numberOfChannels: Int) {
        if (!isTVon) turnOnOff()
        channels = Channels.getChannels(numberOfChannels)
        this.numberOfChannels = channels.size
        isChannelsSetUp = true

        println("Произведена настройка ${channels.size} каналов")
    }

    fun showChannels() {
        if (!isTVon) turnOnOff()
        channels.forEachIndexed { index, channel ->
            println("Канал ${index + 1} - $channel")
        }
        println()
    }
}

