package ru.netology.test;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.CardDeliveryInfo;
import ru.netology.data.DataGenerator;
import ru.netology.data.DeliveryInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryOrderTest {

    private static Faker faker;

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void shouldSuccessfullyBookTheDeliveryOfTheCard() {
        CardDeliveryInfo cardDeliveryInfo = DataGenerator.generateInfo("ru", 4);
        DeliveryInfo.fillDeliveryInfo(cardDeliveryInfo);

        $(withText("Успешно!"));
        //проверка на наличие текста на странице
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + cardDeliveryInfo.getDate()));

        //$(".notification__content").shouldHave(Condition.text("Необходимо подтверждение"));
        //$x("//*[text()=\"Перепланировать\"]").click();
        //$(withText("Успешно!"));
        //$(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + cardDeliveryInfo.getDate()));
    }
}
