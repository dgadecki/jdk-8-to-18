package pl.dgadecki.patternmatching;

import java.time.LocalDateTime;

public class PatternMatching_01 {

    public static void main(String[] args) {
        // Old
        System.out.println("-------- OLD ---------");
        oldPatternMatching("test-value");
        oldPatternMatching(3);
        oldPatternMatching(LocalDateTime.now());

        // New
        System.out.println("-------- NEW ---------");
        newPatternMatching("test-value");
        newPatternMatching(3);
        newPatternMatching(LocalDateTime.now());

        // New With Guards
        System.out.println("-------- NEW WITH GUARDS ---------");
        newPatternMatchingWithGuards("Zainstaluj teraz Microsoft Teams");
        newPatternMatchingWithGuards("One");
        newPatternMatchingWithGuards("Mercedes");
    }

    private static void oldPatternMatching(Object object) {
        if (object instanceof String) {
            String string = (String) object;
            if (string.length() > 10) {
                // do some
            }
            System.out.println("I'm a String: " + string);
        } else if (object instanceof Integer) {
            Integer integer = (Integer) object;
            System.out.println("I'm an Integer: " + integer);
        } else if (object instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) object;
            System.out.println("I'm a LocalDateTime: " + localDateTime);
        }
    }

    private static void newPatternMatching(Object object) {
        if (object instanceof String variable123) {
            System.out.println("I'm a String: " + variable123);
        } else if (object instanceof Integer integer) {
            System.out.println("I'm an Integer: " + integer);
        } else if (object instanceof LocalDateTime localDateTime) {
            System.out.println("I'm a LocalDateTime: " + localDateTime);
        }
    }

    private static void newPatternMatchingWithGuards(Object object) {
        if (object instanceof String string && (string.length() > 10 || string.length() < 5)) {
            System.out.println("I'm a long String: " + string);
        } else if (object instanceof String string && string.length() > 4) {
            System.out.println("I'm a short String: " + string);
        } else if (object instanceof String string) {
            System.out.println("I'm a regular String: " + string);
        } else if (object instanceof Integer integer) {
            System.out.println("I'm an Integer: " + integer);
        } else if (object instanceof LocalDateTime localDateTime) {
            System.out.println("I'm a LocalDateTime: " + localDateTime);
        }
    }
}
