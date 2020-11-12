<p align="center">
  <a href="https://dev.wirecard.com.br/v2.0/">
    <img src="https://i.imgur.com/xawrA16.png" alt="Wirecard logo" width=600>
  </a>
</p>

This is a unofficial SDK for [PicPay](https://ecommerce.picpay.com/doc/) written in Kotlin. It's quite simple to use and fast.

## ❓ How to install?

To install this SDK is very easy. Follow the steps below


#### Maven

Add this repository in your repositories:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

and put this dependency: 

```xml
<dependency>
	<groupId>com.github.studae-project</groupId>
	<artifactId>PikPay</artifactId>
	<version>64204a5c0f</version>
</dependency>
```

#### Gradle

Add this repository:

```gradle
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
```

And the dependency:

```gradle
dependencies {
  implementation 'com.github.studae-project:PikPay:64204a5c0f'
}
```


## ❓ How to use?

First of all, create a new account [here](https://lojista.picpay.com/registro/form) and get your [PicPay token](https://painel-empresas.picpay.com/integracoes).
After that, [open the API](https://ecommerce.picpay.com/doc/). Even you are using a SDK it's important to know what you're working with. You also can take doubts about what is any field here.
Let's take a look at how to use the SDK.

```kotlin
val pikPay = PikPay(
   picPayToken = picPayToken,
)
```

### 💲 Creating a new payment

```kotlin

// in order to create a new payment you need to setup the buyer first;
// the CPF need to be formated like: 123.456.789-10;
// the only field obligatory is the cpf;
// the numbers must be formatted like: +55 00 00000-0000;

val buyer = BuyerBuilder(cpf = cpf)
  .email("email@gmail.com")
  .name("Joe", "Doe")
  .phone("+55 00 00000-0000")
  .build()
  
val createdPayment = pikPay.createPayment(
  Payment(
    referenceId = referenceId,
    callBackUrl = callBackUrl,
    returnUrl = returnUrl,
    value = 20.0,
    expiresAt = ZonedDateTime.now(ZoneOffset.UTC).plusDays(daysYouWant).format(DateTimeFormatter.ISO_INSTANT),
    buyer = buyer
  )
)

```

After you create a new payment you can get some relevant informations from it. Let's take a look:


#### Payment relevant informations 

```kotlin
createdPayment.paymentUrl
createdPayment.qrCode.base64
```

### ℹ Checking a payment status

The reference id you're going to put as field is the same you put when you created a new payment.

```kotlin
val paymentStatus = pikPay.getPaymentStatus(
  referenceId = referenceId
)
```

You also might want to treat incoming notifications from the PicPay into your API. You can treat them using:


```kotlin
val paymentNotification = pikPay.getNotification(body = body)
```

### ❌ Cancelling payments


```kotlin
pikPay.cancelPayment(
  referenceId = referenceId,
  authorizationId = authorizationId
)
```

**Attention**: you only need to provide the authorizationId if the payment is already paid!


### 🌟 That's all

Hope you liked the SDK. If yes, please consider starring the project. You're free to use this project in a comercial project and modifiy to code. It's completely up to you.
I just wanted to help.

