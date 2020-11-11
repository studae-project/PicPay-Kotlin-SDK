package me.ian.payments

import me.ian.others.QrCode
import java.util.*

data class CreatedPayment(val referenceId: String, val paymentUrl: String, val expiresAt: Date, val qrCode: QrCode)