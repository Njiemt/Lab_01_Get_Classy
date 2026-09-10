public class ObjInputTest {

    public static void main(String[] args) {

        SafeInputObj input = new SafeInputObj();

        System.out.println("Testing SafeInputObj");

        String name = input.getNonZeroLenString(
                "Enter your name"
        );
        System.out.println("Name: " + name);

        int age = input.getInt(
                "Enter your age"
        );
        System.out.println("Age: " + age);

        int number = input.getRangedInt(
                "Enter a number from 1 to 100",
                1,
                100
        );
        System.out.println("Number: " + number);

        double decimal = input.getDouble(
                "Enter a decimal number"
        );
        System.out.println("Decimal: " + decimal);

        double price = input.getRangedDouble(
                "Enter a price from 1 to 1000",
                1,
                1000
        );
        System.out.println("Price: " + price);

        String code = input.getRegExString(
                "Enter a 5-digit code",
                "\\d{5}"
        );
        System.out.println("Code: " + code);

        boolean answer = input.getYNConfirm(
                "Do you like Java?"
        );
        System.out.println("Answer: " + answer);

        System.out.println("\nAll SafeInputObj methods were tested.");
    }
}

