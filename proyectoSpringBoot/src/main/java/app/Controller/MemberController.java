package app.Controller;

import app.Controller.Request.CreateMemberRequest;
import app.Dto.MemberDto;
import app.service.Interface.MemberServiceInterface;
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
@RequestMapping("/members")
@Setter
@Getter
@NoArgsConstructor


public class MemberController  { //quitar implements?
    
    @Autowired
    
    private MemberServiceInterface memberService;
  
    
   @PostMapping
   
    public ResponseEntity createMember(@RequestBody CreateMemberRequest request) throws Exception {
        
        MemberDto newMember = new MemberDto();
        try {
        newMember.setId(request.getId());
        newMember.setType(request.getType());
        newMember.setAmount(request.getAmount());
        newMember.setAffiliationDate(request.getAffiliationDate());

        memberService.createMember(newMember);
        System.out.println("Socio creado exitosamente.");
        return new ResponseEntity<>("se ha creado el usuario exitosamente",HttpStatus.OK);
    } catch (Exception e) {
        
      return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }
    
    
    @PutMapping("/{id}") // preguntar funcion 
    public ResponseEntity<String> updateMember(@PathVariable Long id, @RequestBody CreateMemberRequest request) {
        try {
            MemberDto updatedMember = new MemberDto();
            updatedMember.setId(id);
            updatedMember.setType(request.getType());
            updatedMember.setAmount(request.getAmount());
            updatedMember.setAffiliationDate(request.getAffiliationDate());
            memberService.updateMember(updatedMember);
            return new ResponseEntity<>("Socio actualizado exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        try {
            memberService.deleteMember(id);
            return new ResponseEntity<>("Socio borrado exitosamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
   public ResponseEntity<List<MemberDto>> listMembers() {
    try {
        List<MemberDto> members = memberService.getAllMembers();
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        }
        return new ResponseEntity<>(members, HttpStatus.OK); 
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
    }
}
}
    



