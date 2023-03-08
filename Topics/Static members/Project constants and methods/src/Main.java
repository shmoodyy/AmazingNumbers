public class Main {

    public static void main(String[] args) {
        System.out.printf("%s\n%s\n%s\n%s", ConstantsAndUtilities.A_CONSTANT_TTT, ConstantsAndUtilities.B_CONSTANT_QQQ,
                ConstantsAndUtilities.getMagicString(), ConstantsAndUtilities.convertStringToAnotherString("aa"));
    }

}

// Don't change this class
class ConstantsAndUtilities {

    public static final String A_CONSTANT_TTT = "1234";

    public static final String B_CONSTANT_QQQ = "7890";

    public static String getMagicString() {
        return A_CONSTANT_TTT + B_CONSTANT_QQQ;
    }

    public static String convertStringToAnotherString(String s) {
        return A_CONSTANT_TTT + s;
    }
}