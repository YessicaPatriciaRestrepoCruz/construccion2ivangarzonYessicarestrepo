package app.Model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
@Entity
@Table(name= "invoice") // revisar tabla

public class Invoice {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
     @JoinColumn(name = "personid")
     @ManyToOne
    private Person personId; //person
       @JoinColumn(name = "partnerid")// revisar
      
       @ManyToOne
    private Member memberId;
      @Column(name = "creationDate")
    private Date creationDate;
       @Column(name = "amount")
    private double amount;
        @Column(name = "status") // mayusculas?
    private String status; 
        
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL) //rekacion 
    private List<InvoiceDetail> details;
    
}