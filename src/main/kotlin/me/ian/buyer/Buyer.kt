package me.ian.buyer

data class Buyer(
    var firstName : String? = null,
    var lastName: String? = null,
    var cpf : String,
    var email : String? = null,
    var phone : String? = null
)