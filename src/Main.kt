import example.*
import modules.EnergyGeneretor
import modules.ModuleResult
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourseManager
import javax.management.modelmbean.ModelMBean
import kotlin.properties.Delegates

fun main() {
    val manager= resources.ResourseManager()
    val minerals= resources.OutpostResource(1, "Minerals", 300)
    val gas = resources.OutpostResource(2, "Gas", 100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()

    val bonus =minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")
    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGeneretor()
    val lab= ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()

    val max = InstantMessenger("MAX")
    val photoCamera=PhotoCamera()
    val yotaPhone=SmartPhone("YotaPhone", max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()

    counter=1
    counter=5

    fun handModuleResult(result: ModuleResult){
        when(result){
            is ModuleResult.Success -> println("УСПЕХ: ${result.message}")
            is ModuleResult.ResourceProduced -> println("Произведено: ${result.reasourceName} +${result.amount}")
            is ModuleResult.NotEnoughResources -> println("Недостаточно ресурса ${result.resourceName}." + "Нужно: ${result.required}, есть: ${result.available}")
            is ModuleResult.Error -> println("ОШИБКА: ${result.reason}")

        }
    }
    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handModuleResult(generatorResult)
    handModuleResult(labResult)
    println()
    manager.printAll()
}