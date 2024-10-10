package app.Dto;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter

public class InvoiceDto {
    
    private long id;
    private PersonDto personId;
    private MemberDto memberId;
    private Date creationDate;
    private double amount;
    private String status; 

    
}
