package pl.dgadecki.other;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

public class ApiMethods {

    public static void main(String[] args) {
        // Stream methods
        streamMethods();
    }

    // Optional
    private static void optionalMethods() {
        Optional<String> v1 = Optional.ofNullable(null); // I can create optional from nullable value;
        v1.ifPresentOrElse(
                s -> System.out.println("If Present"),
                () -> System.out.println("Is Empty")
        );
        v1.isEmpty();
        v1.orElseThrow();
        v1.orElseThrow(() -> new IllegalArgumentException("My custom message"));
        v1.or(() -> Optional.of("or value"));
    }

    // Collection methods
    private void collectionMethods() {
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<Long, String> map = Map.of(
                1L, "one",
                2L, "two",
                3L, "three"
        );

        List<String> copyOfList = List.copyOf(list);
        Set<String> copyOfSet = Set.copyOf(set);
        Map<Long, String> copyOfMap = Map.copyOf(map);
    }

    // Stream methods
    private static void streamMethods() {
        List<String> cars = List.of("Fiat", "BMW", "Mercedes", "VW", "Ferrari", "Lamborghini");

        // takeWhile
        List<String> cars1 = cars.stream()
                .takeWhile(car -> car.length() > 2)
                .toList();

        System.out.println("Take While: " + cars1);

        // dropWhile
        List<String> cars2 = cars.stream()
                .dropWhile(car -> car.length() > 2)
                .toList();

        System.out.println("Drop While: " + cars2);

        // iterate
        System.out.println("Iterate");
        IntStream.iterate(5, i -> i < 20, i -> i + 3).forEach(System.out::println);
    }
}
