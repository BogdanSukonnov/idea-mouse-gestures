package service

import com.intellij.openapi.editor.event.EditorMouseEvent

class MouseGesturesService {

    private var isGestureStarted = false

    fun mouseDragged(event: EditorMouseEvent) {
        if (!isGestureStarted)
            return
        if (!isGestureButton(event))
            clearGesture()
//        RectanglePainter2D.FILL.paint()
    }

    fun mousePressed(event: EditorMouseEvent) {

        if (isGestureButton(event))
            startGesture(event)
    }

    fun mouseClicked(event: EditorMouseEvent) {}

    fun mouseReleased(event: EditorMouseEvent) {}

    fun mouseEntered(event: EditorMouseEvent) {}

    fun mouseExited(event: EditorMouseEvent) {}

    private fun clearGesture() {
        isGestureStarted = false;
        // TODO: clear gesture animation
    }

    private fun startGesture(event: EditorMouseEvent) {

        clearGesture()

        isGestureStarted = true
    }

    private fun isGestureButton(event: EditorMouseEvent): Boolean {
        return event.mouseEvent.button == 3
    }
}
