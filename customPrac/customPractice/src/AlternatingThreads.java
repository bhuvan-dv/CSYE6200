//package edu.neu.csye6200;
///**
// * STUDENT TODO CODE SKELETON
// * class TwoAlternatingThreads
// *
// * Design a class that will start two alternating threads demonstrating control as they alternate output.
// * Two threads take turns alternating outputting the letters of the alphabet (LOWERCASE and UPPERCASE) to console (aAbAcCdD... etc.).
// *
// * 10 POINTS: Output alphabet Threads
// * 20 POINTS: Start Threads
// * 50 POINTS: Control Threads
// * 20 POINTS: Correct Submission, specifically:
// * 	1. On-time,
// *  2. Executable,
// *  3. All code correctly named
// *   (e.g. Driver, etc. ),
// *  4. Console output cut and paste at end of main() method as comment.
// *
// * @author danielgmp
// *
// */
//
//public class AlternatingThreads {
//
//    public static final int MAJOR = 1;
//    public static final int MINOR = 1;
//    public static final String VERSION = MAJOR + "." + MINOR;
//
//    private final Object monitor = new Object();
//    private boolean isUpperCaseTurn = true;
//
//// 	/**
//// 	 * STUDENT TODO:
//// 	 */
//    public void alphaThreads() {
//        Thread thread1 = new Thread(() -> printAlphabet(true));
//        Thread thread2 = new Thread(() -> printAlphabet(false));
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void printAlphabet(boolean isUpperCase) {
//        char start = isUpperCase ? 'A' : 'a';
//        char end = isUpperCase ? 'Z' : 'z';
//
//        for (char c = start; c <= end; c++) {
//            synchronized (monitor) {
//                try {
//                    while ((isUpperCase && !isUpperCaseTurn) || (!isUpperCase && isUpperCaseTurn)) {
//                        monitor.wait();
//                    }
//                    System.out.print(c);
//                    isUpperCaseTurn = !isUpperCaseTurn;
//                    monitor.notify();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void demo() {
//        System.out.println("\n\t" + AlternatingThreads.class.getSimpleName() + ".demo() version [ " + VERSION + " ]");
//
//        AlternatingThreads obj = new AlternatingThreads();
//
//        obj.alphaThreads();
//    }
//}
//
//
//-----Basa
package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

/**
 * STUDENT TODO CODE SKELETON
 * class TwoAlternatingThreads
 *
 * Design a class that will start two alternating threads demonstrating control as they alternate output.
 * Two threads take turns alternating outputting the letters of the alphabet (LOWERCASE and UPPERCASE) to console (aAbBcCdD... etc.).
 *
 * 10 POINTS: Output alphabet Threads
 * 20 POINTS: Start Threads
 * 50 POINTS: Control Threads
 * 20 POINTS: Correct Submission, specifically:
 * 	1. On-time,
 *  2. Executable,
 *  3. All code correctly named
 *   (e.g. Driver, etc. ),
 *  4. Console output cut and paste at end of main() method as comment.
 *
 * @author danielgmp
 *
 */
public class AlternatingThreads {
    public static final int MAJOR = 1;
    public static final int MINOR = 1;
    public static final String VERSION = MAJOR + "." + MINOR;

    private static final Object lock = new Object();
    private static boolean printLowerCase = true;


    /**
     * STUDENT TODO:
     */
    public void alphaThreads() {
        Thread thread1 = new Thread(() -> printAlphabet(true));
        Thread thread2 = new Thread(() -> printAlphabet(false));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printAlphabet(boolean isLowerCase) {
        for (char c = isLowerCase ? 'a' : 'A'; isLowerCase ? c <= 'z' : c <= 'Z'; c++) {
            synchronized (lock) {
                while (isLowerCase && !printLowerCase || !isLowerCase && printLowerCase) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(c);
                if (!printLowerCase) printLowerCase = true;
                else printLowerCase = false;
                lock.notify();
            }
        }
    }

    public static void demo() {
        System.out.println("\n\t" + AlternatingThreads.class.getSimpleName() + ".demo() version [ " + VERSION + " ]");

        AlternatingThreads obj = new AlternatingThreads();

        obj.alphaThreads();
    }


}