package modules

import resources.OutpostResource
import resources.ResourseManager
import javax.management.modelmbean.ModelMBean

class EnergyGeneretor : OutpostModule("Генератор энергии") {
    override fun performAction(manager: ResourseManager) : ModuleResult {
        println("Генератор работает... Проихводит 20 энергии")
        val energy = manager.get("Energy")
        return if (energy !=null) {
            energy.amount+=20
            ModuleResult.ResourceProduced("Energy", 20)
        } else{
            manager.add(OutpostResource(99, "Energy", 20))
            ModuleResult.Success("Энергия создана впервые")
        }
    }
}