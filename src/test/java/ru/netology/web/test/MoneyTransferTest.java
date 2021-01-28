package ru.netology.web.test;

import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;
import static com.codeborne.selenide.Selenide.open;


class MoneyTransferTest {


    @BeforeAll
    static void setUp() {
        Configuration.browser = "opera";
        Configuration.startMaximized = true;
    }
    @BeforeEach
    void openSetUp () {
        open("http://localhost:9999");
    }

    @Test
    void shouldFillFirstCardSuccessfully() {
        val loginPage = new LoginPageV1();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardsPage = dashboardPage.depositMoneyToCard(1);
        cardsPage.fillFirstCard(2000);
        dashboardPage.cardBalanceCheck();
    }

    @Test
    void shouldFillSecondCardSuccessfully() {
        val loginPage = new LoginPageV1();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardsPage = dashboardPage.depositMoneyToCard(2);
        cardsPage.fillSecondCard(5000);
        dashboardPage.cardBalanceCheck();
    }


}

