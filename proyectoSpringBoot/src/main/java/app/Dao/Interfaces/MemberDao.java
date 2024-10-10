package app.Dao.Interfaces;

import app.Dto.MemberDto;

public interface MemberDao {
   
    void createMember(MemberDto memberDto) throws Exception;
    MemberDto findMemberById(long id) throws Exception;
    void updateMember(MemberDto memberDto) throws Exception;
    void deleteMember(MemberDto memberDto) throws Exception;
}
