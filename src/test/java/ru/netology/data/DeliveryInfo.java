package ru.netology.data;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DeliveryInfo {

    public void fillDeliveryInfo(CardDeliveryInfo cardDeliveryInfo, String date) {
        $("[data-test-id=city] input").setValue(cardDeliveryInfo.getCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(date);
        //$("[data-test-id=date] input").setValue(DataGenerator.generateDate(5));
        $("[data-test-id=name] input").setValue(cardDeliveryInfo.getName());
        $("[data-test-id=phone] input").setValue(cardDeliveryInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $x("//*[text()=\"Запланировать\"]").click();
    }

    public void changeDate(String newDate) {
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(newDate);
        $x("//*[text()=\"Запланировать\"]").click();
        $x("//*[text()=\"У вас уже запланирована встреча на другую дату. Перепланировать?\"]").click();
    }
}
