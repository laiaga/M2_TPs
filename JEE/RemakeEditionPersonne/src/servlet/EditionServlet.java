package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class EditionServlet
 */
@WebServlet("/EditionServlet")
public class EditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int CURRENT_ID = 0;
       

    public EditionServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Person person = (Person) request.getSession().getAttribute("person");
		
		if (person == null) {
			person = new Person();
		}
		
		person.setId(CURRENT_ID);
		person.setName(request.getParameter("name"));
		person.setSurname(request.getParameter("surname"));
		person.setBirthdate(request.getParameter("birthdate"));
		person.setEmail(request.getParameter("email"));
		
		CURRENT_ID++;
				
		request.getRequestDispatcher("/person.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
