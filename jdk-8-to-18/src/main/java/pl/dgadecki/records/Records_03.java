package pl.dgadecki.records;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Records_03 {

    public static void main(String[] args) {
        System.out.println("\n------ RECORDS + LOMBOK ------");

        RecordWithBuilder recordWithBuilder = RecordWithBuilder.builder()
                .firstName("Harry")
                .lastName("Potter")
                .city("London")
                .build();

        RecordWithBuilderV2 recordWithBuilderV2 = RecordWithBuilderV2.builder()
                .build();

        BigDecimal x = new BigDecimal(3L).divide(new BigDecimal(2L), 2, RoundingMode.HALF_UP);

        System.out.println("Record with builder: " + x);
        System.out.println("Record with builder V2: " + recordWithBuilderV2);
    }
}

@Builder
record RecordWithBuilder(String firstName, String lastName, String city) { }

record RecordWithBuilderV2(String firstName, String lastName, String city) {

    @Builder
    RecordWithBuilderV2 {
        // Required only for builder
    }
}