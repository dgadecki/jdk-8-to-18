package pl.dgadecki.nullpointerexception;

import java.util.Map;

public class NPE_01 {

    public static void main(String[] args) {
        Post post = new Post("51-505", "Wrocław", "Polska");
        Address address = new Address("Wrocław", "Legnicka", post);
        Student student = new Student("Harry", "Potter", address);

        // NPE (-XX:-ShowCodeDetailsInExceptionMessages)
        // student.getAddress().getPost().getCountry().equalsIgnoreCase("POLSKA");

        // NPE
        Map<Long, String> dictionary = Map.of(
                1L, "one",
                2L, "two",
                3L, "three"
        );
        dictionary.get(10L).toLowerCase().length();
    }
}
