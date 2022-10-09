package pl.dgadecki.switchexpression;

import java.util.Random;

public class SwitchExpression {

    public static void main(String[] args) {
        switchExpressionNotNeedAssignedType();
        switchExpressionNotNeedAssignedType();
        switchExpressionNotNeedAssignedType();
    }

    // Statement switch
    private static int switchStatement(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }

    // Statement switch in lambda style
    private static int switchStatementInLambdaStyle(Day day) {
        int numberOfLetters = 0;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numberOfLetters = 6;
            case TUESDAY                -> numberOfLetters = 7;
            case THURSDAY, SATURDAY     -> numberOfLetters = 8;
            case WEDNESDAY              -> numberOfLetters = 9;
        }
        return numberOfLetters;
    }

    // Switch expression in traditional style
    private static int switchExpressionInTraditionalStyle(Day day) {
        return switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                yield 6;
            case TUESDAY:
                yield 7;
            case THURSDAY:
            case SATURDAY:
                yield 8;
            case WEDNESDAY:
                yield 9;
        };
    }

    // Switch expression in lambda style
    private static int switchExpressionInLambdaStyle(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY ->  {
                System.out.println("");
                yield 6;
            }
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
    }

    // Switch expression in lambda style with assignment
    private static int switchExpressionInLambdaStyleWithAssignment(Day day) {
        int numberOfLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
        return numberOfLetters * 2;
    }

    // Switch expression in lambda style with blocks
    private static int switchExpressionInLambdaStyleWithBlocks(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println("Hello monday, friday or sunday");
                yield 6;
            }
            case TUESDAY                -> {
                System.out.println("Hello monday, friday or sunday");
                yield 7;
                // return 7; // return is forbidden in blocks, use yield instead
            }
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
    }

    // Switch statement in lambda style with blocks and return
    private static int switchStatementInLambdaStyleWithBlocksAndReturn(Day day) {
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println("Hello monday, friday or sunday");
                return 6;
            }
            case TUESDAY                -> {
                System.out.println("Hello monday, friday or sunday");
                return  7;
            }
            case THURSDAY, SATURDAY     -> {
                return 8;
            }
            case WEDNESDAY              -> {
                return 9;
            }
            // Not work without default
            default -> {
                return -1;
            }
        }
    }

    // Switch expression need to be exhaustive
    private static int switchExpressionNeedToBeExhaustive(int input) {
        return switch (input) {
            case 0, 1 -> input;
            case 2, 3 -> input * 2;
            default -> -1;
            // default -> throw new IllegalArgumentException();
            /*default -> {
                System.out.println("Illegal argument");
                throw new IllegalArgumentException();
            }*/
        };
    }

    // Switch expression not need assigned type
    private static void switchExpressionNotNeedAssignedType() {
        var input = new Random().nextInt(8);
        var result = switch (input) {
            case 0, 1, 2, 3, 4 -> "I'm a small integer";
            default -> input;
        };
        System.out.printf("The class of %s%n", result.getClass().getCanonicalName());
    }
}
