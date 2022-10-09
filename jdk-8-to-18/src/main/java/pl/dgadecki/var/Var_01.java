package pl.dgadecki.var;

import lombok.NonNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Var_01 {

    public static void main(String[] args) throws IOException {

        // Local variable declaration
        var names = List.of("Harry", "James", "Lewis");
        var streamOfNames = names.stream();
        /*var filePath = Paths.get("example-file-name.txt");
        var fileBytes = Files.readAllBytes(filePath);*/

        var numbers = new ArrayList<Long>(); // ArrayList<Long>
        var objects = new ArrayList<>();     // ArrayList<Object>

        // var is not a 'keyword' in Java
        var var = "var";
        System.out.println(var);

        List<String> cars = List.of("BMW", "Audi", "VW", "Mercedes");

        // for loop
        for (var car :  cars) {
            System.out.println("Car: " + car);
        }

        // index variable in for loop
        for (var i = 0; i < cars.size(); i++) {
            System.out.println("Index (Car): " + cars.get(i));
        }

        // try-with-resources
        try (var input = new FileInputStream("test.txt")) {

        }

        // Lambda parameters (JDK 11)
        BiFunction<Integer, Integer, Integer> fna = (var a, var b) -> a > 10 ? a + b : a - b;

        // Annotations and var
        BiFunction<Integer, Integer, Integer> fnb = (@NonNull var a, @NonNull var b) -> a > 10 ? a + b : a - b;
    }
}
