package appp.Dao;

import app.Dao.Interfaces.GuestDao;
import app.Dto.GuestDto;
import app.Model.Guest;
import app.config.MYSQLConnection;
import app.helpers.Helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GuestDaoImplementation implements GuestDao {
    
       @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        Guest guest = Helper.parse(guestDto);
        String query = "INSERT INTO GUEST (USER_ID, MEMBER_ID, IS_ACTIVE) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, guest.getId());
            preparedStatement.setLong(2, guest.getId());
           
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al crear el invitado");
        }
    }

    @Override
    public GuestDto findGuestById(long id) throws Exception {
        String query = "SELECT * FROM GUEST WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Guest guest = new Guest();
                guest.setId(resultSet.getLong("ID"));
                guest.setUserId(resultSet.getLong("USER_ID"));
                guest.setId(resultSet.getLong("MEMBER_ID"));
                return Helper.parse(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al encontrar el invitado");
        }
        return null;
    }

    @Override
    public void updateGuest(GuestDto guestDto) throws Exception {
        Guest guest = Helper.parse(guestDto);
        String query = "UPDATE GUEST SET USER_ID = ?, MEMBER_ID = ?, IS_ACTIVE = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, guest.getUserId());
            preparedStatement.setLong(2, guest.getId());
          
            preparedStatement.setLong(4, guest.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar el invitado");
        }
    }

    @Override
    public void deleteGuest(long id) throws Exception {
        String query = "DELETE FROM GUEST WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar el invitado");
        }
    }
}
