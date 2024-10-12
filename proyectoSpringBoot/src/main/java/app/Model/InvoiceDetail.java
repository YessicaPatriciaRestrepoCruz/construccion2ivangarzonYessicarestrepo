
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
    
    
    @ManyToOne
    @JoinColumn(name = "invoiceId", nullable= false)
    private Invoice invoice; 
    
     @Column(name = "item")

    private int item;
     @Column(name = "description")

    private String description;
     @Column(name = "amount")

    private double amount;

    
    
    
    
}
