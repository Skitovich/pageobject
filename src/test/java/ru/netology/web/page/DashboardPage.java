package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;
import static ru.netology.web.data.DataHelper.getCardsInfo;

public class DashboardPage {
    private final SelenideElement fillSecondCardDeposit =
            element("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");
    private final SelenideElement fillFirstCardDeposit =
            element ("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");
    private final SelenideElement checkFirstCardDeposit =
            element("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private final SelenideElement checkSecondCardDeposit =
            element("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public DashboardPage() {
        SelenideElement heading = $("[data-test-id=dashboard]");
        heading.shouldBe(visible);

    }

    public MoneyTransferCardsPage depositMoneyToCard(int enterLastNumOfCard) {
        if (enterLastNumOfCard == 1) fillFirstCardDeposit.click();
        else fillSecondCardDeposit.click();
        return new MoneyTransferCardsPage();
    }

    public void cardBalanceCheck () {
      checkFirstCardDeposit.shouldHave(text(String.valueOf(getCardsInfo().getFirstCardDeposit())));
        checkSecondCardDeposit.shouldHave(text(String.valueOf(getCardsInfo().getSecondCardDeposit())));
    }
}
