class TimeConstantsDemo {

    public static void main(String[] args) {
        System.out.printf("%d\n%d", TimeConstants.SECONDS_IN_DAY, TimeConstants.SECONDS_IN_WEEK);
    }
}

final class TimeConstants {
    public static final int SECOND = 1;
    public static final int SECONDS_IN_MINUTE = 60 * SECOND;
    public static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE;
    public static final int SECONDS_IN_DAY = SECONDS_IN_HOUR * 24;
    public static final int SECONDS_IN_WEEK = SECONDS_IN_DAY * 7;

    private TimeConstants() {}
}