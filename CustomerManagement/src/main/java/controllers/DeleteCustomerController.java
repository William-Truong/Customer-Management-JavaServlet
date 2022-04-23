package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import models.CustomerModel;

/**
 * Servlet implementation class DeleteCustomerController
 */
@WebServlet("/DeleteCustomer")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerModel model;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerController() {
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
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int result = this.model.delete(id);
		if(result!=0) {
			response.sendRedirect(request.getContextPath()+"/Customers");
		}else {
			request.setAttribute("message", "Sorry something went wrong!");
			List<Customer> customers = this.model.all();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("views/Customer/List.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
