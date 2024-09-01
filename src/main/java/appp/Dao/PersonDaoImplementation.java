package appp.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.Dao.Interfaces.PersonDao;
import app.Dto.PersonDto;
import app.helpers.Helper;
import app.Model.Person;
import java.sql.SQLException;

public class PersonDaoImplementation implements PersonDao {

	 @Override
    public void createPerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
        String query = "INSERT INTO PERSON (DOCUMENT, NAME, PHONE_NUMBER) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, person.getDocument());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setLong(3, person.getPhoneNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al crear la persona");
        }
    }

    @Override
    public PersonDto findPersonById(long id) throws Exception {
        String query = "SELECT * FROM PERSON WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("ID"));
                person.setDocument(resultSet.getLong("DOCUMENT"));
                person.setName(resultSet.getString("NAME"));
                person.setPhoneNumber(resultSet.getLong("PHONE_NUMBER"));
                return Helper.parse(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al encontrar la persona");
        }
        return null;
    }
    
     @Override
    public boolean existsByDocument (long id) throws Exception {
        String query = "SELECT * FROM PERSON WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
        preparedStatement.setLong(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next();  
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("Error al encontrar la persona");
    }
    }


    @Override
    public void updatePerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
        String query = "UPDATE PERSON SET DOCUMENT = ?, NAME = ?, PHONE_NUMBER = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, person.getDocument());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setLong(3, person.getPhoneNumber());
            preparedStatement.setLong(4, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar la persona");
        }
    }

    @Override
    public void deletePerson(long id) throws Exception {
        String query = "DELETE FROM PERSON WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar la persona");
}
    }
}