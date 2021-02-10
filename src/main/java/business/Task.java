package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DbConnection;

public class Task {
	private final static Connection connection = DbConnection.getConnection();
	public Task(){
		
	}
	
	public void missedAppointemnt(long centerId) {
		execute("UPDATE appointment SET state='Missed' WHERE id IN "
					+ "(SELECT id FROM appointment WHERE ( ( (CURRENT_DATE() - time) > 0 ) AND state ='Arrived' AND CenterId = ?) )"
				, centerId);
	}
	
	public void arrivedAppointemnt(long centerId) {
		execute("UPDATE appointment SET state='Arrived' WHERE id IN "
				+ "(SELECT id FROM appointment WHERE ( time = CURRENT_DATE() AND state ='Booked' AND CenterId = ?) )"
			, centerId);
	}
	
	public void expiredAppointemnt(long centerId) {
		execute("UPDATE appointment SET state='Expired' WHERE id IN "
				+ "(SELECT id FROM appointment WHERE ( (CURRENT_DATE() - createdAt  ) > 7 ) AND state ='Pending' AND CenterId = ?)"
			, centerId);
	}
	
	private boolean execute(String query, long parm) {
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setLong(1, parm);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
