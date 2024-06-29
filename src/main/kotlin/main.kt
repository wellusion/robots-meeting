import kotlinx.coroutines.*
import kotlin.random.Random

fun main(args: Array<String>) {
    val (firstRobotLocation, secondRobotLocation) = createRobotLocations(args)
    val firstRobot = Robot(firstRobotLocation)
    val secondRobot = Robot(secondRobotLocation)

    val firstRobotProgram = firstRobot.meetingProgram
    val secondRobotProgram = secondRobot.meetingProgram

    var counter = 0
    runBlocking {
        do {
            firstRobotProgram.doStep()
            secondRobotProgram.doStep()
            counter++
        } while (!DirectLine.isRobotsMet() && counter < 100)
    }
    if (counter >= 100) {
        println("Error: Cycle")
    } else {
        println("Robots met on ${DirectLine.getMeetingLocation()}")
    }
}

fun createRobotLocations(args: Array<String>): Pair<Int, Int> {
    if (args.isEmpty()) {
        return Random.nextInt(10) to Random.nextInt(10)
    }

    if (args.size == 2) {
        val firstRobotLocation = args[0].toIntOrNull()
        val secondRobotLocation = args[1].toIntOrNull()
        if (firstRobotLocation != null && secondRobotLocation != null) {
            return firstRobotLocation to secondRobotLocation
        }
    }

    throw Exception("Input data are not valid")
}

