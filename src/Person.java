
import java.util.Calendar;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYOB(int YOB) {
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        }
    }

    // Returns first and last name
    public String fullName() {
        return firstName + " " + lastName;
    }

    // Returns title + full name
    public String formalName() {
        return title + " " + fullName();
    }

    // Returns age based on current year
    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    // Returns age for a specific year
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    // Converts Person to CSV
    public String toCSV() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    // Converts Person to JSON
    public String toJSON() {
        return "{\"ID\":\"" + ID +
                "\",\"firstName\":\"" + firstName +
                "\",\"lastName\":\"" + lastName +
                "\",\"title\":\"" + title +
                "\",\"YOB\":" + YOB + "}";
    }

    // Converts Person to XML
    public String toXML() {
        return "<Person>" +
                "<ID>" + ID + "</ID>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }

    @Override
    public String toString() {
        return formalName() + " (" + ID + ") - Born: " + YOB;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;

        return firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && ID.equals(other.ID)
                && title.equals(other.title)
                && YOB == other.YOB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }
}

