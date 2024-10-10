package app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
@Entity
@Table(name= "person")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "document")
    private Long document;
    @Column(name = "name")
    private String name;
    @Column(name = "Cellphone") //cambiar nombre

    private Long phoneNumber;
    
     
}


