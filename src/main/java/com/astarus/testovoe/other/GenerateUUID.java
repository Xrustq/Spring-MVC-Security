package com.astarus.testovoe.other;

import java.util.UUID;

/**
 * Class for generation UUID.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

public class GenerateUUID {
    public static String gen(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
