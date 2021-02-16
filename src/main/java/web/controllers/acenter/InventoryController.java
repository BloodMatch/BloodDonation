package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.entities.Stock;
import dao.implementation.StockDaoImp;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/inventory/*"})
public class InventoryController extends ServletController {
	
		StockDaoImp stockDao;
		Stock stock;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/inventory");
		
		stockDao = new StockDaoImp();
		router.get("", () ->  this.show() );
		router.post("@save", () ->  this.save(req.getParameter("id"), req.getParameter("quantity")) );
		
	}
	
	public void show() {
		req.setAttribute("stocksList", stockDao.findAll() );
		view("admin-center/inventory");
	}
	
	public void save(String id, String quantity) {
		stock =  stockDao.find( Long.parseLong( id ));
		stock.setQuantity( Long.parseLong( quantity ));
		stock.save();
		redirectPrevious();
	}
}
