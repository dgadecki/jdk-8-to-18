package pl.dgadecki.records;

public class Records_02 {

    public static void main(String[] args) {
        System.out.println("\n------ RECORDS CAN'T ------");
    }
}

record DefaultRecord(String name) {}

record RecordCannotExtend(String name) //extend java.text.SimpleDateFormat
{}

class ExtendingRecordDoesNotWork
    // extends DefaultRecord
{}

final
// abstract
record
AbstractRecord(String name) {}

record RecordWithExtraFields(String name) {
   // private final int firstValue;
}

record NoMutableMethods(String name) {

    /*public void name(String newName) {
        this.name = newName;
    }*/

    /*public void otherNameMethod(String newName) {
        this.name = newName;
    }*/
}

// Constructor -> limitations
record CompactConstructorCannotAssignAttributes(String name) {

    /*CompactConstructorCannotAssignAttributes {
        this.name = "Test";
    }*/
}

record FullCanonicalConstructorMustHaveTheSameParameterNamesAsRecord(String name, String city) {

    /*FullCanonicalConstructorMustHaveTheSameParameterNamesAsRecord(String otherName, String otherCity) {
        this.name = otherName;
        this.city = otherCity;
    }*/
}
