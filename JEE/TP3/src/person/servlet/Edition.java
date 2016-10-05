package person.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.bean.Person;
import person.business.PersonManager;

/**
 * Servlet implementation class Edition
 */
@WebServlet("/Edition")
public class Edition extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	private PersonManager manager;
	
    public Edition() {
        super();
        manager = new PersonManager();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object tmp = request.getSession().getAttribute("person");
		Person person = null;
		Person oldPerson = new Person();
		if (tmp instanceof Person) {
			person = (Person) tmp;
		} else {
			person = new Person();
		}
		
		if (request.getParameter("id") != null) {
			person.setId(Integer.parseInt(request.getParameter("id")));
		}
		
		oldPerson.setId(person.getId());
		oldPerson.setName(person.getName());
		oldPerson.setSurname(person.getSurname());
		oldPerson.setEmail(person.getEmail());
		oldPerson.setBirthdate(person.getBirthdate());
		person.setName(request.getParameter("name"));
		person.setSurname(request.getParameter("surname"));
		person.setEmail(request.getParameter("email"));
		person.setBirthdate(request.getParameter("birthdate"));
		
		if (!manager.check(person)) {
			resetPerson(person, oldPerson);
		}
		
		// Appeler une page JSP depuis une servlet
		request.getRequestDispatcher("../../WebContent/person.jsp").forward(request, response);
	}
	
	private void resetPerson(Person person, Person oldPerson) {
		person.setId(oldPerson.getId());
		person.setName(oldPerson.getName());
		person.setSurname(oldPerson.getSurname());
		person.setEmail(oldPerson.getEmail());
		person.setBirthdate(oldPerson.getBirthdate());
	}
}
