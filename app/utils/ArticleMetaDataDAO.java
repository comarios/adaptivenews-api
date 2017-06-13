package utils;

import java.io.Serializable;

public class ArticleMetaDataDAO implements Serializable {

	private long userID;
	private String userSession;
	private long articleID;
	private int scrollRange;
	private int scrollExtent;
	private int scrollOffset;
	private String dateTime;

	public ArticleMetaDataDAO() {
	}

	public ArticleMetaDataDAO(long _userID, String _userSession,
			long _articleID, int _scrollRange, int _scrollExtent,
			int _scrollOffset, String _dateTime) {

		userID = _userID;
		userSession = _userSession;
		articleID = _articleID;
		scrollRange = _scrollRange;
		scrollExtent = _scrollExtent;
		scrollOffset = _scrollOffset;
		dateTime = _dateTime;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
