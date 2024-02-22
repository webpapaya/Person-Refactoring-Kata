package sammancoaching

class PersonalNumber(number: String) {
    private var swedishPersonalNumber: String = ""
        private set(value) {field = normalizePersonalNumber(value)}

    init {
        swedishPersonalNumber = number
    }

    private fun normalizePersonalNumber(value: String) : String {
        var personalNumber = value
        personalNumber = personalNumber.replace("-", "")
        require(personalNumber.length == 12) { "invalid personal number $personalNumber" }
        return personalNumber
    }

    fun birthYear(): Int {
        val year = swedishPersonalNumber.substring(0, 4)
        return year.toInt()
    }
}