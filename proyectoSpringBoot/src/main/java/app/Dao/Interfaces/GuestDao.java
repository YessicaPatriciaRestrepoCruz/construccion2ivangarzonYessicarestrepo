package app.Dao.Interfaces;

import app.Dto.GuestDto;
import app.Dto.UserDto;

public interface GuestDao {
   
    void createGuest(GuestDto guestDto) throws Exception;
    GuestDto findGuestById(GuestDto guestDto) throws Exception;
    void updateGuest(GuestDto guestDto) throws Exception;
    void deleteGuest(GuestDto guestDto) throws Exception;
    public GuestDto findByUserId( UserDto userDto ) throws Exception;
}
