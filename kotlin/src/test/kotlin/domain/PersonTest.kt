package domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {
    private val swedishPersonalNumber = "19511111-7668"
    private val role = Person.Role.MANAGER
    private val phoneNumber = "00467123456"

    @Test
    fun birthYear() {
        val person = Person.createFromSwedishPersonalNumber(role, swedishPersonalNumber, phoneNumber)
        assertEquals(1951, person.birthYear())
    }

    @Test
    fun countryCode() {
        val person = Person.createFromSwedishPersonalNumber(role, swedishPersonalNumber, phoneNumber)
        assertEquals("+46", person.countryCode())
    }

    @Test
    fun managersCanDeleteUsers() {
        val person = Person.createFromSwedishPersonalNumber(role, swedishPersonalNumber, phoneNumber)
        assertTrue(person.canDeleteUsers())
    }

    @Test
    fun adminCanDeleteUsers() {
        val person = Person.createFromSwedishPersonalNumber(Person.Role.ADMIN, swedishPersonalNumber, phoneNumber)
        assertTrue(person.canDeleteUsers())
    }

    @Test
    fun salesCantDeleteUsers() {
        val person = Person.createFromSwedishPersonalNumber(Person.Role.SALES, swedishPersonalNumber, phoneNumber)
        assertFalse(person.canDeleteUsers())
    }

    @Test
    fun engineersCantDeleteUsers() {
        val person = Person.createFromSwedishPersonalNumber(Person.Role.ENGINEER, swedishPersonalNumber, phoneNumber)
        assertFalse(person.canDeleteUsers())
    }

    @Test
    fun standardizePhoneNumber() {
        val person = Person.createFromSwedishPersonalNumber(role, swedishPersonalNumber, "+46123456")
        assertEquals("+46", person.countryCode())
    }

    @Test
    fun standardizeLocalPhoneNumber() {
        val person = Person.createFromSwedishPersonalNumber(role, swedishPersonalNumber, "0123456")
        assertEquals("", person.countryCode())
    }
}
