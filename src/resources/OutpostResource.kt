package resources
import kotlin.properties.Delegates
data class OutpostResource(
    val id: Int,
    val name: String,
    var amountInit: Int
) {
    var amount: Int by Delegates.observable(amountInit) {
        _, old, new -> println("Ресурсы [$name] изменился: $old -> $new")
    }
}
object SystemLogger {
    init {
        println("SystemLogger иницилизирован")
    }
    fun log(message: String){
        println("[LOG] $message")
    }
}

fun main() {
    val gas = OutpostResource(1, "Gas", 100)
    val mineral = OutpostResource(2, "Minerals", 250)
    println("Успех! Вы добыли дополнительное количество минералов: ${mineral.amount + 50}")
    val bonusMineral=mineral.copy(id = 3, name = "Minerals Bonus", amountInit = mineral.amount + 50)
    println(gas.toString())
    println(mineral.toString())
    println(bonusMineral.toString())

}
