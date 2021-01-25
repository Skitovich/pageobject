package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class CardsPage {
    private final SelenideElement transferAmount = element("input[maxlength='14']");
    private final SelenideElement fromCard = element("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement toCard = element("input[disabled]");
    private final SelenideElement transferMoney = element("button.button_view_extra .button__text");

    public CardsPage() {
        SelenideElement refillCards = element(".heading_size_xl");
        refillCards.should(Condition.visible);
    }

    public DashboardPage shouldTransferMoneySuccessfully(String sumOfTransfer) {
        if (toCard.has(Condition.selectedText("0001")))
            fromCard.setValue("5559 0000 0000 0002");
        else fromCard.setValue("5559 0000 0000 0001");
        transferAmount.setValue(sumOfTransfer);
        transferMoney.click();
        return new DashboardPage();
    }


}
