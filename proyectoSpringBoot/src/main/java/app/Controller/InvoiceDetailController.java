
package app.Controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yessica
 */


@RestController 
@Setter
@Getter
@NoArgsConstructor
public class InvoiceDetailController implements ControllerInterface {
    
    private static final String MENU = "Gestión de Detalles de Factura\n" +
            "1. Crear  detalles factura\n" +
            "2. Actualizar detalles factura\n" +
            "3. Borrar detalle de factura\n" +
            "4. Listar detalles de factura\n" +
            "5. Cerrar sesión.";

    @Override
    public void session() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
