package com.example.homework_oop.stage3

class DebitCardWithBonusPercent() : DebitCard() {
    // Бонусные баллы в размере 1% от покупок
    init {
        println("Подключены бонусные баллы от покупок в размере 1%")
    }

    private var bonusPoints: Double = 0.0

    override fun pay(sum: Int): Boolean {
        return if (super.pay(sum)) {
            addBonusPoints(sum)
            true
        } else
            false
    }

    override fun getAvailableFundsInfo() {
        super.getAvailableFundsInfo()
        println("Бонусные баллы - $bonusPoints")
    }

    private fun addBonusPoints(purchaseSum: Int) {
        bonusPoints += purchaseSum * 0.01
    }

}