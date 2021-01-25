package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.element;

public class LoginPageV2 {
  private final SelenideElement loginField = element("[data-test-id=login] input");
  private final SelenideElement passwordField = element("[data-test-id=password] input");
  private final SelenideElement loginButton = element("[data-test-id=action-login]");

  public VerificationPage validLogin(DataHelper.AuthInfo info) {
    loginField.setValue(info.getLogin());
    passwordField.setValue(info.getPassword());
    loginButton.click();
    return new VerificationPage();
  }
}
