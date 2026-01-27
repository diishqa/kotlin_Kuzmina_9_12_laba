package outpostState
import resources.OutpostResource
import java.io.File
object StateStorage{
    private const val FILE_NAME = "state.txt"
    fun save(resource: ObservableResource){
        val file = File(FILE_NAME)
        file.writeText("${resource.name};${resource.amount}")
        println("Состояние сохранено")
    }
    fun load(): ObservableResource? {
        val file=File(FILE_NAME)
        if (!file.exists()) return null
        val p=file.readText().split(";")
        return ObservableResource(p[0], p[1].toInt())
    }

}