package app.service;

import app.Dao.Interfaces.MemberDao;
import app.Dto.MemberDto;
import app.service.Interface.MemberServiceInterface;
import java.util.List;
public class MemberService implements MemberServiceInterface {

    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void createMember(MemberDto memberDto) throws Exception {
       
        if (memberDao.findMemberById(memberDto.getId()) != null) {
            throw new Exception("El miembro con ID " + memberDto.getId() + " ya existe.");
        }
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
        
        throw new UnsupportedOperationException("");
    }

    @Override
    public void updateMember(MemberDto memberDto) throws Exception {
     
        MemberDto existingMember = memberDao.findMemberById(memberDto.getId());
        if (existingMember == null) {
            throw new Exception("Miembro no encontrado con ID " + memberDto.getId());
        }
        memberDao.updateMember(memberDto);
    }

    @Override
    public void deleteMember(long id) throws Exception {
        MemberDto existingMember = memberDao.findMemberById(id);
        if (existingMember == null) {
            throw new Exception("Miembro no encontrado con ID " + id);
        }
        memberDao.deleteMember(id);
    }
}
    
    

  
   


}
