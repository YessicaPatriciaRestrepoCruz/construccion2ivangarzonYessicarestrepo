
package app.service.Interface;

import app.Dto.GuestDto;
import java.util.List;

public interface GuestServiceInterface {
    
    public void addGuest(GuestDto guestDto) throws Exception;
    public void addGuest( ) throws Exception;

    GuestDto getGuestById(long id) throws Exception;
    List<GuestDto> getAllGuests() throws Exception;
    void updateGuest(GuestDto guestDto) throws Exception;
    public void updateGuest( ) throws Exception;

    void deleteGuest() throws Exception;
    // CREAR FACTURA
    //SOLICITAR CAMBIO A SOCIO
}

