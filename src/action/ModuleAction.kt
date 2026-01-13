package action

import resources.ResourseManager

interface ModuleAction {
    fun execute(manager: ResourseManager)
}