package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class DashboardPage {
  private final SelenideElement secondCardDeposit = element("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text");
  private final SelenideElement firstCardDeposit = element("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text");


  public DashboardPage() {
    SelenideElement heading = $("[data-test-id=dashboard]");
    heading.shouldBe(visible);
  }

  public CardsPage depositMoneyToCard (int lastFourDigitsOfCard) {
    if (lastFourDigitsOfCard == 0001)
    firstCardDeposit.click();
    else secondCardDeposit.click();
    return new CardsPage();
  }
}