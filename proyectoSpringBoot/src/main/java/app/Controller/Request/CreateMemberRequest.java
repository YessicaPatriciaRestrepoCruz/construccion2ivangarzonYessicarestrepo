package app.Controller.Request;
        
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateMemberRequest {
    private Long Id;
    private String type; 
     private double amount;
     private Date affiliationDate;
}
