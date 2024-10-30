package app.Dto;

import app.Model.User;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter
public class MemberDto {
    private long id;
    private User userId;
    private double amount;
    private String type;
    private Date affiliationDate;
    
   
}

