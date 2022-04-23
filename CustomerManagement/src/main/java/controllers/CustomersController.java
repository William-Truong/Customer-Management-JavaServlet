package controllers;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class CustomersController
 */
@WebServlet("/Customers")
public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerModel model;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public CustomersController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	this.model = new CustomerModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Customer> customers = new ArrayList<Customer>();
		if(keyword != null && keyword != "") {
			customers = this.model.find(keyword);
		}else {
			customers = this.model.all();
		}
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("views/Customer/List.jsp").forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
