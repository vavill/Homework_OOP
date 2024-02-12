package com.example.homework_oop.stage3

fun main() {
    val dc = DebitCard()
    dc.topUpBalance(3000)
    dc.pay(2000)
    dc.getBalanceInfo()
    dc.pay(2000)

    println()

    val cc = CreditCard()
    cc.topUpBalance(1000)
    cc.pay(5000)
    cc.getAvailableFundsInfo()
    cc.pay(7000)
    cc.topUpBalance(9000)
    cc.getAvailableFundsInfo()

    println()

    val dcwbp = DebitCardWithBonusPercent()
    dcwbp.topUpBalance(100000)
    dcwbp.getAvailableFundsInfo()
    dcwbp.pay(8000)
    dcwbp.pay(13000)
    dcwbp.pay(25000)
    dcwbp.getAvailableFundsInfo()

    println()

    val dcwc = DebitCardWithCashback()
    dcwc.topUpBalance(100000)
    dcwc.getAvailableFundsInfo()
    dcwc.pay(8000)
    dcwc.pay(13000)
    dcwc.pay(25000)
    dcwc.getAvailableFundsInfo()

    println()

    val ccwa = CreditCardWithAccumulation()
    ccwa.getAvailableFundsInfo()
    ccwa.topUpBalance(8000)
    ccwa.topUpBalance(13000)
    ccwa.topUpBalance(25000)
    ccwa.topUpBalance(250000)
    ccwa.pay(108000)
    ccwa.getAvailableFundsInfo()
}