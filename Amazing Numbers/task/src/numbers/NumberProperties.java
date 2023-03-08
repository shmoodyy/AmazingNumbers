package numbers;

class NumberProperties {
    enum AvailableProperties {
        EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD

//        public static ChargeLevel findByNumberOfSections(int sections) {
//            for (ChargeLevel value: values()) {
//                if (value.sections == sections) {
//                    return value;
//                }
//            }
//            return null;
//        }
    }

    static StringBuilder invalidProperty;

    static int fakeProperty(String[] property) {
        int fakeCount = 0;
        boolean fakeFound = true;
        invalidProperty = new StringBuilder();
        for (String str : property) {
            for (AvailableProperties properties : AvailableProperties.values()) {
                if (str.equalsIgnoreCase(properties.name())
                        || str.equalsIgnoreCase("-" + properties.name())) {
                    fakeFound = false;
                    break;
                } else {
                    fakeFound = true;
                }
            }
            if (fakeFound) {
                fakeCount++;
                if (fakeCount == 1) {
                    invalidProperty.append(str.toUpperCase());
                } else {
                    invalidProperty.append(", ").append(str.toUpperCase());
                }
            }
        }
        return fakeCount;
    }

    static boolean isHappy(long num) {
        int sumOfDigitSquared;
        char[] numberToCharArray = String.valueOf(num).toCharArray();
        do {
            sumOfDigitSquared = 0;
            for (char c : numberToCharArray) {
                int digit = Integer.parseInt(String.valueOf(c));
                sumOfDigitSquared += (int) (Math.pow(digit, 2));
                numberToCharArray = String.valueOf(sumOfDigitSquared).toCharArray();
            }
        } while (sumOfDigitSquared != 4 && sumOfDigitSquared != 1);
        return sumOfDigitSquared == 1;
    }

    static boolean isJumping(long num) {
        boolean numberIsJumping = false;
        if (num <= 9 && num > 0) return true;
        String numberToString = String.valueOf(num);
        for (int i = 0; i < numberToString.length() - 1; i++) {
            int digit = Integer.parseInt(String.valueOf(numberToString.charAt(i)));
            int nextDigit = Integer.parseInt(String.valueOf(numberToString.charAt(i + 1)));
            if (nextDigit == digit + 1 || nextDigit == digit - 1) {
                numberIsJumping = true;
            } else {
                numberIsJumping = false;
                break;
            }
        }
        return numberIsJumping;
    }


    static boolean isSunny(long num) {
        return isSquare(num + 1);
    }
    static boolean isSquare(long num) {
        return Math.sqrt(num) % 1 == 0;
    }
    static boolean isSpy(long num) {
        char[] numberToCharArray = String.valueOf(num).toCharArray();
        int sum = 0, product = 1;

        for (char digit : numberToCharArray) {
            sum += Integer.parseInt(String.valueOf(digit));
            product *= Integer.parseInt(String.valueOf(digit));
        }

        return sum == product;
    }

    static boolean isGapful(long num) {
        String numberToString = String.valueOf(num);
        String gapfulDigits = String.valueOf(numberToString.charAt(0)) +
                numberToString.charAt(numberToString.length() - 1);
        return num % Integer.parseInt(gapfulDigits) == 0 && num > 99;
    }
    static boolean isPalindromic(long num) {
        String numberToString = String.valueOf(num);
        StringBuilder reverseNumber = new StringBuilder(numberToString).reverse();
        int midpoint = numberToString.length() / 2;
        return numberToString.substring(0, midpoint).equals(reverseNumber.substring(0, midpoint));
    }

    static boolean isEven (long num) {
        return num % 2 == 0;
    }
    static boolean isBuzz (long num) {
        return num % 7 == 0 || (num + 3) % 10 == 0;
    }
    static boolean isDuck (long num) {
        return String.valueOf(num).contains("0");
    }
}
