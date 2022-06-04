package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.CardDeliveryInfo;
import ru.netology.data.DataGenerator;
import ru.netology.data.DeliveryInfo;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryOrderTest {

    private static Faker faker;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSuccessfullyBookTheDeliveryOfTheCard() {
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        String date = DataGenerator.generateDate(5);
        CardDeliveryInfo cardDeliveryInfo = DataGenerator.generateInfo("ru", 4);
        deliveryInfo.fillDeliveryInfo(cardDeliveryInfo, date);

        $(withText("Успешно!"));
        //проверка на наличие текста на странице
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + date));

        String newDate = DataGenerator.generateDate(5);
        deliveryInfo.changeDate(newDate);

        $(withText("Успешно!")).should(visible);
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + newDate));
    }
}
