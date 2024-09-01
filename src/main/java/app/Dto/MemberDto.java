package app.Dto;

import java.util.Date;

public class MemberDto {
    private long Id;
    private Long userId;
    private double amount;
    private String type;
    private Date affiliationDate;

    // cambiar las variables comoe sta en la tabla
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setSubscriptionType(String type) {
        this.type = type;
    }

    public Date getAffiliationDate() {
        return affiliationDate;
    }

    public void setAffiliationDate(Date affiliationDate) {
        this.affiliationDate = affiliationDate;
    }
}

