package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ArticleDAO;
import model.NavigationDAO;
import model.NavigationMetaDataDAO;
import model.ReadingScrollDAO;
import model.RunningNewsAppsDAO;

public class DBUMTransactions {

	private static DBConnect dbConnect = null;

	/*
	 * Retrieves the NavigationalMetaData from the DB
	 */
	public ArrayList<NavigationMetaDataDAO> getNavigationalData(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<NavigationMetaDataDAO> arrNavigationMetaData = new ArrayList<NavigationMetaDataDAO>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String retrieveNavigationMetaData = "{call retrieveNavigationMetaData(?)}";

		try {

			cs = con.prepareCall(retrieveNavigationMetaData);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				NavigationMetaDataDAO navMetaData = new NavigationMetaDataDAO();

				navMetaData.setNavigationMetaDataID(rs
						.getLong("navigation_metadata_id"));
				navMetaData.setUserID(rs.getLong("user_id"));
				navMetaData.setUserSession(rs.getString("user_session"));
				navMetaData.setCategoryName(rs.getString("categoryName"));
				navMetaData.setSwipeDirection(rs.getString("swipeDirection"));
				navMetaData.setItemPosition(rs.getInt("itemPosition"));
				navMetaData.setDateAdded(rs.getTimestamp("dateTime"));

				arrNavigationMetaData.add(navMetaData);
			}

			return arrNavigationMetaData;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}

	/*
	 * Retrieves the Navigation from the DB
	 */
	public ArrayList<NavigationDAO> getNavigation(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<NavigationDAO> arrNavigation = new ArrayList<NavigationDAO>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String retrieveNavigation = "{call retrieveNavigation(?)}";

		try {

			cs = con.prepareCall(retrieveNavigation);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				NavigationDAO nav = new NavigationDAO();

				nav.setNavigationID(rs.getLong("navigation_id"));
				nav.setUserID(rs.getLong("user_id"));
				nav.setNavigationSession(rs.getString("navigation_session"));
				nav.setCategoryName(rs.getString("category_name"));
				nav.setPosition(rs.getInt("position"));
				nav.setOrderID(rs.getInt("order_id"));
				nav.setDateAdded(rs.getTimestamp("date_added"));
				
				arrNavigation.add(nav);
			}

			return arrNavigation;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}

	/*
	 * Retrieves the Reading from the DB
	 */
	public ArrayList<ArticleDAO> getReading(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<ArticleDAO> arrReading = new ArrayList<ArticleDAO>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String retrieveReading = "{call retrieveReading(?)}";

		try {

			cs = con.prepareCall(retrieveReading);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				ArticleDAO reading = new ArticleDAO();
				
				reading.setReadingID(rs.getLong("reading_id"));
				reading.setUserID(rs.getLong("user_id"));
				reading.setReadingSession(rs.getString("reading_session"));
				reading.setArticleName(rs.getString("article_name"));
				reading.setArticleID(rs.getLong("article_url"));
				reading.setReadingDuration(rs.getDouble("reading_duration"));
				reading.setIsScrollUsed(rs.getInt("isScrollUsed"));
				reading.setNumberOfWords(rs.getInt("numberOfWords"));
				reading.setIsScrollReachedEnd(rs.getInt("isRead_wholeArticle"));
				reading.setDateAdded(rs.getTimestamp("date_added"));
				
				arrReading.add(reading);
			}

			return arrReading;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}

	/*
	 * Retrieves the ReadingScroll from the DB
	 */
	public ArrayList<ReadingScrollDAO> getReadingScroll(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<ReadingScrollDAO> arrReadingScroll = new ArrayList<ReadingScrollDAO>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String retrieveReadingScroll = "{call retrieveReadingScroll(?)}";

		try {

			cs = con.prepareCall(retrieveReadingScroll);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				ReadingScrollDAO readingScroll = new ReadingScrollDAO();
				
				readingScroll.setReadingScrollID(rs.getLong("reading_scroll_id"));
				readingScroll.setUserID(rs.getLong("user_id"));
				readingScroll.setReadingSession(rs.getString("reading_session"));
				readingScroll.setArticleID(rs.getLong("article_id"));
				readingScroll.setScrollRange(rs.getInt("scroll_range"));
				readingScroll.setScrollExtent(rs.getInt("scroll_extent"));
				readingScroll.setScrollOffset(rs.getInt("scroll_offset"));
				readingScroll.setDateTime(rs.getTimestamp("date_time"));
				readingScroll.setDateAdded(rs.getTimestamp("date_added"));
				
				arrReadingScroll.add(readingScroll);
			}

			return arrReadingScroll;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}

	/*
	 * Retrieves the RunningNewsApps from the DB
	 */
	public ArrayList<RunningNewsAppsDAO> getRunningNewsApps(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<RunningNewsAppsDAO> arrRunningNewsApps = new ArrayList<RunningNewsAppsDAO>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String retrieveRunningNewsApps = "{call retrieveRunningNewsApps(?)}";

		try {

			cs = con.prepareCall(retrieveRunningNewsApps);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				RunningNewsAppsDAO runningNewsApps = new RunningNewsAppsDAO();
				
				runningNewsApps.setRunningNewsAppsID(rs.getLong("runningnewsapps_id"));
				runningNewsApps.setUserID(rs.getLong("user_id"));
				runningNewsApps.setUserSession(rs.getString("user_session"));
				runningNewsApps.setAppName(rs.getString("app_name"));
				runningNewsApps.setPackageName(rs.getString("package_name"));
				runningNewsApps.setCategoryName(rs.getString("category_name"));
				runningNewsApps.setLat(rs.getDouble("lat"));
				runningNewsApps.setLon(rs.getDouble("lon"));
				runningNewsApps.setStartTime(rs.getTimestamp("start_time"));
				runningNewsApps.setDateAdded(rs.getTimestamp("date_added"));
				
				arrRunningNewsApps.add(runningNewsApps);
			}

			return arrRunningNewsApps;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}
	
}
