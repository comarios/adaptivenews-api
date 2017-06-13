package model;

import java.sql.Timestamp;

public class ArticleDAO {

	long readingID;
	long userID;
	String readingSession;
	String articleName;
	long articleID;
	double readingDuration;
	int isScrollUsed;
	int numberOfWords;
	int isScrollReachedEnd;
	Timestamp dateAdded;

	public long getReadingID() {
		return readingID;
	}

	public void setReadingID(long readingID) {
		this.readingID = readingID;
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

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public long getArticleID() {
		return articleID;
	}

	public void setArticleID(long articleID) {
		this.articleID = articleID;
	}

	public double getReadingDuration() {
		return readingDuration;
	}

	public void setReadingDuration(double readingDuration) {
		this.readingDuration = readingDuration;
	}

	public int getIsScrollUsed() {
		return isScrollUsed;
	}

	public void setIsScrollUsed(int isScrollUsed) {
		this.isScrollUsed = isScrollUsed;
	}

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public int getIsScrollReachedEnd() {
		return isScrollReachedEnd;
	}

	public void setIsScrollReachedEnd(int isScrollReachedEnd) {
		this.isScrollReachedEnd = isScrollReachedEnd;
	}

	public Timestamp getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Timestamp dateAdded) {
		this.dateAdded = dateAdded;
	}

}
