enum class RobotName {
    FIRST,
    SECOND
    ;

    companion object {
        private var isFirst = false
        fun getNameByTurns(): RobotName {
            isFirst = !isFirst
            return if (isFirst) {
                FIRST
            } else SECOND
        }
    }
}