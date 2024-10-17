package learning2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/UserLoginServlet")
public class UserLoginFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse res = (HttpServletResponse) response;
		String userEmail = request.getParameter("userEmail");
		
		 String emailRegex = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
	        if (userEmail == null || !Pattern.matches(emailRegex, userEmail)) {
	        	PrintWriter out = response.getWriter();
	        	res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        	out.write("not a valid mail id");
	        }else {
	        	chain.doFilter(req, response);
	        }
		
	}

}
