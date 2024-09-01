package appp.Dao;

import app.Dao.Interfaces.InvoiceDao;
import app.Model.Invoice;
import app.config.MYSQLConnection;
import app.helpers.Helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import app.Dto.InvoiceDto;
    
public class InvoiceDaoImplementation implements InvoiceDao {
    

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
        String query = "INSERT INTO INVOICE (PERSON_ID, MEMBER_ID, CREATED_DATE, AMOUNT) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, invoice.getPersonId());
            preparedStatement.setLong(2, invoice.getMemberId());
            preparedStatement.setTimestamp(3, new Timestamp(invoice.getCreationDate().getTime()));
            preparedStatement.setDouble(4, invoice.getAmount());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al crear la factura");
        }
    }

    @Override
    public InvoiceDto findInvoiceById(long id) throws Exception {
        String query = "SELECT * FROM INVOICE WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setId(resultSet.getLong("ID"));
                invoice.setPersonId(resultSet.getLong("PERSON_ID"));
                invoice.setId(resultSet.getLong("MEMBER_ID"));
                invoice.setCreationDate(resultSet.getTimestamp("CREATED_DATE"));
                invoice.setAmount(resultSet.getDouble("AMOUNT"));
                return Helper.parse(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al encontrar la factura");
        }
        return null;
    }

    @Override
    public void updateInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
        String query = "UPDATE INVOICE SET PERSON_ID = ?, MEMBER_ID = ?, CREATED_DATE = ?, AMOUNT = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, invoice.getPersonId());
            preparedStatement.setLong(2, invoice.getMemberId());
            preparedStatement.setTimestamp(3, new Timestamp(invoice.getCreationDate().getTime()));
            preparedStatement.setDouble(4, invoice.getAmount());
            preparedStatement.setLong(5, invoice.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al actualizar la factura");
        }
    }

    @Override
    public void deleteInvoice(long id) throws Exception {
        String query = "DELETE FROM INVOICE WHERE ID = ?";
        try (PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al eliminar la factura");
        }
    }
}
