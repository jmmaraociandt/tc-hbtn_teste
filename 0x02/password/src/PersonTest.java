import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("deprecation")
class PersonTest {
    private static Person person;

    @BeforeAll
    public static void setup() {
        Date birthDate = new Date(2000, Calendar.JANUARY, 1);
        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    void person_is_MEI() {
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        assertTrue(person.isMEI());
    }

    @Test
    void person_is_not_MEI() {
        person.setAnotherCompanyOwner(true);
        assertFalse(person.isMEI());
    }
}