package example
import kotlin.properties.Delegates

class GameHero(startName: String) {
    var name: String by Delegates.observable(startName) {
        _, old, new -> println("[$old] получим новое имя: $new!")
    }
    var mana: Int by Delegates.observable(100){
        _, old, new -> println("Мана: $old -> $new")
    }
    val ultimate: String by lazy {
        println("Загружаем анимацию способности...")
        "Метеоритный дождь"
    }
}

