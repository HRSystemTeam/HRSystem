package com.human.project.schedule.domain;

/**
 * @author linwt
 * @date 2019/12/19 15:24
 */
public class WagesInfo {
    private int userId;
    private int totalWages;
    private String cardNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(int totalWages) {
        this.totalWages = totalWages;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "WageInfo{" +
                "userId=" + userId +
                ", totalWages=" + totalWages +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
