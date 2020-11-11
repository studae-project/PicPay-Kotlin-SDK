package me.ian.payments

import me.ian.enums.PicPayPaymentStatus

data class PaymentStatus(val authorizationId: String, val referenceId: String, val paymentStatus: PicPayPaymentStatus)