import processing.core._
import spde.core._
import PConstants._
import PApplet._
object `graftRunner` {
  def main(args: Array[String]) { PApplet.main(Array(classOf[`graft`].getName)) }
}
class `graft` extends ProxiedApplet {
  lazy val px = new DrawProxy(this) {
size(600, 600) // Sketch.spde: 1
frameRate(1) // Sketch.spde: 2
val items = { 0 to width }.view.map { (_, random(255).toInt) } // Sketch.spde: 3
val currentPoint = Point(0, 500) // Sketch.spde: 4
val width = 500 // Sketch.spde: 5
var triangleCounter = 0 // Sketch.spde: 6
 // Sketch.spde: 7
def draw { // Sketch.spde: 8
    // drawTriangle(Point(0,500),Point(500,500), Point(250, (500.0-scala.math.sqrt(3)/2*500).toInt) ) // Sketch.spde: 9
    drawTriangle(currentPoint, width, triangleCounter) // Sketch.spde: 10
    triangleCounter+=1 // Sketch.spde: 11
} // Sketch.spde: 12
   // Sketch.spde: 13
case class Point ( val x: Int, val y: Int )  // Sketch.spde: 14
 // Sketch.spde: 15
def drawTriangle(point: Point, width: Int, level: Int) { // Sketch.spde: 16
    level match { // Sketch.spde: 17
        case 0 => drawTriangle(point, width) // Sketch.spde: 18
        case _ => {  // Sketch.spde: 19
            drawTriangle(point, width/2, level-1) // Sketch.spde: 20
            drawTriangle(Point(point.x + width/2, point.y), width/2, level-1) // Sketch.spde: 21
            drawTriangle(Point(point.x + width/4, (point.y - scala.math.sqrt(3)/4*width).toInt), width/2, level - 1) // Sketch.spde: 22
        } // Sketch.spde: 23
    } // Sketch.spde: 24
} // Sketch.spde: 25
 // Sketch.spde: 26
def drawTriangle(point: Point, width: Int) { // Sketch.spde: 27
    val point2 = Point(point.x + width, point.y) // Sketch.spde: 28
    val point3 = Point(point.x + width/2, (point.y - scala.math.sqrt(3)/2*width).toInt) // Sketch.spde: 29
    drawTriangle(point, point2, point3); // Sketch.spde: 30
} // Sketch.spde: 31
 // Sketch.spde: 32
def drawTriangle ( point1: Point, point2: Point, point3: Point ) { // Sketch.spde: 33
    lineBetween(point1, point2) // Sketch.spde: 34
    lineBetween(point2, point3) // Sketch.spde: 35
    lineBetween(point3, point1) // Sketch.spde: 36
}  // Sketch.spde: 37
 // Sketch.spde: 38
def lineBetween ( pointA: Point, pointB: Point) = line(pointA.x, pointA.y, pointB.x, pointB.y) // Sketch.spde: 39

  }
}