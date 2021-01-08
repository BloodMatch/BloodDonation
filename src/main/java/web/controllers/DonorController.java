package web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.entities.*;
import dao.implementation.*;
import dao.interfaces.*;
import web.models.*;

/**
 * Servlet implementation class UserController
 */

public class DonorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDao<User> dao;
    
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new UserDaoImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//donorModel.setDonors( (List<Donor>)(List<?>) dao.findAll() );
		
		
		request.setAttribute("donors", dao.findAll() );
				
		request.getRequestDispatcher("TEST/donors.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
