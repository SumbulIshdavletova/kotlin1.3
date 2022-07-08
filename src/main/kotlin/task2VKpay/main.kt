package task2VKpay

fun main() {

    var commissionAmount = calculateCommission("Maestro", 4, 20_000)
    println("Комиссия равна: $commissionAmount")

}

fun calculateCommission(paymentType: String = "VkPay", previousTransactions: Int = 0, amount: Int): Double {
    val commission = if (amount * previousTransactions > 75_000) 0.6 else paymentTypeCommission(paymentType) //+ 20
    return (amount * commission / 100)
}

fun paymentTypeCommission(paymentType: String) = when (paymentType) {
    "VkPay" -> 0.0
    "Maestro", "MasterCard" -> 0.0  // 0.6 + 20 но только если превышает 75_000 к месяц
    else -> 0.75 // val minCommission = 35.0
}

//    if (amount < maxAmount) {
//        if (isCard==true) {
//            commissionAmount = (amount * commission / 100)
//            if (commissionAmount < minCommission) {
//                commissionAmount = minCommission
//            } else {
//                commissionAmount
//            }
//        } else {
//            commissionAmount = 0.0
//        }
//        println("Комиссия равна: $commissionAmount")
//    } else {
//        println("Перевод превышает максимальную сумму перевода!")
//    }

//if (isCard == false && amount > maxAmount) {
//    println("Перевод превышает максимальную сумму перевода!")
//} else {
//    if (isCard == true) {
//        commissionAmount = (amount * commission / 100)
//        if (commissionAmount < minCommission) {
//            commissionAmount = minCommission
//        } else {
//            commissionAmount
//        }
//    } else {
//        commissionAmount = 0.0
//    }
//    println("Комиссия равна: $commissionAmount")
//}
//}