package numbers;

import java.util.Scanner;

class AmazingNumbers extends PropertyPrinter {
    Scanner scanner = new Scanner(System.in);
    public final static String INSTRUCTIONS = """
            \nSupported requests:
              - enter a natural number to know its properties;
              - enter two natural numbers to obtain the properties of the list:
                * the first parameter represents a starting number;
                * the second parameter shows how many consecutive numbers are to be printed;
              - two natural numbers and properties to search for;
              - a property preceded by minus must not be present in numbers;
              - separate the parameters with one space;
              - enter 0 to exit.""";
    public final static String ERROR1 = "\nThe first parameter should be a natural number or zero.";
    public final static String ERROR2 = "\nThe second parameter should be a natural number.";
    boolean isExit = false;

    protected AmazingNumbers() {
        System.out.println(INSTRUCTIONS);
        do {
            System.out.print("\nEnter a request: ");
            propertyProcessor();
        } while(!isExit);
        System.out.println();
    }

    void propertyProcessor() {
        if (scanner.hasNextLine()) {                // IMPORTANT METHOD TO ACCEPT ENTER KEY AS INPUT AND CONTINUE
            String input = scanner.nextLine();
            if (input.length() != 0) {
                String[] inputArray = input.split(" ");
                try {
                    long number = Long.parseLong(inputArray[0]);
                    if (number < 1 && number != 0) {
                        System.out.println(ERROR1);
                    } else if (number == 0) {
                        isExit = true;
                    } else if (inputArray.length == 2) {
                        try {
                            long numRange = Long.parseLong(inputArray[1]);
                            if (numRange < 1) {
                                System.out.println(ERROR2);
                            } else {
                                propertyPrinter(number, numRange);
                            }
                        } catch (RuntimeException runtimeException) {
                            System.out.println(ERROR2);
                        }
                    } else if (inputArray.length >= 3) {
                        long searchAmount = Long.parseLong(inputArray[1]);
                        String[] propertiesToSearch = new String[inputArray.length - 2];
                        for (int i = 0; i < propertiesToSearch.length; i++) {
                            propertiesToSearch[i] = inputArray[i + 2];
                        }
                        propertyPrinter(number, searchAmount, propertiesToSearch);
                    } else {
                        propertyPrinter(number);
                    }
                } catch (RuntimeException rE) {
                    System.out.println(ERROR1);
                }
            } else {
                System.out.println(INSTRUCTIONS);
            }
        }
    }
}