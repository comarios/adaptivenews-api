package umfactors;

import java.sql.Timestamp;

public class Frequency {

	long userID;
	int distinctReadingSessions;
	Timestamp dateAdded;
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public int getDistinctReadingSessions() {
		return distinctReadingSessions;
	}
	public void setDistinctReadingSessions(int distinctReadingSessions) {
		this.distinctReadingSessions = distinctReadingSessions;
	}
	public Timestamp getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	} 
}
