package controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import models.CustomerModel;

/**
 * Servlet implementation class EditCustomerController
 */
@WebServlet("/EditCustomer")
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerModel model;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.model = new CustomerModel();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer customer = this.model.get(id);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("views/Customer/Edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date updated_date = Date.valueOf(LocalDate.now());
		Customer customer = new Customer(id, name, email, null, updated_date);
		int result = this.model.edit(customer);
		if(result!=0) {
			response.sendRedirect(request.getContextPath()+"/Customers");
		}else {
			request.setAttribute("message", "Sorry something went wrong!");
			request.getRequestDispatcher("views/Customer/Edit.jsp").forward(request, response);
		}
	}

}
