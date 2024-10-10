package app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter

@Entity
@Table(name= "guest")

public class Guest {
    
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;  //user
     @JoinColumn(name = "userId")
     @OneToOne

    private User userId; //member
    @JoinColumn(name = "memberId")
    @ManyToOne

    private Member memberId;
    @Column(name = "status")//verificar nombre, si tiene que ser igual 

    private String Status; 
   
    
}


