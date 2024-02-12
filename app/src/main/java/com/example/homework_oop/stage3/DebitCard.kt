package com.example.homework_oop.stage3

open class DebitCard : BankCard() {
    init {
        println("Оформлена новая дебетовая карта")
    }

    override fun topUpBalance(sum: Int) {
        balance += sum
        println("Ваш баланс пополнен на $sum. Баланс: $balance")
    }

    override fun pay(sum: Int): Boolean {
        return if (balance - sum >= 0) {
            balance -= sum
            println("Оплата покупки на сумму $sum. Баланс: $balance")
            true
        } else {
            println("Отказ. Недостаточно средств для оплаты на сумму $sum. Баланс: $balance")
            false
        }
    }

    override fun getBalanceInfo() {
        println("Ваш баланс - $balance")
    }

    override fun getAvailableFundsInfo() {
        println("Ваш баланс - $balance") // метод не нужен в данном классе
    }


}