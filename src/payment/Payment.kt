package payment

import javax.crypto.interfaces.PBEKey
import javax.print.attribute.standard.JobStateReason

sealed class PaymentResult{
    data class Success(val id: String) : PaymentResult()
    data class Error(val reason: String) : PaymentResult()
    object Processing : PaymentResult()
}
enum class CardType {
    VISA, MASTERCARD, MIR, UNKNOWN
}
data class Payment(
    val card: String,
    val sum: Int,
    val type: CardType = CardType.UNKNOWN
)
