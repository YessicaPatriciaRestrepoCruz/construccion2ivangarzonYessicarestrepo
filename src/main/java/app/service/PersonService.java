package app.service;

import app.Dto.PersonDto;
import app.service.Interface.PersonServiceInterface;
import appp.Dao.PersonDaoImplementation;


public class PersonService implements PersonServiceInterface {
    
    private PersonDaoImplementation personDao = new PersonDaoImplementation();

     @Override
    public void createPerson(PersonDto personDto) throws Exception {
         try {
            personDao.createPerson(personDto);
        } catch (Exception e) {
            throw new Exception("Error creating person: " + e.getMessage(), e);
        }
    }
    
 @Override
    public PersonDto getUserById(long id) throws Exception {
       
        try {
            return personDao.findPersonById(id);
        } catch (Exception e) {
            throw new Exception("Error finding person by ID: " + e.getMessage(), e);
        }
    }
 @Override
    
    public void updatePerson(PersonDto personDto) throws Exception {
        try {
            personDao.updatePerson(personDto);
        } catch (Exception e) {
            throw new Exception("Error updating person: " + e.getMessage(), e);
        }
    }
 @Override
    public void deletePerson(long id) throws Exception {
        
        try {
            personDao.deletePerson(id);
        } catch (Exception e) {
            throw new Exception("Error deleting person: " + e.getMessage(), e);
        }
    }
    }
    
    

