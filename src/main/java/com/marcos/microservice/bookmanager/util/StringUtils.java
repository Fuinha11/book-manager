package com.marcos.microservice.bookmanager.util;

public class StringUtils {
    public static String Sanitise(String input) {
        String regex = "[^\\p{L}\\p{N}\\p{P}\\p{Z}]";
        return input.replaceAll(regex, "");
    }
}
