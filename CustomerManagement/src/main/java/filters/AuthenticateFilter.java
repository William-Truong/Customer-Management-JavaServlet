package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Account;
@WebFilter(filterName = "Authenticate",urlPatterns = {"/*"})
public class AuthenticateFilter implements Filter{
	private HttpSession session;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String loginURL = req.getContextPath()+"/Login";
		String signupURL = req.getContextPath()+"/SignUp";
		String logoutURL = req.getContextPath()+"/SignUp";
		if(!req.getRequestURI().equals(loginURL) && !req.getRequestURI().equals(signupURL) && !req.getRequestURI().equals(logoutURL)) {
			session = req.getSession();
			Account account = (Account) session.getAttribute("ss_user_token");
			if(account != null) 
				chain.doFilter(request, response);
			else
				request.getRequestDispatcher("views/Admin/Login.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
