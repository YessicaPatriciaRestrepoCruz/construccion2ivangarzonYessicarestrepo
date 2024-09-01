
package app.Dao.Interfaces;
import app.Dto.PersonDto;

public interface PersonDao {
	  
   public void createPerson(PersonDto personDto) throws Exception;
   public PersonDto findPersonById(long id) throws Exception;
   public void updatePerson(PersonDto personDto) throws Exception;
   public void deletePerson(long id) throws Exception;
   public boolean existsByDocument (long Id) throws Exception;
}