package com.example.homework_oop.stage3

open class CreditCard : BankCard() {
    init {
        println("Оформлена новая кредитная карта")
    }

    private val creditLimit = 10000
    private var currentCreditBalance = creditLimit

    override fun topUpBalance(sum: Int) {
        currentCreditBalance += sum

        if (currentCreditBalance >= creditLimit) {
            balance += currentCreditBalance - creditLimit
            currentCreditBalance = creditLimit
        }

        println("Ваш баланс пополнен на $sum. Баланс: ${balance + currentCreditBalance}")
    }

    override fun pay(sum: Int): Boolean {
        if (balance - sum < 0)
            if (currentCreditBalance + balance - sum < 0) {
                println("Отказ. Недостаточно средств для оплаты на сумму $sum. Баланс: ${balance + currentCreditBalance}")
                return false
            } else {
                currentCreditBalance += balance
                currentCreditBalance -= sum
                balance = 0
            }
        println("Оплата покупки на сумму $sum. Баланс: ${balance + currentCreditBalance}")
        return true
    }

    override fun getBalanceInfo() {
        println("Ваш баланс - ${balance + currentCreditBalance}")
    }

    override fun getAvailableFundsInfo() {
        println("Ваш дебетовый баланс - $balance")
        println("Ваш кредитный баланс - $currentCreditBalance")
        println("Ваш кредитный лимит - $creditLimit")
    }
}