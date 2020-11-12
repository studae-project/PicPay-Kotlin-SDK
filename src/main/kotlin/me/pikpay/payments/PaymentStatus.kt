package me.pikpay.payments

import me.pikpay.enums.PicPayPaymentStatus

data class PaymentStatus(val authorizationId: String, val referenceId: String, val paymentStatus: PicPayPaymentStatus)