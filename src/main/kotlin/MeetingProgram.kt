
/*
* Describes program algorithm that guarantees the meeting of robots. It is launched separately for each robot.
* */
class MeetingProgram(private val robotName: RobotName) {

    // Indicates a clock of program during which each robot performs an action according to its program and following checks.
    fun doStep() {
        if (iterator.hasNext()) {
            iterator.next()
        }
    }

    /*
    * A robot starts moving to the right, taking one step along a discrete line each time. Every step he checks for a
    * parachute on the cell, where he is currently standing. Since he started moving from his parachute, then the only
    * parachute he can meet is the parachute of another robot.
    * If he has found the parachute, it means that another robot is in front of him and is moving one step at a time.
    * Now our task is to catch up him. To do this, each step of the program, first robot begins to take two steps
    * instead of one, thus catching up gone ahead second robot. As soon as first robot catches up second, the program
    * is over, because robots have met.
    * It is also possible that first robot won't meet a parachute at all if second robot landed to the left from first
    * one. In this case, first robot just moves forward step by step until second robot catches up him.
    * */
    private val iterator = sequence {
        println("$robotName: start meeting program")
        yield(0)

        // In case robots landed on the same cell.
        if (DirectLine.isRobotsMet()) return@sequence

        do {
            yield(0)
            DirectLine.notifyStepRight(robotName)
            yield(0)
        } while (!DirectLine.isParachuteFound(robotName) && !DirectLine.isRobotsMet())

        while (!DirectLine.isRobotsMet()) {
            yield(0)
            DirectLine.notifyStepRight(robotName)
            DirectLine.notifyStepRight(robotName)
            yield(0)
        }
    }.iterator()
}

