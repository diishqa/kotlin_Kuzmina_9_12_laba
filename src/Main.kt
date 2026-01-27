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

    println("------------------------------------------------------")
    println("Создаем профиль пользователя...")
    val user=UserProfile("Алиса", "alice@example.com")
    println("\nИмя: ${user.name}")
    println("Email: ${user.email}")
    println("\nОбращаемся к аватару впервые:")
    println("Файл аватара: ${user.avatar}")
    println("\nОбращаемся к аватару снова (должын быть взят из кэша):")
    println("Файл аватара: ${user.avatar}")
    println("\nМеняем email:")
    user.email="elice_new@example.org"
    println("\nМеняем имя:")
    user.name="Алиса К."
    println("------------------------------------------------------")

    println("Создаем героя...")
    val hero = GameHero("Воин света")
    println("\nТекущая мана: ${hero.mana}")
    println("\nГерой пытается использовать способоность:")
    println("Способность: ${hero.ultimate}")
    println("\nПовторный вызов способности (должна быть мгновенной):")
    println("Способность: ${hero.ultimate}")
    println("\nМеняем имя героя:")
    hero.name="Темный принц"
    println("\nГерой восстанавливает ману:")
    hero.mana=200






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