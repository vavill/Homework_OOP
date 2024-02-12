package com.example.homework_oop.stage3

abstract class BankCard {
    var balance: Int = 0

    abstract fun topUpBalance(sum: Int)
    abstract fun pay(sum: Int): Boolean
    abstract fun getBalanceInfo()
    abstract fun getAvailableFundsInfo()





}