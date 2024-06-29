import java.lang.Exception

/*
* The class describing a discrete infinite line. Moving along it the robots will look for each other, acting according
* to the program. This line is aware of position of robots and their parachutes at any moment in time.
* */
object DirectLine {

    // Direct line on which the robots were dropped knows the locations of the robots and their parachutes.
    private var parachuteLocations = hashMapOf<RobotName, Int>()
    private var robotLocations = hashMapOf<RobotName, Int>()

    // Direct line knows where the parachutes of robots are located. Therefore, after landing, robots "notifies" about coordinates of their parachutes.
    fun notifyParachuteLocation(name: RobotName, location: Int) {
        parachuteLocations[name] = location
        robotLocations[name] = location
    }

    // Each step robots "notify" the direct line about their movement. The line, accordingly, always knows where
    // particular robot is currently located.
    fun notifyStepRight(name: RobotName) {
        robotLocations.computeIfPresent(name) { _, value -> value + 1 }
        println("${name}: step to the right by ${robotLocations[name]}")
    }

    // Since direct line is aware of locations of parachutes, each robot can check at any time whether the parachute
    // is located at a given coordinate point.
    fun isParachuteFound(name: RobotName): Boolean {
        val location = robotLocations[name]
        val isParachuteFound = parachuteLocations.containsValue(location)
        if (isParachuteFound) {
            println("$name: found parachute by $location")
        }
        return isParachuteFound
    }

    // Since direct line is aware of locations of robots, each robot can check at any time whether another robot is
    // located at a given coordinate point.
    fun isRobotsMet(): Boolean {
        return robotLocations[RobotName.FIRST] == robotLocations[RobotName.SECOND]
    }

    fun getMeetingLocation(): Int {
        return if (isRobotsMet()) {
            robotLocations[RobotName.FIRST]!!
        } else {
            throw Exception("Meeting location not defined")
        }
    }
}