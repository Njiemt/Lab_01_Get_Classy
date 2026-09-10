import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PersonReader {

    public static void main(String[] args) {

        File file = null;

        if (args.length > 0) {
            file = new File(args[0]);
        } else {

            JFileChooser choose = new JFileChooser(
                    "C:/Users/moham/IdeaProjects/Lab_01_Get_Classy"
            );

            int result = choose.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                file = choose.getSelectedFile();
            }
        }

        // Create ArrayList to hold Person objects
        ArrayList<Person> people = new ArrayList<Person>();

        if (file != null) {

            try (BufferedReader reader =
                         new BufferedReader(new FileReader(file))) {

                String line;

                while ((line = reader.readLine()) != null) {

                    // Split CSV record
                    String[] data = line.split(",");

                    // Create a Person object
                    Person person = new Person(
                            data[1],              // firstName
                            data[2],              // lastName
                            data[0],              // ID
                            data[3],              // title
                            Integer.parseInt(data[4]) // YOB
                    );

                    // Add Person object to ArrayList
                    people.add(person);
                }

                // Display the Person objects
                System.out.println(String.format(
                        "%-10s %-15s %-15s %-10s %s",
                        "ID#", "Firstname", "Lastname", "Title", "YOB"
                ));

                System.out.println(
                        "===================================================="
                );

                for (Person person : people) {

                    System.out.println(String.format(
                            "%-10s %-15s %-15s %-10s %s",
                            person.getID(),
                            person.getFirstName(),
                            person.getLastName(),
                            person.getTitle(),
                            person.getYOB()
                    ));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
