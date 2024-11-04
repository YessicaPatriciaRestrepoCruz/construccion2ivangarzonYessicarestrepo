package app.Controller;


import app.Controller.Request.CreatePersonRequest;
import app.Dto.PersonDto;
import app.service.PersonService;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController 
@Setter
@Getter
@NoArgsConstructor

@RequestMapping("/persons")

public class PersonController{
    
    @Autowired                       
   private PersonService personService;
    
    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody CreatePersonRequest request) {
        PersonDto personDto = new PersonDto();
        try {
            personDto.setId(request.getId());
            personDto.setDocument(request.getDocument());
            personDto.setName(request.getName());
            personDto.setPhoneNumber(request.getPhoneNumber());
           // personService.createPerson(personDto);
            return new ResponseEntity<>("Persona creada exitosamente.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody CreatePersonRequest request) {
        PersonDto personDto = new PersonDto();
        try {
            personDto.setId(id); // Asignar ID desde la URL
            personDto.setDocument(request.getDocument());
            personDto.setName(request.getName());
            personDto.setPhoneNumber(request.getPhoneNumber());
            personService.updatePerson(personDto);
            return new ResponseEntity<>("Persona actualizada exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        try {
            personService.deletePerson(id);
            return new ResponseEntity<>("Persona borrada exitosamente.", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> listPersons() {
         try {
        List<PersonDto> persons = personService.getAllPersons();
        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(persons, HttpStatus.OK); 
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
    }
    }

}