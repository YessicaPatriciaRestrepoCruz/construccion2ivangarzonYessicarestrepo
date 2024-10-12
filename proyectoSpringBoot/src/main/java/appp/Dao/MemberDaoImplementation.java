package appp.Dao;

import app.Dao.Interfaces.MemberDao;
import app.Dao.repository.MemberRepository;
import app.Dto.MemberDto;
import app.Dto.UserDto;
import app.Model.Member;
import app.helpers.Helper;
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

    public class MemberDaoImplementation implements MemberDao {
        @Autowired
        MemberRepository memberRepository;
        
        @Override
    public void createMember(MemberDto memberDto) throws Exception {
        
         Member member = Helper.parse(memberDto);
        memberRepository.save(member);
       
    }

    @Override
    public MemberDto findMemberById(long id) throws Exception {
        
         Member member = memberRepository.findMemberById(id);// revisar memberDto
         
         if (member == null) {
        throw new Exception("Miembro no encontrado con ID " + id);
    }
        return Helper.parse(member);
    }

    @Override
    public void updateMember(MemberDto memberDto) throws Exception {
        
        Member member = Helper.parse(memberDto);//verificar helper
      if (member == null) {
        throw new Exception("Miembro no encontrado con ID " + memberDto.getId());
    }
        memberRepository.save(member);
        
    }

    @Override
    public void deleteMember(MemberDto memberDto) throws Exception {
        
        Member member = Helper.parse(memberDto);
        memberRepository.deleteMember(member.getId());
     
    }

    @Override
    public List<MemberDto> getAllMember() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    
}
    

    