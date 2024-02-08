package com.example.homework_oop.stage1

fun main() {
    val listOfTV = mutableListOf<TV>()
    val listTVMenu = ListTVMenu(listOfTV)
    val addTVMenu = AddTVMenu(listOfTV)

    val menu = ConsoleMenu(listOf(listTVMenu, addTVMenu), listOfTV)

    menu.runMenu()

//    Просто вывод инфы:

//    var tv1 = TV("Mi TV", "A2", 45)
//    tv1.turnOnOff()
//    pause()
//    tv1.setUpChannels(5)
//    pause()
//    tv1.showChannels()
//    pause()
//    tv1.changeChannel(1)
//    pause()
//    tv1.changeChannel(3)
//
//    repeat(4) {
//        tv1.changeChannelByStep("->")
//        pause()
//    }
//
//    tv1.turnOnOff()
//    pause()
//
//    repeat(3) {
//        tv1.changeChannelByStep("<-")
//        pause()
//    }
//
//    repeat(6) {
//        tv1.volumeUp(20)
//        pause()
//    }
//
//    tv1.turnOnOff()
//    pause()
//
//    repeat(6) {
//        tv1.volumeDown(20)
//        pause()
//    }

    //var tv2 = TV("Samsung", "UE50AU7100", 50)
    //var tv3 = TV("TCL", "55P637", 55)


}

fun pause() {
    Thread.sleep(2000)
}

