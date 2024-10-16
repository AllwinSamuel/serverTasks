package learning2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validEmail = "samuel@gmail.com";
		String validPassword = "@123456";
		
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		PrintWriter out = response.getWriter();
		
		if(userEmail.equals(validEmail)) {
            if(userPassword.equals(validPassword)) {
            	out.write("valid user");
            }else {
            	out.write("wrong password");
            }
		}
		else {
			out.write("user not foumd");
		}
	}

}
