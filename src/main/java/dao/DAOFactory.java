package dao;

import dao.implementation.*;
import dao.interfaces.*;

public class DAOFactory {
	private static IAdminCenterDao 	adminCenterDao = new AdminCenterDaoImp();
	private static IAppointmentDao appointmentDao = new AppointmentDaoImp();
	private static IAnalysisDao analysisDao = new AnalysisDaoImp();
	private static IBagDao bagDao = new BagDaoImp();
	private static ICenterDao centerDao = new CenterDaoImp();
	private static IDonorDao donorDao = new DonorDaoImp();
	private static IStockDao stockDao = new StockDaoImp();
	private static IUserDao userDao = new UserDaoImp();
	
	
	private DAOFactory() {
		/*Rien a faire*/
	}
	
	
	public static IAdminCenterDao getAdminCenterDao() {
		return adminCenterDao;
	}
	public static IAppointmentDao getAppointmentDao() {
		return appointmentDao;
	}
	
	public static IAnalysisDao getAnalysisDao() {
		return analysisDao;
	}
	
	public static IBagDao getBagDao() {
		return bagDao;
	}
	
	public static ICenterDao getCenterDao () {
		return centerDao;
	}
	
	public static IDonorDao getDonorDao () {
		return donorDao;
	}
	
	public static IStockDao getStockDao () {
		return stockDao;
	}
	
	public static IUserDao getUserDao () {
		return userDao;
	}
}
