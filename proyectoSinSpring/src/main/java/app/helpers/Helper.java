package app.helpers;
    
import app.Dto.MemberDto;
import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.Model.Member;
import app.Model.Person;
import app.Model.User;
import app.Dto.GuestDto;
import app.Model.Guest;
import app.Model.Invoice;
import app.Dto.InvoiceDto;
public abstract class Helper {

	
	public static Person parse(PersonDto personDto) {
		Person person = new Person();
		person.setId(personDto.getId());
		person.setDocument(personDto.getDocument()); 
		
		person.setName(personDto.getName());
		return person;
	}
        
        public static PersonDto parse(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setId(person.getId());
		personDto.setDocument(person.getDocument()); 
		
		personDto.setName(person.getName());
                personDto.setPhoneNumber(person.getPhoneNumber());
		return personDto;
	}
	
	public static UserDto parse(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		userDto.setUserName(user.getUsername());
		return userDto;
	}
	
	public static User parse(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setUsername(userDto.getUserName());
		return user;
	}
        
    public static Member parse(MemberDto memberDto) {
                Member member = new Member();
                member.setId(memberDto.getId());
   
                member.setAmount(memberDto.getAmount());
                member.setType(memberDto.getType());
                member.setAffiliationDate(memberDto.getAffiliationDate());
                return member;
}
    public static MemberDto parse(Member member) {
                MemberDto memberDto = new MemberDto();
                memberDto.setId(member.getId());
                memberDto.setAmount(member.getAmount());
                memberDto.setSubscriptionType(member.getType());
                memberDto.setAffiliationDate(member.getAffiliationDate());
                return memberDto;
}
    
    public static GuestDto parse(Guest guest) {
                GuestDto guestDto = new GuestDto();
                guestDto.setId(guest.getId());
                guestDto.setUserId(guest.getUserId());
                guestDto.setMemberId(guest.getMemberId());
                    
                return guestDto;                
}
    
    public static Guest parse(GuestDto guestDto) {
                Guest guest = new Guest();
                guest.setId(guestDto.getId());
                guest.setUserId(guestDto.getUserId());
                guest.setMemberId(guestDto.getMemberId());
                guest.setInvitationStatus(guestDto.getInvitationStatus());
                    
                return guest;
    }
    
    public static Invoice parse(InvoiceDto invoiceDto) {
		Invoice invoice = new Invoice();
		invoice.setPersonId(invoiceDto.getPersonId());
                invoice.setMemberId(invoiceDto.getMemberId());
		invoice.setCreationDate(invoiceDto.getCreationDate());
                invoice.setStatus(invoice.getStatus());
                invoice.setAmount(invoice.getAmount());
		
		return invoice;
	}
    
     public static InvoiceDto parse(Invoice invoice) {
                InvoiceDto invoiceDto = new InvoiceDto();
                invoiceDto.setPersonId(invoice.getPersonId());
                invoiceDto.setMemberId(invoice.getMemberId());
                invoiceDto.setCreationDate(invoice.getCreationDate());
                invoiceDto.setStatus(invoice.getStatus());
                invoiceDto.setAmount(invoice.getAmount());
                
                return invoiceDto; 
}
}

