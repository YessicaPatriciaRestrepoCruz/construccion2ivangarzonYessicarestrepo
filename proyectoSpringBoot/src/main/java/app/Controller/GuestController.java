package app.Controller;


import app.Controller.Request.CreateGuestRequest;
import app.Dto.GuestDto;
import app.service.Interface.GuestServiceInterface;
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

@RequestMapping("/guests")

public class GuestController {
    
     
    @Autowired
    private GuestServiceInterface guestService;
  
 @PostMapping
    public ResponseEntity<String> createGuest(@RequestBody CreateGuestRequest request) {
        GuestDto guestDto = new GuestDto();
        try {
            guestDto.setId(request.getId());
            guestDto.setUserId(request.getUserId());
            guestDto.setMemberId(request.getMemberId());
            guestDto.setStatus(request.getStatus());

            guestService.createGuest(guestDto);
            return new ResponseEntity<>("Invitado creado exitosamente.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuest(@PathVariable Long id, @RequestBody CreateGuestRequest request) {
        GuestDto guestDto = new GuestDto();
        try {
            guestDto.setId(id); // Asignar ID desde la URL
            guestDto.setUserId(request.getUserId());
            guestDto.setMemberId(request.getMemberId());
            guestDto.setStatus(request.getStatus());

            guestService.updateGuest(guestDto);
            return new ResponseEntity<>("Invitado actualizado exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
       

@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long id) {
        try {
            guestService.deleteGuest(id);
            return new ResponseEntity<>("Invitado borrado exitosamente.", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

     @GetMapping
    public ResponseEntity<List<GuestDto>> listGuests() {
        try {
            List<GuestDto> guests = guestService.getAllGuests();
            return new ResponseEntity<>(guests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}

