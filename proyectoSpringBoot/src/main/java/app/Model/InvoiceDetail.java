
package app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter // verificar todos los nombres deben ser igual a la tabla 
@Setter
@Entity
@Table(name= "invoicedetail") 

public class InvoiceDetail {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;
    @JoinColumn(name = "invoiceId")
      @ManyToOne

    private Long invoiceId; //long
     @Column(name = "item")

    private int item;
     @Column(name = "description")

    private String description;
     @Column(name = "amount")

    private double amount;

    
    
    
    
}
