package Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        person = new Person(
                "John",
                "Smith",
                "123456",
                "Mr.",
                2000
        );
    }

    @Test
    void testConstructor() {
        assertEquals("John", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals("123456", person.getID());
        assertEquals("Mr.", person.getTitle());
        assertEquals(2000, person.getYOB());
    }

    @Test
    void testSetFirstName() {
        person.setFirstName("James");
        assertEquals("James", person.getFirstName());
    }

    @Test
    void testSetLastName() {
        person.setLastName("Jones");
        assertEquals("Jones", person.getLastName());
    }

    @Test
    void testSetTitle() {
        person.setTitle("Dr.");
        assertEquals("Dr.", person.getTitle());
    }

    @Test
    void testSetYOB() {
        person.setYOB(1995);
        assertEquals(1995, person.getYOB());
    }

    @Test
    void testFullName() {
        assertEquals("John Smith", person.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. John Smith", person.formalName());
    }

    @Test
    void testGetAge() {
        assertEquals(
                String.valueOf(java.util.Calendar.getInstance()
                        .get(java.util.Calendar.YEAR) - 2000),
                person.getAge()
        );
    }

    @Test
    void testGetAgeWithYear() {
        assertEquals("25", person.getAge(2025));
    }

    @Test
    void testToCSV() {
        assertEquals(
                "123456,John,Smith,Mr.,2000",
                person.toCSV()
        );
    }

    @Test
    void testToJSON() {
        assertEquals(
                "{\"ID\":\"123456\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"title\":\"Mr.\",\"YOB\":2000}",
                person.toJSON()
        );
    }

    @Test
    void testToXML() {
        assertEquals(
                "<Person><ID>123456</ID><firstName>John</firstName><lastName>Smith</lastName><title>Mr.</title><YOB>2000</YOB></Person>",
                person.toXML()
        );
    }

    @Test
    void testToString() {
        assertEquals(
                "Mr. John Smith (123456) - Born: 2000",
                person.toString()
        );
    }

    @Test
    void testEquals() {
        Person person2 = new Person(
                "John",
                "Smith",
                "123456",
                "Mr.",
                2000
        );

        assertEquals(person, person2);
    }
}

