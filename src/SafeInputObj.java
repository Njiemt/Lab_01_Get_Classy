
import java.util.Scanner;

public class SafeInputObj {

    // Scanner used by all methods
    private Scanner pipe;

    /**
     * Default constructor.
     * Uses System.in for keyboard input.
     */
    public SafeInputObj() {
        pipe = new Scanner(System.in);
    }

    /**
     * Constructor that uses a Scanner provided by the user.
     *
     * @param scanner Scanner to use for input
     */
    public SafeInputObj(Scanner scanner) {
        pipe = scanner;
    }

    /**
     * Gets a String containing at least one character.
     *
     * @param prompt Prompt for the user
     * @return A String that is not empty
     */
    public String getNonZeroLenString(String prompt) {

        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

        } while (retString.length() == 0);

        return retString;
    }

    /**
     * Gets an int value within a specified range.
     *
     * @param prompt Input prompt
     * @param low Lowest acceptable value
     * @param high Highest acceptable value
     * @return An int within the specified range
     */
    public int getRangedInt(String prompt, int low, int high) {

        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {

            System.out.print(
                    "\n" + prompt + "[" + low + "-" + high + "]: "
            );

            if (pipe.hasNextInt()) {

                retVal = pipe.nextInt();
                pipe.nextLine();

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println(
                            "\nNumber is out of range [" +
                                    low + "-" + high + "]: " + retVal
                    );
                }

            } else {

                trash = pipe.nextLine();

                System.out.println(
                        "You must enter an int: " + trash
                );
            }

        } while (!done);

        return retVal;
    }

    /**
     * Gets an int value with no restrictions.
     *
     * @param prompt Input prompt
     * @return An int value
     */
    public int getInt(String prompt) {

        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {

            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) {

                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;

            } else {

                trash = pipe.nextLine();

                System.out.println(
                        "You must enter an int: " + trash
                );
            }

        } while (!done);

        return retVal;
    }

    /**
     * Gets a double value within a specified range.
     *
     * @param prompt Input prompt
     * @param low Lowest acceptable value
     * @param high Highest acceptable value
     * @return A double within the specified range
     */
    public double getRangedDouble(
            String prompt,
            int low,
            int high) {

        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {

            System.out.print(
                    "\n" + prompt + "[" + low + "-" + high + "]: "
            );

            if (pipe.hasNextDouble()) {

                retVal = pipe.nextDouble();
                pipe.nextLine();

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println(
                            "\nNumber is out of range [" +
                                    low + "-" + high + "]: " + retVal
                    );
                }

            } else {

                trash = pipe.nextLine();

                System.out.println(
                        "You must enter a double: " + trash
                );
            }

        } while (!done);

        return retVal;
    }

    /**
     * Gets a double value with no restrictions.
     *
     * @param prompt Input prompt
     * @return A double value
     */
    public double getDouble(String prompt) {

        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {

            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble()) {

                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;

            } else {

                trash = pipe.nextLine();

                System.out.println(
                        "You must enter a double: " + trash
                );
            }

        } while (!done);

        return retVal;
    }

    /**
     * Gets a Yes or No confirmation from the user.
     *
     * @param prompt Prompt for the user
     * @return true for Yes and false for No
     */
    public boolean getYNConfirm(String prompt) {

        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {

            System.out.print(
                    "\n" + prompt + " [Y/N] "
            );

            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {

                gotAVal = true;
                retVal = true;

            } else if (response.equalsIgnoreCase("N")) {

                gotAVal = true;
                retVal = false;

            } else {

                System.out.println(
                        "You must answer [Y/N]! " + response
                );
            }

        } while (!gotAVal);

        return retVal;
    }

    /**
     * Gets a String that matches a regular expression pattern.
     *
     * @param prompt Prompt for the user
     * @param regExPattern Regular expression pattern
     * @return A String matching the pattern
     */
    public String getRegExString(
            String prompt,
            String regExPattern) {

        String response = "";
        boolean gotAVal = false;

        do {

            System.out.print("\n" + prompt + ": ");

            response = pipe.nextLine();

            if (response.matches(regExPattern)) {

                gotAVal = true;

            } else {

                System.out.println(
                        "\n" + response +
                                " must match the pattern " +
                                regExPattern
                );

                System.out.println("Try again!");
            }

        } while (!gotAVal);

        return response;
    }
}

