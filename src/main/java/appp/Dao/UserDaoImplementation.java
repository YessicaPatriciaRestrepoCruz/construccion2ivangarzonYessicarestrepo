package appp.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import app.config.MYSQLConnection;
import app.Dao.Interfaces.UserDao;
import app.Dto.UserDto;
import app.helpers.Helper;
import app.Model.User;
import java.sql.SQLException;

public class UserDaoImplementation implements UserDao {

	@Override
    public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        String query = "INSERT INTO USER (USERNAME, PASSWORD, ROLE) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al crear el usuario");
        }
    }

    @Override
    public UserDto findUserById(long id) throws Exception {
        String query = "SELECT * FROM USER WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setRole(resultSet.getString("ROLE"));
                return Helper.parse(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al encontrar el usuario");
        }
        return null;
    }

    @Override
    public void updateUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        String query = "UPDATE USER SET USERNAME = ?, PASSWORD = ?, ROLE = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar el usuario");
        }
    }

    @Override
    public void deleteUser(long id) throws Exception {
        String query = "DELETE FROM USER WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar el usuario");
        }
    }
}


