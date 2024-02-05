package com.example.homework_oop

object Channels {
    fun getChannels(numberOfChannels: Int): List<String> = generateChannelList(numberOfChannels)
}

fun generateChannelList(size: Int): List<String> {
    val channelNames = mutableListOf<String>()

    // Генерация рандомных каналов
    repeat(size) {
        var channelName = generateRandomChannelName()
        while (channelNames.contains(channelName)) {
            channelName = generateRandomChannelName()

            if (channelNames.size > 25) // 25 - макс кол-во уникальных каналов
                break
        }
        channelNames.add(channelName)
    }

    return channelNames
}

fun generateRandomChannelName(): String {
    val prefixes = listOf("First", "Culture", "Sports", "Science", "Music")
    val suffixes = listOf("Channel", "TV", "Pro", "Hit", "Express")

    val randomPrefix = prefixes.random()
    val randomSuffix = suffixes.random()

    return "$randomPrefix $randomSuffix"
}

