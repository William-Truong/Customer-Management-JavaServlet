package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Account;
import models.AccountModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("ss_user_token");
		if(account != null) {
			response.sendRedirect(request.getContextPath()+"/Dashboard");
		}else
			request.getRequestDispatcher("views/Admin/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = String.valueOf(request.getParameter("username"));
		String password = String.valueOf(request.getParameter("password"));
		HttpSession session = request.getSession(true);
		if(username != null && username != "" && password != null && password != "") {
			Account account = new AccountModel().get(username, password);
			if(account!=null) {				
				session.setAttribute("ss_user_token", account);
				response.sendRedirect(request.getContextPath()+"/Dashboard");
			}
			else {
				String message = "Your username or password incorec!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("views/Admin/Login.jsp").forward(request, response);
			}
		}
	}

}
