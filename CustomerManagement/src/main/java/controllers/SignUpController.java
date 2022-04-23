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
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
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
			request.getRequestDispatcher("views/Admin/SignUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = new Account(0, name, username, password, 1);
		int result = new AccountModel().create(account);
		if(result!=0) {
			HttpSession session = request.getSession();
			session.setAttribute("ss_user_token", account);
			response.sendRedirect(request.getContextPath()+"/Dashboard");
		}else {
			request.setAttribute("message", "Sorry something went wrong!");
			request.getRequestDispatcher("views/Admin/SignUp.jsp").forward(request, response);
		}
	}

}
