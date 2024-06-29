import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class MainKtTest {

    @Test
    fun robotLocations1() {
        val args = convertLocationsToStringArray(0, 2)
        main(args)
        val meetingLocation = DirectLine.getMeetingLocation()
        assertEquals(6, meetingLocation)
    }

    @Test
    fun robotLocations2() {
        val args = convertLocationsToStringArray(2, 0)
        main(args)
        val meetingLocation = DirectLine.getMeetingLocation()
        assertEquals(6, meetingLocation)
    }

    @Test
    fun robotLocations3() {
        val args = convertLocationsToStringArray(0, 0)
        main(args)
        val meetingLocation = DirectLine.getMeetingLocation()
        assertEquals(0, meetingLocation)
    }

    @Test
    fun robotLocations4() {
        val args = convertLocationsToStringArray(5, 5)
        main(args)
        val meetingLocation = DirectLine.getMeetingLocation()
        assertEquals(5, meetingLocation)
    }

    @Test
    fun robotLocations5() {
        val args = convertLocationsToStringArray(3, 7)
        main(args)
        val meetingLocation = DirectLine.getMeetingLocation()
        assertEquals(15, meetingLocation)
    }

    @Test
    fun robotLocations6() {
        val args = convertLocationsToStringArray(0, 6)
        main(args)
        val meetingLocation = DirectLine.getMeetingLocation()
        assertEquals(18, meetingLocation)
    }

    private fun convertLocationsToStringArray(firstRobotLocation: Int, secondRobotLocation: Int): Array<String> {
        return arrayOf(firstRobotLocation.toString(), secondRobotLocation.toString())
    }

    @Test
    fun robotLocations7() {
        repeat(20) {
            main(emptyArray())
        }
    }
}