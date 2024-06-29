
/*
* The class describing certain robot. The robot has no memory, so the class doesn't store the state. However, the
* robot has a meeting program that he launches at a landing.
* */
class Robot(location: Int) {
    val meetingProgram: MeetingProgram

    init {
        val name = RobotName.getNameByTurns()
        meetingProgram = MeetingProgram(name)
        DirectLine.notifyParachuteLocation(name, location)
        println("$name landed on $location")
    }
}