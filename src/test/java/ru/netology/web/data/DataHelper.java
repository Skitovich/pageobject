package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    public static Cards getCardsInfo() {
        return new Cards();
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode {
        private String code;
    }


    public static class Cards {
        private int firstCard;
        private int secondCard;

        public void addMoneyToFirstCard(int sum) {
            this.firstCard = firstCard + sum;
            this.secondCard = secondCard + sum;
        }

        public void addMoneyToSecondCard(int sum) {
            this.secondCard = secondCard + sum;
            this.firstCard = firstCard - sum;
        }

        public int getFirstCardDeposit() {
            return this.firstCard;
        }

        public int getSecondCardDeposit() {
            return this.firstCard;
        }

    }
}
