package com.example.homework_oop.stage3

class DebitCardWithCashback() : DebitCard() {
    // Потенциальный кэшбэк 5% от покупок при условии трат больше 5000
    init {
        println("Подключен кэшбек 5% от покупок больше 5000")
    }

    private var cashback = 0.0

    override fun pay(sum: Int): Boolean {
        cashback += calculateCashback(sum)
        return super.pay(sum)
    }

    override fun getAvailableFundsInfo() {
        super.getAvailableFundsInfo()
        println("Кэшбека накоплено - $cashback")
    }

    private fun calculateCashback(purchaseSum: Int): Double {
        return if (purchaseSum > 5000)
            purchaseSum * 0.05
        else 0.0
    }
}