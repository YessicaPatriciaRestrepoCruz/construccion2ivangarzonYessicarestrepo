
package app.service.Interface;

import app.Dto.GuestDto;
import java.util.List;

public interface GuestServiceInterface {
    
    public void createGuest(GuestDto guestDto) throws Exception;

    GuestDto getGuestById(long id) throws Exception;
    List<GuestDto> getAllGuests() throws Exception;
    public void updateGuest(GuestDto guestDto) throws Exception;

    void deleteGuest(long id) throws Exception;
    // CREAR FACTURA
    //SOLICITAR CAMBIO A SOCIO
}

