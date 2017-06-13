package model;

import java.sql.Timestamp;

public class ReadingScrollDAO {

	long readingScrollID;
	long userID;
	String readingSession;
	long articleID;
	int scrollRange;
	int scrollExtent;
	int scrollOffset;
	Timestamp dateTime;
	Timestamp dateAdded;

	public long getReadingScrollID() {
		return readingScrollID;
	}

	public void setReadingScrollID(long readingScrollID) {
		this.readingScrollID = readingScrollID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getReadingSession() {
		return readingSession;
	}

	public void setReadingSession(String readingSession) {
		this.readingSession = readingSession;
	}

	public long getArticleID() {
		return articleID;
	}

	public void setArticleID(long articleID) {
		this.articleID = articleID;
	}

	public int getScrollRange() {
		return scrollRange;
	}

	public void setScrollRange(int scrollRange) {
		this.scrollRange = scrollRange;
	}

	public int getScrollExtent() {
		return scrollExtent;
	}

	public void setScrollExtent(int scrollExtent) {
		this.scrollExtent = scrollExtent;
	}

	public int getScrollOffset() {
		return scrollOffset;
	}

	public void setScrollOffset(int scrollOffset) {
		this.scrollOffset = scrollOffset;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

}
