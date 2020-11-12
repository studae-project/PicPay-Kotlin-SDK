package me.pikpay

import com.fasterxml.jackson.databind.ObjectMapper
import me.pikpay.cancellations.CancelResponse
import me.pikpay.exceptions.PicPayGeneratePaymentException
import me.pikpay.exceptions.PicPayPaymentStatusException
import me.pikpay.payments.CreatedPayment
import me.pikpay.payments.Payment
import me.pikpay.payments.PaymentNotification
import me.pikpay.payments.PaymentStatus
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class PikPay(private val picPayToken: String) {

    private val client = OkHttpClient()
    private val mapper = ObjectMapper()

    private val baseURL = "https://appws.picpay.com/ecommerce/public/payments"
    private val json: MediaType = "application/json; charset=utf-8".toMediaType()

    fun getPaymentStatus(referenceId: String): PaymentStatus? {
        val request = Request.Builder()
            .addHeader("x-picpay-token", picPayToken)
            .url("$baseURL/$referenceId/status")
            .get()
            .build()

        val response = client.newCall(request).execute()

        if (response.code != 200) {
            throw PicPayPaymentStatusException(response.message)
        }

        return mapper.readValue(response.body?.string(), PaymentStatus::class.java)
    }

    fun createPayment(payment: Payment): CreatedPayment? {
        val jsonPayment = mapper.writeValueAsString(payment)
        val requestBody = RequestBody.Companion.create(json, jsonPayment)

        val request = Request.Builder()
            .addHeader("x-picpay-token", picPayToken)
            .url(baseURL)
            .post(requestBody)
            .build()


        val response = client.newCall(request).execute()

        if (response.code != 200) {
            throw PicPayGeneratePaymentException(response.message)
        }

        return mapper.readValue(response.body?.string(), CreatedPayment::class.java)
    }

    fun getNotification(body : String): PaymentNotification {
        return mapper.readValue(body, PaymentNotification::class.java)
    }

    fun cancelPayment(referenceId: String, authorizationId : String? = null) : CancelResponse {

        val request  = Request.Builder()
            .addHeader("x-picpay-token", picPayToken)
            .url("$baseURL/${referenceId}/cancellations")

        authorizationId?.let {
            val authId = mapper.writeValueAsString(authorizationId)
            val requestBody = RequestBody.Companion.create(json, authId)
            request.post(requestBody)
        }

        val response = client.newCall(request.build()).execute()

        if (response.code != 200) {
            throw PicPayGeneratePaymentException(response.message)
        }


        return mapper.readValue(response.body?.string(), CancelResponse::class.java)
    }


}