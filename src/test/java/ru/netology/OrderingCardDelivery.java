package ru.netology;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class OrderingCardDelivery {
    String generateDate() {

        return LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }
    String planningDate = generateDate();
    @Test
    void fillingOutTheForm() {
       open("http://localhost:9999");
        $("[class=\"input__control\"][placeholder=\"Город\"]").setValue("Воронеж");
       $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[class=\"input__control\"][name=\"name\"]").setValue("Иванов Иван");
        $("[class=\"input__control\"][name=\"phone\"]").setValue("+79098787865");
        $(".checkbox__box").click();
        $("[class=\"button__text\"]").click();
        $(".notification__content").shouldHave(exactText("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
    }


}
