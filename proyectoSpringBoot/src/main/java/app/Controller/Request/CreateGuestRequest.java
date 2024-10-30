
package app.Controller.Request;

import app.Model.Member;
import app.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreateGuestRequest {
    
    private Long Id;
    private Member memberId;//Long
    private User userId;//Long
    private String Status; 
    
    
}
