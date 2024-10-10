package app.Model;

import java.util.Date;

public class Member{
    private Long Id;
    private Long userId;
    private double amount;
    private String type; // 
    private Date affiliationDate;

    public Member() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public void setType(String type) {
        this.type = type;
    }

    public Date getAffiliationDate() {
        return affiliationDate;
    }

    public void setAffiliationDate(Date affiliationDate) {
        this.affiliationDate = affiliationDate;
    }
}


