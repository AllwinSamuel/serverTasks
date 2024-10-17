package learning2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validEmail = "samuel@gmail.com";
		String validPassword = "@123Samuel";
		
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		if (userEmail.equals(validEmail)) {
			if (userPassword.equals(validPassword)) {
				// Set the response status code to 200 (OK)
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().write("valid user");
			} else {
				// Set the response status code to 401 (Unauthorized)
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write("Invalid password");
			}
		} else {
			// Set the response status code to 404 (Not Found)
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("User not found");
		}
	}
}
