import java.lang.Math.*
import java.util.*

fun solveQuadraticEquation (equation: Equation, eps: Double = 1e-5): Vector<Double> {

    if (abs(equation.getA()) < eps)
    {
        throw IllegalArgumentException("A should not be a zero")
    }

    var d: Double = equation.getB()*equation.getB() - 4 * equation.getA()*equation.getC();

    if (d >= eps*eps)
    {
        d = sqrt(d);
        val roots: Vector<Double> = Vector(2)
        roots.add(-equation.getB() + d / 2 * equation.getA())
        roots.add(-equation.getB() - d / 2 * equation.getA());
        return roots;
    }
    else
    {
        if (abs(d) < eps*eps)
        {
            val roots: Vector<Double> = Vector(1)
            roots.add (-equation.getB() / 2 * equation.getA());
            return roots;
        }
        else
        {
            return Vector()
        }
    }
}