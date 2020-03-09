package service

import com.intellij.openapi.editor.event.EditorMouseEvent
import com.intellij.ui.paint.LinePainter2D
import configuration.ImsConfiguration
import helper.IdeaHelper
import java.awt.Graphics2D

class MouseGesturesService {

    private var isGestureStarted = false
    private var previousX = 0
    private var previousY = 0

    fun mouseDragged(event: EditorMouseEvent) {
        if (!isGestureStarted)
            return
        IdeaHelper.currentJFrame?.let {
            val graphics = it.graphics as Graphics2D

            graphics.color = ImsConfiguration.trailColor

            // TODO: set to false when end drawing
            it.ignoreRepaint = true

            val x = event.mouseEvent.x + it.locationOnScreen.x
            val y = event.mouseEvent.y + it.locationOnScreen.y
            if (previousX != 0 || previousY != 0)
                LinePainter2D.paint(
                    graphics, previousX.toDouble(), previousY.toDouble(),
                    x.toDouble(), y.toDouble(), LinePainter2D.StrokeType.INSIDE, ImsConfiguration.trailWidth
                )
            previousX = x
            previousY = y
        }
    }

    fun mousePressed(event: EditorMouseEvent) {

        if (isGestureButton(event))
            startGesture(event)
        else
            clearGesture()
    }

    fun mouseClicked(event: EditorMouseEvent) {}

    fun mouseReleased(event: EditorMouseEvent) {}

    fun mouseEntered(event: EditorMouseEvent) {}

    fun mouseExited(event: EditorMouseEvent) {}

    private fun clearGesture() {
        isGestureStarted = false;
        previousX = 0
        previousY = 0
        // TODO: clear gesture animation
    }

    private fun startGesture(event: EditorMouseEvent) {

        clearGesture()

        isGestureStarted = true
    }

    private fun isGestureButton(event: EditorMouseEvent): Boolean {
        return event.mouseEvent.button == 2
    }
}
