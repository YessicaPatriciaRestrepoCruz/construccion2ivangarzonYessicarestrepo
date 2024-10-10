
package app.Controller.Validator;

public class PersonValidator extends CommonsValidator {
    
  
    public void validateName(String name) throws Exception {
        isValidString("Name", name);
      
    }
    
   
    public void validatePhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new Exception("Phone number must be exactly 10 digits.");
        }
    }
    
  
    public long validateId(String id) throws Exception {
        return isValidLong("ID", id);
        
    }
    
   
    public int validateAge(String age) throws Exception {
        int ageValue = isValidInteger("Age", age);
        if (ageValue < 0) {
            throw new Exception("Age cannot be negative.");
        }
        return ageValue;
    }
}

