package pl.dgadecki.switchexpression;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SwitchPatternMatching {

    public static void main(String[] args) {
        // Null support
        System.out.println("\n----- NULL SUPPORT -----");
        System.out.println(switchWithNullSupport("Java"));
        System.out.println(switchWithNullSupport(null));

        // Null support
        System.out.println("\n----- NULL SUPPORT WITH DEFAULT -----");
        System.out.println(switchWithNullAndDefaultSupport("Java"));
        System.out.println(switchWithNullAndDefaultSupport("not Java"));
        System.out.println(switchWithNullAndDefaultSupport(null));

        // Switch with pattern matching
        System.out.println("\n----- SWITCH WITH PATTERN MATCHING -----");
        System.out.println(switchWithPatternMatching("Java"));
        System.out.println(switchWithPatternMatching(10));
        System.out.println(switchWithPatternMatching(LocalDateTime.now()));
        System.out.println(switchWithPatternMatching(new double[]{ 2d, 3d, 4d }));
        System.out.println(switchWithPatternMatching(BigDecimal.valueOf(23.00)));

        // Switch with pattern matching and guards
        System.out.println("\n----- SWITCH WITH PATTERN MATCHING AND GUARDS -----");
        System.out.println(switchWithPatternMatchingAndGuards("Java"));
        System.out.println(switchWithPatternMatchingAndGuards("Java is cool"));
        System.out.println(switchWithPatternMatchingAndGuards(5));
        System.out.println(switchWithPatternMatchingAndGuards(100));
        System.out.println(switchWithPatternMatchingAndGuards(20));
        System.out.println(switchWithPatternMatchingAndGuards(BigDecimal.valueOf(23.00)));

        System.out.println("\n----- DOMINANT CHECKING IS NOT PERFECT -----");
        System.out.println(switchWithCheckingDominantCasesIsNotPerfect(15));
        System.out.println(switchWithCheckingDominantCasesIsNotPerfect(25));
        System.out.println(switchWithCheckingDominantCasesIsNotPerfect(35));
    }


    // Switch with null support (it works also with statement)
    private static String switchWithNullSupport(String input) {
        return switch (input) {
            case "Java" -> "Java as an input";
            case null -> "Null as an input and still works!";
            default -> "Other input";
        };
    }

    // Switch with null and default together (it works also with statement)
    private static String switchWithNullAndDefaultSupport(String input) {
        return switch (input) {
            case "Java" -> "Java as an input";
            case null, default -> "Other input as Java";
        };
    }

    // Switch with pattern matching (it works also with statement)
    private static String switchWithPatternMatching(Object object) {
        return switch (object) {
            case Integer integer && integer > 6 -> "Hello, I'm Integer: " + integer;
            case String string-> "Hello, I'm String: " + string;
            case LocalDateTime localDateTime -> "Hello, I'm LocalDateTime: " + localDateTime;
            case double[] doubleArray -> "Hello, I', double array: " + Arrays.toString(doubleArray);
            default -> "Hello, I'm other object type: " + object.getClass().getCanonicalName();
        };
    }

    // Example with dominant case (Integer, String and ... also is Serializable)
    private static void switchWithDominantCase(Object object) {
        /*return switch (object) {
            case Serializable serializable -> "!!! Dominant case !!!";
            case Integer integer -> "Hello, I'm Integer: " + integer;
            case String string-> "Hello, I'm String: " + string;
            case LocalDateTime localDateTime -> "Hello, I'm LocalDateTime: " + localDateTime;
            case double[] doubleArray -> "Hello, I', double array: " + Arrays.toString(doubleArray);
            default -> "Hello, I'm other object type: " + object.getClass().getCanonicalName();
        };*/
    }

    // Switch with pattern matching and guards (it works also with statement)
    private static String switchWithPatternMatchingAndGuards(Object object) {
        return switch (object) {
            case Integer integer && integer < 10 -> "Hello, I'm small Integer: " + integer;
            case Integer integer && integer > 50 -> "Hello, I'm large Integer: " + integer;
            case Integer integer -> "Hello, I'm standard Integer: " + integer;
            case String string && string.length() < 8 -> "Hello, I'm short String: " + string;
            case String string -> "Hello, I'm standard String: " + string;
            default -> "Hello, I'm other object type: " + object.getClass().getCanonicalName();
        };
    }

    // Example with dominant case in guards
    private static void switchWithDominantCaseAndGuards(Object object) {
        /*var result = switch (object) {
            case Integer integer -> "!!! Dominant case !!!";
            case Integer integer && (integer < 10 || integer > 50) -> "Hello, I'm special Integer: " + integer;
            case String string && string.length() < 8 -> "Hello, I'm short String: " + string;
            case String string -> "Hello, I'm standard String: " + string;
            default -> "Hello, I'm other object type: " + object.getClass().getCanonicalName();
        };*/
    }

    // Not all is perfect -> it's works
    private static String switchWithCheckingDominantCasesIsNotPerfect(Object object) {
        return switch (object) {
            case Integer integer && integer > 10 -> "Hello, I'm greater than 10 Integer: " + integer;
            case Integer integer && integer > 20 -> "Hello, I'm greater than 20 Integer: " + integer;
            case Integer integer && integer > 30 -> "Hello, I'm greater than 30 Integer: " + integer;
            case String string && string.length() < 8 -> "Hello, I'm short String: " + string;
            case String string -> "Hello, I'm standard String: " + string;
            default -> "Hello, I'm other object type: " + object.getClass().getCanonicalName();
        };
    }
}
