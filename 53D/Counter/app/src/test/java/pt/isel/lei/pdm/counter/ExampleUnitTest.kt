package pt.isel.lei.pdm.counter

import org.junit.Test

import org.junit.Assert.*
import pt.isel.lei.pdm.counter.domain.CounterInfo
import pt.isel.lei.pdm.counter.domain.CrowdTallyInfo
import pt.isel.lei.pdm.counter.domain.changeMax
import pt.isel.lei.pdm.counter.domain.decrement
import pt.isel.lei.pdm.counter.domain.increment

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `Counter does increment by 1`() {
        //  arrange
        val value = CounterInfo(123)
        //  act
        val incrementedCounter = value.increment()
        //  assert
        assertEquals(incrementedCounter.counter, value.counter + 1)
    }

    @Test
    fun `CrowdTallyInfo does not support negative people`() {
        //  arrange
        val value = CrowdTallyInfo(0, 10)
        //  act
        val decrementedCounter = value.decrement()
        //  assert
        assertEquals(0, decrementedCounter.counter)
    }

    @Test
    fun `CrowdTallyInfo max counter is fulfilled`() {
        //  arrange
        val value = CrowdTallyInfo(0, 1)
        //  act
        var c = value.increment() //1
        c = c.increment()

        //  assert
        assertEquals(1, c.counter)
    }

    @Test
    fun `CrowdTallyInfo max counter cannot be changed to negative`() {
        //  arrange
        val value = CrowdTallyInfo(0, 10)

        //act
        try {
            val maxValueChanged = value.changeMax(-1)
        } catch (e: Exception) {
            return
        }
        fail()
        //  assert

    }

    @Test
    fun `CrowdTallyInfo max counter cannot be negative`() {

        try {
            val value = CrowdTallyInfo(0, -10)

        } catch (e: Exception) {
            return
        }
        fail()
        //  assert
    }

    @Test
    fun `CrowdTallyInfo max counter should reflect on counter if less than current counter`() {

        //arrange
        val c = CrowdTallyInfo(10, 10)
        //act

        val x = c.changeMax(5)
        //assert

        assertEquals(5, x.counter)
    }
}