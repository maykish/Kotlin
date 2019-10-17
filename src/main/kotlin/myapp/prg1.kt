package myapp
import com.anysolo.toyGraphics.*


fun main() {
    val wnd = Window(800, 600)
    val turtle = Turtle(wnd)

    var step = 10

    repeat(50) {
        turtle.forward(step)
        turtle.turnRight(90.0)

        step += 10
    }
}
