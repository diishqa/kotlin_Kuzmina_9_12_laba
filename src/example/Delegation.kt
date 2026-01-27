package example
import kotlin.properties.Delegates
interface Base {
    fun someFun()
}
class BaseImpl() : Base {
    override fun someFun() {

    }
}
class Derived(someBase: Base) : Base by someBase

interface Messanger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val programName: String) : Messanger{
    override fun sendTextMessage() = println("Send text message")
    override fun sendVideoMessage() = println("Send video message")
}
class SmartPhone(val name: String, m: Messanger): Messanger by m {
    override fun sendTextMessage() =println("Send sms")
}

interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera: PhotoDevice{
    override fun takePhoto() = println("Take a photo")
}
var counter: Int by Delegates.observable(0) {_, old, new -> println("Счетчик изменился: $old -> " +
        "$new")}

class User {
    var name: String by Delegates.observable("<no name>") { _, old, new -> println("Имя изменено:" +
            " '$old' -> '$new' ")}
}