package numbers;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class PropertyPrinter extends NumberProperties {
    void propertyPrinter(long num, long amountToFind, String[] propertiesBeingSearched) {
        if (contradictionChecker(propertiesBeingSearched).length() != 0) {
            System.out.printf("\nThe request contains mutually exclusive properties: [%s]" +
                    "\nThere are no numbers with these properties.\n"
                    , contradictionChecker(propertiesBeingSearched));
        } else if (fakeProperty(propertiesBeingSearched) > 0) {
            propertyErrorPrinter(fakeProperty(propertiesBeingSearched));
        } else {
            System.out.println();
            int matchingCount = 0;
            for (long i = num; ; i++) {
                boolean matches = false;
                for (String propertyElement : propertiesBeingSearched) {
                    if (propertyGenerator(i).contains(propertyElement.toLowerCase().replace("-", ""))) {
                        if (propertyElement.contains("-")) {    // if an exclusionary check
                            matches = false;
                            break;
                        } else {
                            matches = true;
                        }
                    } else {
                        if (propertyElement.contains("-")) {    // if an exclusionary check
                            matches = true;
                        } else {
                            matches = false;
                            break;
                        }
                    }
                }
                if (matches) {
                    matchingCount++;
                    System.out.print(propertyGenerator(i));
                }
                if (matchingCount == amountToFind) break;
            }
        }
    }

    String contradictionChecker(String[] propertyArray) {
        List<String> properties = Arrays.asList(propertyArray);
        StringBuilder contradictionCause = new StringBuilder();

        for (String str : propertyArray) {
            if (properties.contains(str) && properties.contains("-" + str)) {
                contradictionCause.append(str.toUpperCase()).append(", -").append(str.toUpperCase());
            } else if (properties.contains("-even") && properties.contains("-odd")) {
                contradictionCause.append("-EVEN, -ODD");
            } else if (properties.contains("even") && properties.contains("odd")) {
                contradictionCause.append("EVEN, ODD");
            } else if (properties.contains("-happy") && properties.contains("-sad")) {
                contradictionCause.append("-HAPPY, -SAD");
            } else if (properties.contains("happy") && properties.contains("sad")) {
                contradictionCause.append("HAPPY, SAD");
            } else if (properties.contains("spy") && properties.contains("duck")) {
                contradictionCause.append("SPY, DUCK");
            } else if (properties.contains("sunny") && properties.contains("square")) {
                contradictionCause.append("SUNNY, SQUARE");
            }
        }
        return contradictionCause.toString();
    }

    void propertyErrorPrinter (int errorCount) {
        String fakePropertyStatement = errorCount == 1 ?
                String.format("\nThe property %s is wrong.\nAvailable properties: %s", invalidProperty
                        , Arrays.toString(AvailableProperties.values()))
                : String.format("\nThe properties [%s] are wrong.\nAvailable properties: %s"
                , invalidProperty, Arrays.toString(AvailableProperties.values()));
        System.out.println(fakePropertyStatement);
    }

    void propertyPrinter(long num, long range) {
        System.out.println();
        for (long i = num; i < (num + range); i++) {
            System.out.print(propertyGenerator(i));
        }
    }

    void propertyPrinter(long num) {
        System.out.printf("""
            \nProperties of %s
            \t\tbuzz: %b
            \t\tduck: %b
             palindromic: %b
            \t  gapful: %b
            \t\t spy: %b
            \t  square: %b
            \t   sunny: %b
            \t jumping: %b
            \t   happy: %b
            \t\t sad: %b
            \t\teven: %b
            \t\t odd: %b
            """, NumberFormat.getInstance().format(num), isBuzz(num), isDuck(num), isPalindromic(num)
                , isGapful(num), isSpy(num), isSquare(num), isSunny(num), isJumping(num)
                , isHappy(num), !isHappy(num), isEven(num), !isEven(num));
    }

    String propertyGenerator(long x) {
        String duck = isDuck(x) ? "duck, " : "";
        String buzz = isBuzz(x) ? "buzz, " : "";
        String even = isEven(x) ? "even, " : "odd, ";
        String palindromic = isPalindromic(x) ? "palindromic, " : "";
        String gapful = isGapful(x) ? "gapful, " : "";
        String spy = isSpy(x) ? "spy, " : "";
        String square = isSquare(x) ? "square, " : "";
        String sunny = isSunny(x) ? "sunny, " : "";
        String jumping = isJumping(x) ? "jumping, " : "";
        String happy = isHappy(x) ? "happy" : "sad";
        return String.format("%16s is %s%s%s%s%s%s%s%s%s%s\n", NumberFormat.getInstance().format(x)
                , even, buzz, duck, palindromic, gapful, spy, square, sunny, jumping, happy);
    }
}