import org.junit.Test;
import static org.junit.Assert.*;

// Define the Person class
class Person {
    private final String firstName;
    private final String lastName;
    private final String ID;
    private final String title;
    private final int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }


    // Other methods...

    @Override
    public String toString() {
        return "ID: " + ID + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Title: " + title + "\n" +
                "Year of Birth: " + YOB + "\n";
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    public String toCSVDataRecord() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}

// Define the PersonTest class
public class PersonTest {
    @Test
    public void testFullName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("Jane", "Smith", "54321", "Mrs.", 1990);
        assertEquals("Mrs. Jane Smith", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("Alice", "Johnson", "98765", "Ms.", 1975);
        assertEquals("48", person.getAge(2023));
    }

    @Test
    public void testToCSVDataRecord() {
        Person person = new Person("Bob", "Brown", "67890", "Dr.", 1985);
        assertEquals("67890, Bob, Brown, Dr., 1985", person.toCSVDataRecord());
    }
}