package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.element;

public class MoneyTransferCardsPage {
    private final SelenideElement transferAmount = element("input[maxlength='14']");
    private final SelenideElement fromCard = element("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement transferMoney = element("button.button_view_extra .button__text");

    public MoneyTransferCardsPage() {
        SelenideElement refillCards = element(".heading_size_xl");
        refillCards.should(Condition.visible);
    }


    public DashboardPage fillFirstCard(int sumOfTransfer) {
        fromCard.setValue("5559 0000 0000 0002");
        transferAmount.setValue(String.valueOf(sumOfTransfer));
        DataHelper.getCardsInfo().addMoneyToFirstCard(sumOfTransfer);
        transferMoney.click();
        return new DashboardPage();
    }

    public void fillSecondCard(int sumOfTransfer) {
        fromCard.setValue("5559 0000 0000 0001");
        transferAmount.setValue(String.valueOf(sumOfTransfer));
        DataHelper.getCardsInfo().addMoneyToSecondCard(sumOfTransfer);
        transferMoney.click();

    }
}
