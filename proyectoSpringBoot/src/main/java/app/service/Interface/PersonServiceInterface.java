package app.service.Interface;

import app.Dto.PersonDto;
import java.util.List;

public interface PersonServiceInterface {
    
    //public void createPerson(PersonDto personDto) throws Exception;
    public PersonDto getUserById(long id) throws Exception;
    public void updatePerson(PersonDto personDto) throws Exception;
    public void deletePerson(long id) throws Exception;
    public  PersonDto createPerson() throws Exception;
    List<PersonDto> findAllPersons(); 
    List<PersonDto> getAllPersons();
    
}
