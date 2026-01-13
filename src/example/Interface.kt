package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("Останавливаемся...")
    }
}
interface Worker{
    fun work()
}
interface Student {
    fun study()
}
interface VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play audio")
}
class Car(
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft (
    override val model: String,
    override val number: String
) : Movable {
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }

    override fun stop() = println("Приземляемся...")
}
class WorkingStudent(val name: String) : Worker, Student {
    override fun work() =println("$name работает")
    override fun study() =println("$name учится")
}
class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()

    }

}

fun travel(obj: Movable) = obj.move()

fun main() {
    val player = MediaPlayer()
    player.play()
    val car = Car("LADA", "134LAD")
    val aircraft = Aircraft("Boeing", "737")
    val dasha = WorkingStudent("Dasha")
    dasha.work()
    dasha.study()
    aircraft.move()
    aircraft.stop()
//    example.travel(car)
//    example.travel(aircraft)

}

