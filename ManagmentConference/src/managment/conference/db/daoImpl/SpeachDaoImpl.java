package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.classes.DBProperties;
import manegment.conference.classes.Speach;
import menegment.conference.db.dao.SpeachDao;

public class SpeachDaoImpl implements SpeachDao{
	private DBProperties dbproperties = new DBProperties();
	private List<Speach> speaches = new ArrayList<>();
	private String query;

	@Override
	public List<Speach> getAllSpeaches() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM speach";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		speaches.clear();
		while (rs.next()) {
			speaches.add(new Speach(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("interval"), 
					rs.getString("login")));
		}
		dbproperties.closeDB();
		return speaches;
	}
	/*@Override
	public List<Speach> getNameOfSpeaches() throws ClassNotFoundException, SQLException {
		query = "SELECT nameSpeach FROM speach";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		speaches.clear();
		while (rs.next()) {
			speaches.add();
		}
		dbproperties.closeDB();
		return speaches;
	}
	*/

	@Override
	public Speach checkSpeach(Speach speach) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM speach WHERE nameSpeach=? AND time=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		Speach u = null;
		if(rs.next()) {
			u = new Speach(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("interval"), 
					rs.getString("login"));
		}
		dbproperties.closeDB();
		return u;
	}

	@Override
	public void addSpeach(Speach speach) throws ClassNotFoundException, SQLException {
		query = "INSERT INTO speach (nameSpeach, time, interval, login) VALUES (?, ?, ?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParametersToSpeach(speach.getNameSpeach(), speach.getTime(), speach.getInterval(), speach.getLogin());
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void removeSpeach(Speach speach) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSpeach(Speach speach) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkSpeachNameTime(String nameSpeach, String time, String interval, String login) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM conference WHERE nameSpeach=? OR time=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setCheckParametersForSpeach(nameSpeach, time);
		ResultSet rs = dbproperties.createResult();
		return rs.next()?true:false;
	}

}