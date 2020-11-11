package me.ian.buyer

import java.util.*

data class Payment(
    val referenceId : String,
    val callBackUrl : String,
    val returnUrl : String? = null,
    val value : Double,
    val expiresAt : Date
)