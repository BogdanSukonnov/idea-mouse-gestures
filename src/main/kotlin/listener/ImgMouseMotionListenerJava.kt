package listener

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.editor.event.EditorMouseEvent
import com.intellij.openapi.editor.event.EditorMouseMotionListener
import service.MouseGesturesService

class ImgMouseMotionListenerJava : EditorMouseMotionListener {

    private var mouseGesturesService =
        ServiceManager.getService(
            MouseGesturesService::class.java
        )

    override fun mouseDragged(event: EditorMouseEvent) {
        mouseGesturesService.mouseDragged(event)
    }
}
