package pl.dgadecki.records;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Records_01 {

    public static void main(String[] args) {
        System.out.println("\n------ CREATE RECORDS ------");

        // 1. Create instance of record
        RecordWithParameters recordWithParameters = new RecordWithParameters(3.5, 2.5);
        RecordWithoutParameters recordWithoutParameters = new RecordWithoutParameters();
        System.out.println("Create instance of record with parameters: " + recordWithParameters);
        System.out.println("Create instance of record without: " + recordWithoutParameters);

        // 2. 'record' is not restricted name ('keyword') in Java like 'enum'
        RecordWithParameters record = new RecordWithParameters(10.0, 20.0);
        // RecordWithParameters enum = new RecordWithParameters(10.0, 20.0);

        // Constructors
        System.out.println("\n------ CUSTOM CONSTRUCTORS ------");

        System.out.print("Full canonical constructor: ");
        RecordWithFullCanonicalConstructor recordWithFullCanonicalConstructor = new RecordWithFullCanonicalConstructor("a", "b", "c", "d");

        System.out.print("Compact canonical constructor: ");
        RecordWithCompactCanonicalConstructor recordWithCompactCanonicalConstructor = new RecordWithCompactCanonicalConstructor("a", "b", "c", "d");

        RecordWithCustomNonCanonicalConstructor recordWithCustomNonCanonicalConstructor = new RecordWithCustomNonCanonicalConstructor("Test");
        System.out.println("Custom non canonical constructor: " + recordWithCustomNonCanonicalConstructor);

        // Override generated methods
        System.out.println("\n------ OVERRIDE METHODS ------");
        RecordWithOverrideMethods recordWithOverrideMethods = new RecordWithOverrideMethods("ovr1", "ovr2");
        System.out.println("Override method first : " + recordWithOverrideMethods.first());
        System.out.println("Override method second: " + recordWithOverrideMethods.second());
        System.out.println("Override method toString: " + recordWithOverrideMethods);
        System.out.println("Override method hashCode: " + recordWithOverrideMethods.hashCode());
        System.out.println("Override method equals: " + recordWithOverrideMethods.equals(recordWithOverrideMethods));

        // Static fields and methods
        System.out.println("\n------ STATIC FIELDS AND METHODS ------");
        System.out.println("Static method with constant: " + RecordWithStatic.foo());
        System.out.println("Custom method with variable: " + RecordWithStatic.staticVariable());

        RecordWithStatic recordWithStatic = new RecordWithStatic("record-with-static");
        recordWithStatic.updateStaticVariable(50L);
        System.out.println("Custom method with updated variable: " + RecordWithStatic.staticVariable());

        // Custom methods
        System.out.println("\n------ CUSTOM METHODS ------");
        RecordWithCustomMethods recordWithCustomMethods = new RecordWithCustomMethods("a", "b", "c");
        System.out.println("Custom method: " + recordWithCustomMethods.customMethod());
        System.out.println("Custom method with parameter: " + recordWithCustomMethods.customMethod("param"));
        System.out.println("Custom method without record: " + recordWithCustomMethods.customMethod("first", "second"));
        System.out.println("Custom method with same name of parameters: " + recordWithCustomMethods.customMethod("first", "second", "third"));

    }
}

//------ RECORD DEFINITIONS -------//
record RecordWithParameters(double length, double width) {}

record RecordWithoutParameters() {}

//----- RECORDS WITH CUSTOM CONSTRUCTORS ----//
record RecordWithFullCanonicalConstructor(String a, String b, String c, String d){

    RecordWithFullCanonicalConstructor(String a, String b, String c, String d) {
        if (a.length() != d.length()) {
            throw new IllegalArgumentException("Something is 'no yes'");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        System.out.println("RecordWithCompactCanonicalConstructor created!");
    }
}

record RecordWithCompactCanonicalConstructor(String a, String b, String c, String d){

    // Record removes the boilerplate code
    RecordWithCompactCanonicalConstructor {
        if (a.length() != d.length()) {
            throw new IllegalArgumentException("Something is 'no yes'");
        }
        System.out.println("RecordWithCompactCanonicalConstructor created!");
    }
}

record RecordWithCustomNonCanonicalConstructor(boolean a, int b) {

    RecordWithCustomNonCanonicalConstructor(String value) {
        this(value.length() > 10, value.length());
    }

    // Custom constructor can have less visibility than records, this is not allowed for a canonical constructor
    private RecordWithCustomNonCanonicalConstructor(String valA, String valB) {
        this(valA.length() > 10, valB.length());
    }
}

//----- RECORD WITH OVERRIDE METHODS ----/
record RecordWithOverrideMethods(String first, String second) {

    public String first() {
        return "Custom first " + first;
    }

    public String second() {
        return "Custom second " + second;
    }

    @Override
    public String toString() {
        return "Custom implementation of toString() method";
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

//------ RECORD WITH STATIC ------//
record RecordWithStatic(String name) {
    private static final Long VERY_IMPORTANT_CONSTANT = 100L;
    private static Long staticVariable = 345L;

    public static String foo() {
        return "foo" + VERY_IMPORTANT_CONSTANT;
    }

    public static Long staticVariable() {
        return staticVariable + 10L;
    }

    public void updateStaticVariable(Long value) {
        staticVariable = value;
    }
}

//------ RECORD CUSTOM METHODS -------//
record RecordWithCustomMethods(String first, String second, String third) {

    // Method can be based only on a record
    public String customMethod() {
        return "One-Two-Three " + first + " " + second + " " + third;
    }

    // Method can have parameters
    public String customMethod(String parameter) {
        return parameter + " " + first + " " + second + " " + third;
    }

    // Method does not have to use record attributes
    public String customMethod(String firstParameter, String secondParameter) {
        return "No-Record " + firstParameter + " " + secondParameter;
    }

    // Same names of method parameters as record attributes
    public String customMethod(String first, String second, String third) {
        return "Record " + this.first + " " + this.second + " " + this.third + " " + " No-Record " +  first + " " + second + " " + third;
    }
}

// ------- RECORD + INTERFACE ------//
record RecordImplementsInterface(String name) implements Comparable<RecordImplementsInterface> {

    @Override
    public int compareTo(RecordImplementsInterface o) {
        return 0;
    }
}

// ------- GENERIC RECORD ---------//
record GenericRecord<S extends Serializable, C extends Collection<?>> (S serializable, C collection) { }

// ------- RECORD WITH DEEP MUTABLE ATTRIBUTE ------//
record RecordWithDeepMutableField(AtomicInteger deepMutableField) {

    // Because you can, does not mean you should...
    public int mutate() {
        return deepMutableField.incrementAndGet();
    }
}




