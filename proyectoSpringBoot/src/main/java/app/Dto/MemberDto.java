package app.Dto;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
public class MemberDto {
    private long Id;
    private Long userId;
    private double amount;
    private String type;
    private Date affiliationDate;

    // cambiar las variables comoe sta en la tabla
   
}

