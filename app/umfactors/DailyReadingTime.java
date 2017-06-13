package umfactors;

import java.sql.Timestamp;

public class DailyReadingTime {

	long userID;
	double dailyReadingTime;
	Timestamp dateAdded;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public double getDailyReadingTime() {
		return dailyReadingTime;
	}

	public void setDailyReadingTime(double dailyReadingTime) {
		this.dailyReadingTime = dailyReadingTime;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}
}
