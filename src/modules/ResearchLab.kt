package modules

class ResearchLab : OutpostModule(
    "Исследовательская лаборатория"
){
    override fun performAction(manager: ResourseManager) {
        val minerals=manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
            println("Недостаточно мминералов для исследования")
            return
        }
        minerals.amount -=30
        println("Лаборатория проводит исследование (минералы -30)")
    }
}