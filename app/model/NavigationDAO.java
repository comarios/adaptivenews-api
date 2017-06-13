package model;

import java.sql.Timestamp;

public class NavigationDAO {

	long navigationID;
	long userID;
	String navigationSession;
	String categoryName;
	int position;
	int orderID;
	Timestamp dateAdded;

	public long getNavigationID() {
		return navigationID;
	}

	public void setNavigationID(long navigationID) {
		this.navigationID = navigationID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getNavigationSession() {
		return navigationSession;
	}

	public void setNavigationSession(String navigationSession) {
		this.navigationSession = navigationSession;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

}
