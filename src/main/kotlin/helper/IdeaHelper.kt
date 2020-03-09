package helper

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.WindowManager
import javax.swing.JFrame

object IdeaHelper {
    val currentJFrame: JFrame?
        get() = currentProject?.let { WindowManager.getInstance().getFrame(it) }

    val currentStatusBar: StatusBar?
        get() = currentProject?.let { WindowManager.getInstance().getStatusBar(it) }

    private val currentProject: Project?
        get() {
            val projects = ProjectManager.getInstance().openProjects
            if (projects.isEmpty()) return null
            if (projects.size == 1) return projects[0]
            for (project in projects) {
                val frame = WindowManager.getInstance().getFrame(project)
                if (frame != null && frame.isActive) return project
            }
            return projects[0]
        }
}
