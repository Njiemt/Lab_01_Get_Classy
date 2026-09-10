
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class ProductReader {

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

        ArrayList<Product> products = new ArrayList<Product>();

        if (file != null) {

            try (BufferedReader reader =
                         new BufferedReader(
                                 new FileReader(file)
                         )) {

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] data = line.split(",");

                    Product product = new Product(
                            data[0],
                            data[1],
                            data[2],
                            Double.parseDouble(data[3])
                    );

                    products.add(product);
                }

                System.out.println(String.format(
                        "%-20s %-25s %-15s %s",
                        "Name",
                        "Description",
                        "ID",
                        "Cost"
                ));

                System.out.println(
                        "================================================================"
                );

                for (Product product : products) {

                    System.out.println(String.format(
                            "%-20s %-25s %-15s $%.2f",
                            product.getName(),
                            product.getDescription(),
                            product.getID(),
                            product.getCost()
                    ));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
