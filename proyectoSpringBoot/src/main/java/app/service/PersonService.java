package app.service;

import app.Controller.Utils;
import app.Dto.PersonDto;
import app.service.Interface.PersonServiceInterface;
import appp.Dao.PersonDaoImplementation;
import appp.Dao.UserDaoImplementation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Getter
@Setter
@NoArgsConstructor
@Service

public class PersonService implements PersonServiceInterface {
    
    @Autowired
    private PersonDaoImplementation personDao = new PersonDaoImplementation();
    @Autowired
    private UserDaoImplementation userDao = new UserDaoImplementation();
    
@Override
public PersonDto createPerson() throws Exception {
    
    PersonDto personDto = new PersonDto();

    
    System.out.println("Ingrese el documento de la persona:");
    long document = Utils.getReader().nextLong();
    personDto.setDocument(document); 

    if (this.personDao.existsByDocument(personDto)) {
        personDto = this.personDao.findByDocument(personDto);
        System.out.println("Ya existe: " + personDto.getName());
        return personDto;
    }
    System.out.println("Ingrese el nombre de la persona:");
    String name = Utils.getReader().next();
    personDto.setName(name); 

    System.out.println("Ingrese el número de celular:");
    long phoneNumber = Utils.getReader().nextLong();
    personDto.setPhoneNumber(phoneNumber); 

    this.personDao.createPerson(personDto);
    personDto = this.personDao.findByDocument(personDto);
    return personDto;
}
   
    
 @Override
    public PersonDto getUserById(long id) throws Exception {
       
        try {
            return personDao.findPersonById(id);
        } catch (Exception e) {
            throw new Exception("Error al encontrar persona por ID " + e.getMessage(), e);
        }
    }
 @Override
    
    public void updatePerson(PersonDto personDto) throws Exception {
        try {
            personDao.updatePerson(personDto);
        } catch (Exception e) {
            throw new Exception("Error ctualizando persona: " + e.getMessage(), e);
        }
    }
 @Override
    public void deletePerson(long id) throws Exception {
        PersonDto personDto = personDao.findPersonById(id);
        try {
            personDao.deletePerson(personDto);
        } catch (Exception e) {
            throw new Exception("Error deleting person: " + e.getMessage(), e);
        }
    } //revisar funcionamiento

     

    }
    
    

