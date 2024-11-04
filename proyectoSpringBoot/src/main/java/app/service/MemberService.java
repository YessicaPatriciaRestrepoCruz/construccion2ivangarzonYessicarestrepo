package app.service;
import app.Controller.Validator.MemberValidator;
import app.Dao.Interfaces.MemberDao;
import app.Dto.MemberDto;
import app.service.Interface.MemberServiceInterface;
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
public class MemberService implements MemberServiceInterface {
@Autowired 
    private MemberDao memberDao;

@Autowired
    private MemberValidator memberValidator;


@Override
 public void createMember(MemberDto memberDto) throws Exception {
     
        if (memberDto == null) {
            throw new IllegalArgumentException("MemberDto no puede ser nulo");
        }
     
         if (memberDao.findMemberById(memberDto.getId()) != null) {
            throw new Exception("El miembro con ID " + memberDto.getId() + " ya existe.");
        }

        memberValidator.validateAmount(memberDto.getAmount());
        memberValidator.validateType(memberDto.getType());
        
        memberDao.createMember(memberDto);
    }


    @Override
    public MemberDto getMemberById(long id) throws Exception {
        MemberDto member = memberDao.findMemberById(id);
        if (member == null) {
            throw new Exception("Miembro no encontrado con ID " + id);
        }
        return member;
    }

    @Override
    public List<MemberDto> getAllMembers() throws Exception {
        
         return memberDao.getAllMember();
    }

    @Override
    public void updateMember(MemberDto memberDto) throws Exception {
        
        if (memberDto == null) {
            throw new IllegalArgumentException("MemberDto no puede ser nulo");
        }
     
        MemberDto existingMember = memberDao.findMemberById(memberDto.getId());
        if (existingMember == null) {
            throw new Exception("Miembro no encontrado con ID " + memberDto.getId());
        }
        
        
        memberValidator.validateAmount(memberDto.getAmount());
        memberValidator.validateType(memberDto.getType());
        memberDao.updateMember(memberDto);
    }

    @Override
    public void deleteMember(long id) throws Exception {
        MemberDto existingMember = memberDao.findMemberById(id);
        if (existingMember == null) {
            throw new Exception("Miembro no encontrado con ID " + id);
        }
        memberDao.deleteMember(existingMember);
    }  
}
