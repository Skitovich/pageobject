package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.util.Currency;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;
import static ru.netology.web.data.DataHelper.getCardsInfo;

public class DashboardPage {
    private final SelenideElement secondCardDeposit = element
            ("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");
    private final SelenideElement firstCardDeposit = element
            ("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");


    public DashboardPage() {
        SelenideElement heading = $("[data-test-id=dashboard]");
        heading.shouldBe(visible);
    }



    public MoneyTransferCardsPage depositMoneyToCard(String lastDigitOfCard) {
        if (lastDigitOfCard.equals("1"))
            firstCardDeposit.click();
        else secondCardDeposit.click();
        return new MoneyTransferCardsPage();
    }
}
