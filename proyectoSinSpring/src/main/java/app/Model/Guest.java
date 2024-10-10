package app.Model;

public class Guest extends User {
    
    private Long id;  
    private Long userId;
    private long memberId;
    private String invitationStatus; 

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }


   
    

    public Guest() {
    }

    public Guest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

   
    public Long getId() {
        return id; // 
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public String getInvitationStatus() {
        return invitationStatus;
    }

    
    public void setInvitationStatus(String invitationStatus) {
        this.invitationStatus = invitationStatus;
    }
}


