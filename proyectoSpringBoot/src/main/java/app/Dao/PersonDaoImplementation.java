package app.Dao;


import app.Dao.Interfaces.PersonDao;
import app.Dao.repository.PersonRepository;
import app.Dto.PersonDto;
import app.helpers.Helper;
import app.Model.Person;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service

public class PersonDaoImplementation implements PersonDao {
@Autowired
    PersonRepository personRepository;

    @Override
    public boolean existsByDocument(PersonDto personDto) throws Exception {

        return personRepository.existsByDocument(personDto.getDocument());
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
        personRepository.save(person);
    }

    @Override
    public PersonDto findPersonById(long id) throws Exception {

        Person person = personRepository.findPersonById(id);
        return Helper.parse(person);
    }

    @Override
    public void deletePerson(PersonDto personDto) throws Exception {
        
         if (!personRepository.existsById(personDto.getId())) {
            throw new Exception("Persona no encontrada con ID " + personDto.getId());
        }
        Person person = Helper.parse(personDto);
        personRepository.delete(person);

    }

    public PersonDto findByDocument(PersonDto personDto) {

        Person person = personRepository.findByDocument(personDto.getDocument());
        return Helper.parse(person);
    }

    @Override
    public void updatePerson(PersonDto personDto) throws Exception {
        
        if (!personRepository.existsById(personDto.getId())) {
            throw new Exception("Persona no encontrada con ID " + personDto.getId());
        }
        Person person = Helper.parse(personDto);
        personRepository.save(person);
    }
    
     @Override
    public List<PersonDto> findAllPersons() {
        List<Person> persons = personRepository.findAll(); 
        return Helper.parseToPersonDtoList(persons); 
    }

}
