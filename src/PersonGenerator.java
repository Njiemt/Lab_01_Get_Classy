
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<Person>();

        Scanner input = new Scanner(System.in);
        boolean done = false;

        do {

            String ID;
            String fName;
            String lName;
            String title;
            int birthYear;

            ID = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Their Six Digit ID Number"
            );

            fName = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Their First Name"
            );

            lName = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Their Last Name"
            );

            title = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Their Title"
            );

            birthYear = SafeInput.getRangedInt(
                    input,
                    "Enter Their Birth Year",
                    1940,
                    2010
            );

            // Create Person object
            Person person = new Person(
                    fName,
                    lName,
                    ID,
                    title,
                    birthYear
            );

            // Add Person object to ArrayList
            people.add(person);

            System.out.println("Person added: " + person);

            if (SafeInput.getYNConfirm(
                    input,
                    "Are you sure you want to quit"
            )) {
                done = true;
            }

        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(
                input,
                "Enter file name (without .csv)"
        );

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(fileName + ".csv")
                     )) {

            // Write each Person object to the CSV file
            for (Person person : people) {
                writer.write(person.toCSV());
                writer.newLine();
            }

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }
}

