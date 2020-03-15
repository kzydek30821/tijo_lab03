fun main(args: Array<String>){
    val POINTS = 2
    val points : Array<Point2D?> = arrayOfNulls<Point2D>(POINTS)
    val materialPoints: Array<MaterialPoint2D?> = arrayOfNulls<MaterialPoint2D>(POINTS)

    points[0] = Point2D(0.0, 0.0)
    points[1] = Point2D(10.0, 10.0)

    materialPoints[0] = MaterialPoint2D(0.0, 0.0, 10.0)
    materialPoints[1] = MaterialPoint2D(10.0, 10.0, 100.0)

    val geometricCenter: Point2D = Calculactions.positionGeometricCenter(points)
    val massCenter: Point2D = Calculactions.positionCenterOfMass(materialPoints)

    println("Kotlin!")
    println("Połozenie środka masy: $massCenter")
    println("Położenie środka geometrycznego: $geometricCenter")
}
fun main(args: Array<String>){
    val POINTS = 2
    val points : Array<Point2D?> = arrayOfNulls<Point2D>(POINTS)
    val materialPoints: Array<MaterialPoint2D?> = arrayOfNulls<MaterialPoint2D>(POINTS)

    points[0] = Point2D(0.0, 0.0)
    points[1] = Point2D(10.0, 10.0)

    materialPoints[0] = MaterialPoint2D(0.0, 0.0, 10.0)
    materialPoints[1] = MaterialPoint2D(10.0, 10.0, 100.0)

    val geometricCenter: Point2D = Calculactions.positionGeometricCenter(points)
    val massCenter: Point2D = Calculactions.positionCenterOfMass(materialPoints)

    println("Kotlin!")
    println("Połozenie środka masy: $massCenter")
    println("Położenie środka geometrycznego: $geometricCenter")
}

open class Point2D(val x: Double, val y: Double){

    override fun toString(): String {
        return ("x = " + x + ", "
                + "y = " + y)
    }

}

class MaterialPoint2D(x: Double, y: Double, var mass: Double): Point2D(x,y){

    override fun toString(): String {
        return ("x = " + x + ", "
                + "y = " + y + ", "
                + "mass = " + mass)
    }

}

class Calculactions {
    companion object {
        @JvmStatic
        fun positionGeometricCenter(points: Array<Point2D?>): Point2D {
            var x = 0.0;
            var y = 0.0;
            points.forEach {
                x += it!!.x;
                y += it.y
            }
            return Point2D(x / points.size, y / points.size)
        }

        @JvmStatic
        fun positionCenterOfMass(materialPoints: Array<MaterialPoint2D?>): Point2D{
            var x = 0.0
            var y = 0.0
            var mass = 0.0

            materialPoints.forEach {
                x += it!!.mass * it.x
                y += it.mass * it.y
                mass += it.mass
            }

            return MaterialPoint2D(x/mass, y/mass, mass)
        }
    }


}