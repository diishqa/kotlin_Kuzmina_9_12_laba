package modules

import com.sun.net.httpserver.Request
import javax.annotation.processing.Messager

sealed class ModuleResult {
    data class Success(val message: String ) : ModuleResult()
    data class ResourceProduced(
        val reasourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}