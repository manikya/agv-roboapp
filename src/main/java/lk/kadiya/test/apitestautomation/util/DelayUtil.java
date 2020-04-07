package lk.kadiya.test.apitestautomation.util;

public class DelayUtil {
    private static long smallDelay = 300;
    private static long mediumDelay = 500;
    private static long largeDelay = 1000;

    /**
     * Runs small delay
     */
    public static void smallDelay() {
        delay(smallDelay);
    }

    public static void mediumDelay() {
        delay(mediumDelay);
    }

    public static void largeDelay() {
        delay(largeDelay);
    }

    private static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
