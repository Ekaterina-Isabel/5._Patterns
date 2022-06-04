package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    public static String generateDate(int days) {
        String data = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return data;
    }

    public static CardDeliveryInfo generateInfo(String locale, int daysShift) {
        Faker faker = new Faker(new Locale(locale));
        return new CardDeliveryInfo(
                faker.address().city(),
                faker.name().fullName(),
                faker.phoneNumber().phoneNumber()
        );
    }
}
