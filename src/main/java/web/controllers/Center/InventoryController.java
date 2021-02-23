package web.controllers.Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.entities.Stock;
import dao.implementation.StockDaoImp;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/inventory","/center/statistics"})
public class InventoryController extends ServletController {
	
		StockDaoImp stockDao;
		Stock stock;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center");
		
		stockDao = new StockDaoImp();
		router.get("/inventory", "index" );
		router.get("/statistics", "index2" );
		router.post("@save", () ->  this.save(req.getParameter("id"), req.getParameter("quantity")) );
		
	}
	
	public void index() {
		req.setAttribute("stocksList", stockDao.findAll() );
		view("admin-center/insights/inventory");
	}
	
	public void index2() {
		req.setAttribute("stocksList", stockDao.findAll() );
		view("admin-center/insights/statistics");
	}
	
	public void save(String id, String quantity) {
		stock =  stockDao.find( Long.parseLong( id ));
		stock.setQuantity( Long.parseLong( quantity ));
		stock.save();
		redirectPrevious();
	}
}
