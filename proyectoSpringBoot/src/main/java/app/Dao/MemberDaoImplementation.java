package app.Dao;

import app.Dao.Interfaces.MemberDao;
import app.Dao.repository.MemberRepository;
import app.Dto.MemberDto;
import app.Model.Member;
import app.helpers.Helper;
import java.util.List;
import java.util.stream.Collectors;
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
        
         Member member = memberRepository.findById(id);
         
         if (member == null) {
        throw new Exception("Miembro no encontrado con ID " + id);
    }
        return Helper.parse(member);
    }

    @Override
    public void updateMember(MemberDto memberDto) throws Exception {
        
        Member member = Helper.parse(memberDto);
      if (member == null) {
        throw new Exception("Miembro no encontrado con ID " + memberDto.getId());
    }
        memberRepository.save(member);
        
    }

    @Override
    public void deleteMember(MemberDto memberDto) throws Exception {
        
        if (!memberRepository.existsById(memberDto.getId())) {
            throw new Exception("Miembro no encontrado con ID " + memberDto.getId());
        }
        
        Member member = Helper.parse(memberDto);
        memberRepository.delete(member);
     
    }

    @Override
    public List<MemberDto> getAllMember() throws Exception {
       
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(Helper::parse) // Usa el método de conversión
                .collect(Collectors.toList());
    }
    
}
    

    