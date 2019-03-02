import java.lang.IllegalArgumentException
import com.nhaarman.mockito_kotlin.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal open class QuadraticEquationKtTest{

    @Test
    fun AShouldNotBeZero () {
        val mockEquation: Equation = mock {
            on { getA() } doReturn(1e-15)
            on { getB() } doReturn(1.0)
            on { getC() } doReturn(2.0)
        }
        assertThrows(IllegalArgumentException::class.java, {solveQuadraticEquation(mockEquation)} )
    }
    @Test
    fun EquationHasNoRoots () {
        val mockEquation: Equation = mock {
            on { getA() } doReturn(1.0)
            on { getB() } doReturn(0.0)
            on { getC() } doReturn(3.0)
        }
        assertEquals(0, solveQuadraticEquation(mockEquation).size )
    }
    @Test
    fun EquationHasOneRoot () {
        val mockEquation: Equation = mock {
            on { getA() } doReturn(1.0)
            on { getB() } doReturn(4.0)
            on { getC() } doReturn(4.0)
        }
        assertEquals(1, solveQuadraticEquation(mockEquation).size )
    }
    @Test
    fun EquationHasTwoRoots () {
        val mockEquation: Equation = mock {
            on { getA() } doReturn(1.0)
            on { getB() } doReturn(0.0)
            on { getC() } doReturn(-4.0)
        }
        assertEquals(2, solveQuadraticEquation(mockEquation).size )
    }
}