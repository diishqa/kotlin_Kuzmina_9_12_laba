package outpostState
import kotlin.properties.Delegates
class ObservableResource (
    var name: String,
    amountInit: Int
){
    var amount: Int by Delegates.observable(amountInit) {_, old, new -> println("Ресурс $name " +
            "изменен: $old -> $new")}
}