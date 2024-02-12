package com.example.homework_oop.stage3

class CreditCardWithAccumulation() : CreditCard() {
    // Накопление в размере 0.005% от суммы пополнений
    init {
        println("Подключено накопление 0.005% от суммы пополнений")
    }

    private var accumulationBonus: Double = 0.0

    private fun addAccumulationBonus(replenishmentSum: Int) {
        accumulationBonus += replenishmentSum * 0.00005
    }

    override fun topUpBalance(sum: Int) {
        addAccumulationBonus(sum)
        super.topUpBalance(sum)
    }

    override fun getAvailableFundsInfo() {
        super.getAvailableFundsInfo()
        println("Накопления - $accumulationBonus")
    }

}