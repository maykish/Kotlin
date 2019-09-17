package myapp
import com.anysolo.toyGraphics.*

fun main() {
    val wnd = Window(800, 600)
    val gc = Graphics(wnd)

    gc.drawRect(200, 200, 100, 50)
}
