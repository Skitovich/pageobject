package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.element;

public class MoneyTransferCardsPage {
    private final SelenideElement transferAmount = element("input[maxlength='14']");
    private final SelenideElement fromCard = element("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement toCard = element("input[disabled]");
    private final SelenideElement transferMoney = element("button.button_view_extra .button__text");

    public MoneyTransferCardsPage() {
        SelenideElement refillCards = element(".heading_size_xl");
        refillCards.should(Condition.visible);
    }

    public DataHelper.Cards fillFirstCard (int sum) {
        int firstCard = DataHelper.getCardsInfo().getFirstCard() + sum;
        int secondCard = DataHelper.getCardsInfo().getSecondCard() - sum;
       return new DataHelper.Cards(firstCard,secondCard);
    }

    public DataHelper.Cards fillSecondCard (int sum) {
        int firstCard = DataHelper.getCardsInfo().getFirstCard() - sum;
        int secondCard = DataHelper.getCardsInfo().getSecondCard() + sum;
        return new DataHelper.Cards(firstCard,secondCard);
    }

    public void shouldTransferMoneySuccessfully(int sumOfTransfer) {
        if (toCard.has(Condition.selectedText("0001"))) {
            fromCard.setValue("5559 0000 0000 0002");
            fillFirstCard(sumOfTransfer);
        }
        else {
            fromCard.setValue("5559 0000 0000 0001");
            fillSecondCard(sumOfTransfer);
        }
        transferAmount.setValue(String.valueOf(sumOfTransfer));
        transferMoney.click();
    }


}
