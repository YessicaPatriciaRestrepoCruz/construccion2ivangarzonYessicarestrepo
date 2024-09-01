package app.Dao.Interfaces;

import app.Dto.GuestDto;

public interface GuestDao {
   
    void createGuest(GuestDto guestDto) throws Exception;
    GuestDto findGuestById(long id) throws Exception;
    void updateGuest(GuestDto guestDto) throws Exception;
    void deleteGuest(long id) throws Exception;
    
}
