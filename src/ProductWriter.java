
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<Product>();

        Scanner input = new Scanner(System.in);

        boolean done = false;

        do {

            String name;
            String description;
            String ID;
            double cost;

            name = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Product Name"
            );

            description = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Product Description"
            );

            ID = SafeInput.getNonZeroLenString(
                    input,
                    "Enter Product ID"
            );

            cost = SafeInput.getDouble(
                    input,
                    "Enter Product Cost"

            );

            Product product = new Product(
                    name,
                    description,
                    ID,
                    cost
            );

            products.add(product);

            System.out.println("Product added: " + product);

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

            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }
}

