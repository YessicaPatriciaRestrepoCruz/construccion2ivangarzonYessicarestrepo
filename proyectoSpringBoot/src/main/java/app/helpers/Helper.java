package app.helpers;
    
import app.Dto.MemberDto;
import app.Dto.PersonDto;
import app.Dto.UserDto;
import app.Model.Member;
import app.Model.Person;
import app.Model.User;
import app.Dto.GuestDto;
import app.Dto.InvoiceDetailDto;
import app.Model.Guest;
import app.Model.Invoice;
import app.Dto.InvoiceDto;
import app.Model.InvoiceDetail;
import java.util.List;
import java.util.stream.Collectors;
public abstract class Helper {

    
    public static List<PersonDto> parseToPersonDtoList(List<Person> persons) {
    return persons.stream()
            .map(Helper::parse)
            .collect(Collectors.toList());
}
	
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
                member.setUserId( memberDto.getUserId() );
                member.setAmount(memberDto.getAmount());
                member.setType(memberDto.getType());
                member.setAffiliationDate(memberDto.getAffiliationDate());
                return member;
}
    public static MemberDto parse(Member member) {
                MemberDto memberDto = new MemberDto();
                memberDto.setId(member.getId());
                memberDto.setAmount(member.getAmount());
                memberDto.setType(member.getType());
                memberDto.setAffiliationDate(member.getAffiliationDate());
                return memberDto;
}
 //error al implementar en model   
    public static GuestDto parse(Guest guest) {
                GuestDto guestDto = new GuestDto();
                guestDto.setId(guest.getId());
                guestDto.setUserId(guest.getUserId());
                guestDto.setMemberId(guest.getMemberId());
                    
                return guestDto;                
}
    
    public static Guest parse(GuestDto GuestDto) {
                Guest guest = new Guest();
                guest.setId(GuestDto.getId());
                 guest.setUserId( GuestDto.getUserId() );
                guest.setMemberId( GuestDto.getMemberId() );
                guest.setStatus( GuestDto.getStatus());
                    
                return guest;
    }
    
    public static Invoice parse(InvoiceDto invoiceDto) {
		Invoice invoice = new Invoice();
		invoice.setPersonId(parse(invoiceDto.getPersonId()));
                invoice.setMemberId(parse(invoiceDto.getMemberId()));
		invoice.setCreationDate(invoiceDto.getCreationDate());
                invoice.setStatus(invoice.getStatus());
                invoice.setAmount(invoice.getAmount());
		
		return invoice;
	}
    
     public static InvoiceDto parse(Invoice invoice) {
                InvoiceDto invoiceDto = new InvoiceDto();
                invoiceDto.setPersonId(parse(invoice.getPersonId()));
                invoiceDto.setMemberId(parse(invoice.getMemberId()));
                invoiceDto.setCreationDate(invoice.getCreationDate());
                invoiceDto.setStatus(invoice.getStatus());  
                invoiceDto.setAmount(invoice.getAmount());
                
                return invoiceDto; 
}
     
      public static InvoiceDetail parse(InvoiceDetailDto invoiceDetailDto) {
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		//invoiceDetail.setInvoiceId(invoiceDetailDto.getInvoiceId());// revisar problema con la relacion 
                invoiceDetail.setAmount(invoiceDetail.getAmount());
                invoiceDetail.setDescription(invoiceDetail.getDescription());
                invoiceDetail.setItem(invoiceDetail.getItem());

		
		return invoiceDetail;
	}
    
     public static InvoiceDetailDto parse( InvoiceDetail invoiceDetail ) {
             InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
    
    if (invoiceDetail.getInvoice() != null) {
        invoiceDetailDto.setInvoiceId(invoiceDetail.getInvoice().getId());
    } else {
        throw new IllegalArgumentException("El detalle de la factura no tiene un encabezado de factura asociado.");
    }
    
    invoiceDetailDto.setAmount(invoiceDetail.getAmount());
    invoiceDetailDto.setDescription(invoiceDetail.getDescription());
    invoiceDetailDto.setItem(invoiceDetail.getItem()); 
    
    return invoiceDetailDto;  
}
     
     
     public static List<GuestDto> parseGuests(List<Guest> guests) {
        return guests.stream()
                     .map(Helper::parse)
                     .collect(Collectors.toList());
    }

    public static List<InvoiceDto> parseInvoices(List<Invoice> invoices) {
       
        return invoices.stream()
                     .map(Helper::parse)
                     .collect(Collectors.toList());
    }
}

