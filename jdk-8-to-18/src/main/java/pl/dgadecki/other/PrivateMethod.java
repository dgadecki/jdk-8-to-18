package pl.dgadecki.other;

public interface PrivateMethod {

    static String exampleStaticMethod(int input) {
        return input > 10 ? "Easy" : privateStaticMethodWithComplexLogic();
    }

    default String exampleMethod(int input) {
        return input > 10 ? "Easy" : privateMethodWithComplexLogic();
    }

    private String privateMethodWithComplexLogic() {
        return "Complex business logic";
    }

    private static String privateStaticMethodWithComplexLogic() {
        return "Complex business logic from static method";
    }
}
