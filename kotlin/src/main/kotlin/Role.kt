package sammancoaching

enum class Role(val id: Int) {
    USER_ROLE_ADMIN(0),
    USER_ROLE_ENGINEER ( 1),
    USER_ROLE_MANAGER (2),
    USER_ROLE_SALES ( 3),
;
    companion object {
        fun getByValue(value: Int): Role = Role.values().firstOrNull { it.id == value } ?: throw IllegalArgumentException("illegal role $value")
    }
}
