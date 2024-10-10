
package app.service.Interface;

import app.Dto.UserDto;

public interface AdminServiceInterface {
    void addAdmin(UserDto userDto) throws Exception;
    void promoteToVIP(long userId) throws Exception;
    void viewInvoices(long userId) throws Exception; 
}