package me.pikpay.builders

import me.pikpay.buyer.Buyer

class BuyerBuilder(cpf : String) {

    private val buyer = Buyer(cpf = cpf)

    fun name(firstName : String?, lastName : String?): BuyerBuilder {
        buyer.firstName = firstName
        buyer.lastName = lastName
        return this
    }

    fun email(email : String?) : BuyerBuilder {
        buyer.email = email
        return this
    }

    fun phone(phone : String?): BuyerBuilder {
        buyer.phone = phone
        return this
    }

    fun build() : Buyer = buyer
}