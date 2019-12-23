package com.human.project.schedule.domain;

import java.sql.Date;

/**
 * @author linwt
 * @date 2019/12/19 15:24
 */
public class WagesInfo {
    private int recordId;
    private int userId;
    private String userName;
    private float totalWages;
    private String cardNumber;
    private String wagesDate;
    private Date releaseDate;
    /**
     * 部门ID
     */
    private Long deptId;

    private int isSend;

    public WagesInfo() {
    }

    public WagesInfo(int recordId, int userId, String userName, float totalWages, String cardNumber, String wagesDate, Date releaseDate, Long deptId, int isSend) {
        this.recordId = recordId;
        this.userId = userId;
        this.userName = userName;
        this.totalWages = totalWages;
        this.cardNumber = cardNumber;
        this.wagesDate = wagesDate;
        this.releaseDate = releaseDate;
        this.deptId = deptId;
        this.isSend = isSend;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(float totalWages) {
        this.totalWages = totalWages;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getWagesDate() {
        return wagesDate;
    }

    public void setWagesDate(String wagesDate) {
        this.wagesDate = wagesDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    @Override
    public String toString() {
        return "WagesInfo{" +
                "recordId=" + recordId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", totalWages=" + totalWages +
                ", cardNumber='" + cardNumber + '\'' +
                ", wagesDate='" + wagesDate + '\'' +
                ", releaseDate=" + releaseDate +
                ", deptId=" + deptId +
                ", isSend=" + isSend +
                '}';
    }
}
