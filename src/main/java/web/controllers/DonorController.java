package web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.entities.Donor;
import dao.implementation.DonorDaoImp;
import dao.interfaces.IDonorDao;
import web.models.DonorModel;

/**
 * Servlet implementation class UserController
 */

public class DonorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DonorDaoImp donorDao;
    
	@Override
	public void init() throws ServletException {
		super.init();
		donorDao = new DonorDaoImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonorModel donorModel = new DonorModel();
/*		donorModel.setDonors( (List<Donor>)(List<?>) donorDao.findAll() );
		request.setAttribute("donors", donorModel.getDonors());*/
		
		request.setAttribute("donors", "EE525252"+donorDao.find("EE525252"));
				
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
