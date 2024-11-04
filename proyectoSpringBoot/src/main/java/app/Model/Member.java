package app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
@Entity
@Table(name= "partner")//revisar nombre
public class Member{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    
    @JoinColumn(name = "userId")
    @OneToOne
    private User userId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "type")
    private String type; 
    @Column(name = "CreationDate") //cambiar nombre
    private Date affiliationDate;

    
}


