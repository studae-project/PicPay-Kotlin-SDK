package me.ian.payments

import java.util.*

data class GeneratedPayment(val referenceId: String, val paymentUrl: String, val expiresAt: Date, val qrCode: QrCode)