package org.example.model;

public class RequestDto {
    private String rqUID;
    private String clientId;
    private String account;
    private String openDate;
    private String closeDate;

    public RequestDto() {}

    public RequestDto(String rqUID, String clientId, String account, String openDate, String closeDate) {
        this.rqUID = rqUID;
        this.clientId = clientId;
        this.account = account;
        this.openDate = openDate;
        this.closeDate = closeDate;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
}
