package listener

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.editor.event.EditorMouseEvent
import com.intellij.openapi.editor.event.EditorMouseListener
import service.MouseGesturesService

class ImgMouseListenerJava : EditorMouseListener {

    private var mouseGesturesService =
        ServiceManager.getService(
            MouseGesturesService::class.java
        )

    override fun mousePressed(event: EditorMouseEvent) {
        mouseGesturesService.mousePressed(event)
    }

    override fun mouseClicked(event: EditorMouseEvent) {
        mouseGesturesService.mouseClicked(event)
    }

    override fun mouseReleased(event: EditorMouseEvent) {
        mouseGesturesService.mouseReleased(event)
    }

    override fun mouseEntered(event: EditorMouseEvent) {
        mouseGesturesService.mouseEntered(event)
    }

    override fun mouseExited(event: EditorMouseEvent) {
        mouseGesturesService.mouseExited(event)
    }
}
