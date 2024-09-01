package appp.Dao;

import app.Dao.Interfaces.MemberDao;
import app.Dto.MemberDto;
import app.Model.Member;
import app.config.MYSQLConnection;
import app.helpers.Helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class MemberDaoImplementation implements MemberDao {
        
        @Override
    public void createMember(MemberDto memberDto) throws Exception {
        Member member = Helper.parse(memberDto);
        String query = "INSERT INTO MEMBER (USER_ID, AVAILABLE_FUNDS, SUBSCRIPTION_TYPE, AFFILIATION_DATE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, member.getId());
            preparedStatement.setDouble(2, member.getAmount());
            preparedStatement.setString(3, member.getType());
           
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al crear el socio");
        }
    }

    @Override
    public MemberDto findMemberById(long id) throws Exception {
        String query = "SELECT * FROM MEMBER WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Member member = new Member();
                member.setId(resultSet.getLong("ID"));
                member.setId(resultSet.getLong("USER_ID"));
                member.setAmount(resultSet.getDouble("AVAILABLE_FUNDS"));
                member.setType(resultSet.getString("SUBSCRIPTION_TYPE"));
                member.setAffiliationDate(resultSet.getTimestamp("AFFILIATION_DATE"));
                return Helper.parse(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al encontrar el socio");
        }
        return null;
    }

    @Override
    public void updateMember(MemberDto memberDto) throws Exception {
        Member member = Helper.parse(memberDto);
        String query = "UPDATE MEMBER SET USER_ID = ?, AVAILABLE_FUNDS = ?, SUBSCRIPTION_TYPE = ?, AFFILIATION_DATE = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, member.getId());
            preparedStatement.setDouble(2, member.getAmount());
            preparedStatement.setString(3, member.getType());
            
            preparedStatement.setLong(5, member.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar el socio");
        }
    }

    @Override
    public void deleteMember(long id) throws Exception {
        String query = "DELETE FROM MEMBER WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar el socio");
        }
    }
}
    

    