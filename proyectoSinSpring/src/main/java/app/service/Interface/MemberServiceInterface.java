package app.service.Interface;

import app.Dto.MemberDto;
import java.util.List;

public interface MemberServiceInterface {
    
    public void createMember(MemberDto memberDto) throws Exception;
    public MemberDto getMemberById(long id) throws Exception;
    public List<MemberDto> getAllMembers() throws Exception;
    public void updateMember(MemberDto memberDto) throws Exception;
    public void deleteMember(long id) throws Exception;
    
}
