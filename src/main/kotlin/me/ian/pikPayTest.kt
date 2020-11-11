package me.ian

import me.ian.builders.BuyerBuilder
import me.ian.payments.Payment
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class pikPayTest {

    fun test() {

        val pikPay = PikPay(
            "teste"
        )


        val paymentNotification = pikPay.getNotification(body = body)

    }

}