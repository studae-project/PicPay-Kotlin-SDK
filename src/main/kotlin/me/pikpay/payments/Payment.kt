package me.pikpay.payments

import me.pikpay.buyer.Buyer
import java.util.*

data class Payment(
    val referenceId : String,
    val callBackUrl : String,
    val returnUrl : String? = null,
    val value : Double,
    val expiresAt : String,
    val buyer : Buyer
)