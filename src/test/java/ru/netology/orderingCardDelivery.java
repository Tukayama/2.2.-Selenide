package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class orderingCardDelivery {
//    @BeforeEach
//    void setUp() {
//
//        open("http://localhost:9999");
//
//    }

    @Test
    void fillingOutTheForm() {
       open("http://localhost:9999");
        $("[class=\"input__control\"][placeholder=\"Город\"]").setValue("Воронеж");
//        $("[class=\"calendar-input__native-control\"]").setValue("2022-01-05");
        $("[class=\"input__control\"][name=\"name\"]").setValue("Иванов Иван");
        $("[class=\"input__control\"][name=\"phone\"]").setValue("+79098787865");
        $(".checkbox__box").click();
        $("[class=\"button__text\"]").click();
        $("[class=\"notification__content\"]").shouldHave(text("Встреча успешно забронирована на"), Duration.ofSeconds(15));
    }


}
