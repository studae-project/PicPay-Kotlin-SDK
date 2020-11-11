package me.ian.builders

import me.ian.buyer.Buyer

class BuyerBuilder(cpf : String) {

    private val buyer = Buyer(cpf = cpf)

    fun name(firstName : String, lastName : String) {
        buyer.firstName = firstName
        buyer.lastName = lastName
    }

    fun email(email : String) {
        buyer.email = email
    }

    fun phone(phone : String) {
        buyer.phone = phone
    }

    fun build() : Buyer = buyer
}