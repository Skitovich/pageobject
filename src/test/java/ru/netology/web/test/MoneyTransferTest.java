package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;

import ru.netology.web.page.LoginPageV1;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.DataHelper.getCardsInfo;


class MoneyTransferTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "opera";
        Configuration.startMaximized = true;

    }

    @Test
    void shouldFillFirstCardSuccessfully() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV1();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardsPage = dashboardPage.depositMoneyToCard(1);
        cardsPage.fillFirstCard(2000);
        element("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").
                shouldHave(text(String.valueOf(getCardsInfo().getFirstCardDeposit())));
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV1();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardsPage = dashboardPage.depositMoneyToCard(2);
        cardsPage.fillFirstCard(5000);
        element("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").
                shouldHave(text(String.valueOf(getCardsInfo().getSecondCardDeposit())));
    }


}

