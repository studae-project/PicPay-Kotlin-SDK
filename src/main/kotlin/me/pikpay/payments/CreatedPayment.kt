package me.pikpay.payments

import me.pikpay.qrcode.QrCode
import java.util.*

data class CreatedPayment(val referenceId: String, val paymentUrl: String, val expiresAt: Date, val qrCode: QrCode)