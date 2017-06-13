package model;

import java.sql.Timestamp;

public class NavigationMetaDataDAO {

	long navigationMetaDataID;
	long userID;
	String userSession;
	String categoryName;
	String swipeDirection;
	int itemPosition;
	Timestamp dateAdded;
	public long getNavigationMetaDataID() {
		return navigationMetaDataID;
	}
	public void setNavigationMetaDataID(long navigationMetaDataID) {
		this.navigationMetaDataID = navigationMetaDataID;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserSession() {
		return userSession;
	}
	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSwipeDirection() {
		return swipeDirection;
	}
	public void setSwipeDirection(String swipeDirection) {
		this.swipeDirection = swipeDirection;
	}
	public int getItemPosition() {
		return itemPosition;
	}
	public void setItemPosition(int itemPosition) {
		this.itemPosition = itemPosition;
	}
	public Timestamp getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
