package person.business;

import java.util.Collection;
import java.util.Map;


import person.bean.Person;

public class PersonManager {
	final private Map<Integer, Person> persons;

	public PersonManager() {
		throw new IllegalStateException("Not yet implemented");
	}

	public Collection<Person> findAll() {
		throw new IllegalStateException("Not yet implemented");
	}

	public void save(Person p) throws Exception {
		throw new IllegalStateException("Not yet implemented");
	}

	public boolean check(Person p) {
		boolean res = true;
		
		res &= p.getName() != null;
		
		res &= isValidEmailAddress(p.getEmail());
		
		return res;
	}
	
	private static boolean isValidEmailAddress(String email) {
		   boolean result = true;
//		   try {
//		      InternetAddress emailAddr = new InternetAddress(email);
//		      emailAddr.validate();
//		   } catch (AddressException ex) {
//		      result = false;
//		   }
		   return result;
		}
}