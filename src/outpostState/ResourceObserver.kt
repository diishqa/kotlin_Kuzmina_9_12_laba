package outpostState

class ResourceObserver{
    fun nabl(resource: String, old: Int, new: Int){
        println("Наблюдатель: $resource измелися с $old -> $new")
    }
}