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

        val buyer = BuyerBuilder(
            cpf = cpf
        ).email("email@gmail.com")
            .

        pikPay.createPayment(
            Payment(
                referenceId = referenceId,
                callBackUrl = callBackUrl,
                returnUrl = returnUrl,
                value = 20.0,
                expiresAt = ZonedDateTime.now(ZoneOffset.UTC).plusDays(daysYouWant).format(DateTimeFormatter.ISO_INSTANT),
                buyer =
            )
        )

    }

}