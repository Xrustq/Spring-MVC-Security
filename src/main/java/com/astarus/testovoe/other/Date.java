package com.astarus.testovoe.other;

/**
 * Class for generation date.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

public class Date {
    public static String date() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String currentTime = sdf.format(dt);
         return currentTime;
    }
}
