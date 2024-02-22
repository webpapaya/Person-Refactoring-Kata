package sammancoaching

class Person(
    role: Int,
    swedishPersonalNumber: String,
    phoneNumber: String
) {
    private var role= 0
    var swedishPersonalNumber: PersonalNumber
        private set
    var phoneNumber: PhoneNumber

    init {
        this.role = Role.getByValue(role).id
        this.swedishPersonalNumber = PersonalNumber(swedishPersonalNumber)
        this.phoneNumber = PhoneNumber(phoneNumber)
    }


    fun birthYear(): Int = swedishPersonalNumber.birthYear()

    fun countryCode(): String = phoneNumber.countryCode()

    fun canDeleteUsers(): Boolean {
        return role == USER_ROLE_MANAGER || role == USER_ROLE_ADMIN
    }

    companion object {
        const val USER_ROLE_ADMIN = 0
        const val USER_ROLE_ENGINEER = 1
        const val USER_ROLE_MANAGER = 2
        const val USER_ROLE_SALES = 3
    }
}
