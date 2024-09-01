package app.Controller;

import app.Dto.PersonDto;
import app.service.Interface.PersonServiceInterface;
import java.util.Scanner;

public class PersonController implements ControllerInterface {
    
    private static final String MENU = "Ingrese la opción que desee \n" +
                                        "1. Crear persona \n" +
                                        "2. Actualizar persona \n" +
                                        "3. Borrar persona \n" +
                                        "4. cerrar sesion\n";
                                        
    private PersonServiceInterface personService;
    private Scanner scanner;

    public PersonController(PersonServiceInterface personService, Scanner scanner) {
        this.personService = personService;
        this.scanner = scanner;
    }
    
    @Override
    public void session() throws Exception {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println("Bienvenido");
            System.out.println(MENU);
            String option = scanner.nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1":
                createPerson();
                return true;
            case "2":
                updatePerson();
                return true;
            case "3":
                deletePerson();
                return true;
           case "4":
                System.out.println("Se ha cerrado sesión.");
                return false;
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }

    private void createPerson() throws Exception {
        System.out.println("Ingrese el ID de la persona:");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Ingrese el número de documento:");
        long document = Long.parseLong(scanner.nextLine());

        System.out.println("Ingrese el nombre:");
        String name = scanner.nextLine();

        System.out.println("Ingrese el número de teléfono:");
        long phoneNumber = Long.parseLong(scanner.nextLine());

        PersonDto personDto = new PersonDto();
        personDto.setId(id);
        personDto.setDocument(document);
        personDto.setName(name);
        personDto.setPhoneNumber(phoneNumber);

        personService.createPerson(personDto);
        System.out.println("Persona creada con éxito.");
    }

    private void updatePerson() throws Exception {
        System.out.println("Ingrese el ID de la persona a actualizar:");
        long id = Long.parseLong(scanner.nextLine());

        PersonDto personDto = personService.getUserById(id);

        System.out.println("Ingrese el nuevo número de documento (actual: " + personDto.getDocument() + "):");
        String documentInput = scanner.nextLine();
        if (!documentInput.isEmpty()) {
            personDto.setDocument(Long.parseLong(documentInput));
        }

        System.out.println("Ingrese el nuevo nombre (actual: " + personDto.getName() + "):");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            personDto.setName(name);
        }

        System.out.println("Ingrese el nuevo número de teléfono (actual: " + personDto.getPhoneNumber() + "):");
        String phoneNumberInput = scanner.nextLine();
        if (!phoneNumberInput.isEmpty()) {
            personDto.setPhoneNumber(Long.parseLong(phoneNumberInput));
        }

        personService.updatePerson(personDto);
        System.out.println("Persona actualizada con éxito.");
    }

    private void deletePerson() throws Exception {
        System.out.println("Ingrese el ID de la persona a borrar:");
        long id = Long.parseLong(scanner.nextLine());

        personService.deletePerson(id);
        System.out.println("Persona borrada con éxito.");
    }
}