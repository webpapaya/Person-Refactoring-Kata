package sammancoaching

class PhoneNumber(private val number: String) {
    fun countryCode(): String {
        var code = ""
        if (number.startsWith("00")) {
            code = number.substring(2, 4)
        }
        else if (number.startsWith("+")) {
            code = number.substring(1, 3)
        }

        if (code.isNotEmpty()) return  "+$code"
        return ""
    }
}