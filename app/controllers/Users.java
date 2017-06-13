package controllers;

import play.*;
import play.libs.*;
import play.mvc.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

import utils.ArticleMetaDataDAO;
import utils.DBConnect;
import views.html.*;
import java.util.Map;
import java.util.Date;

import oauth.signpost.http.HttpRequest;

import org.h2.store.Page;

/**
 * The `Users` class is responsible to handle any request associated with user.
 * 
 * @author marios
 * 
 */
public class Users extends Controller {

	private static DBConnect dbConnect = null;

	public static Result getUsers() {

		Connection con = DBConnect.getConnection();
		Result oops = null;
		ObjectNode result = Json.newObject();

		result.put("DB status", "connected");

		if (con == null)
			return oops = internalServerError("No DB connection");
		else
			return ok(result);
	}

	/**
	 * Checks whether the user is registered and can login
	 * 
	 * @return UserID
	 */
	public static Result login() {
		Result result = null;
		JsonNode json = request().body().asJson();

		if (json.size() == 0) {
			return result = internalServerError("Not valid json");
		} else if (json.findPath("email_address").textValue().isEmpty()
				|| json.findPath("password").textValue().isEmpty()) {
			return result = internalServerError("Json doesn't contain any values");
		} else {
			String email_address = json.findPath("email_address").textValue();
			String password = json.findPath("password").textValue();

			CallableStatement callableStatement = null;
			String loginUser = "{call loginUser(?,?,?)}";
			ObjectNode isAuth = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(loginUser);

				callableStatement.setString(1, email_address);
				callableStatement.setString(2, password);
				callableStatement
						.registerOutParameter(3, java.sql.Types.BIGINT);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				long userID = callableStatement.getLong(3);
				isAuth.put("UserID", userID + "");

				return ok(isAuth);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}
	}

	/**
	 * Adds new user in the database
	 * 
	 * @return UserID
	 */
	public static Result addUser() {

		Result result = null;
		JsonNode request = request().body().asJson();

		if (request.size() == 0) {
			return result = internalServerError("Not valid request");
		} else if (request.findPath("name").textValue().isEmpty()
				|| request.findPath("surname").textValue().isEmpty()
				|| request.findPath("email_address").textValue().isEmpty()
				|| request.findPath("password").textValue().isEmpty()
				|| request.findPath("gender").textValue().isEmpty()
				|| request.findPath("dob").textValue().isEmpty()
				|| request.findPath("q1_frequency").textValue().isEmpty()
				|| request.findPath("q2_readingtime").textValue().isEmpty()
				|| request.findPath("q3_browsingstrategy").textValue().isEmpty()
				|| request.findPath("q4_readingstyle").textValue().isEmpty()
				|| request.findPath("q5_location").textValue().isEmpty()){
			return result = internalServerError("Json doesn't contain any values");
		} else {
			String name = request.findPath("name").textValue();
			String surname = request.findPath("surname").textValue();
			String email_address = request.findPath("email_address")
					.textValue();
			String password = request.findPath("password").textValue();
			String dobAsString = request.findPath("dob").textValue();
			String gender = request.findPath("gender").textValue();

			Timestamp dob = null;

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss.SSS");
				Date parsedDate = dateFormat.parse(dobAsString);
				dob = new java.sql.Timestamp(parsedDate.getTime());
			} catch (Exception e) {

			}

			CallableStatement callableStatement = null;
			CallableStatement callableStatement_addUserSurveyResponse = null;
			String addUser = "{call addUser(?,?,?,?,?,?,?)}";
			String addUserResponse = "{call addUserSurveyResponse(?,?,?,?,?,?)}";
			ObjectNode userObj = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(addUser);

				callableStatement.setString(1, name);
				callableStatement.setString(2, surname);
				callableStatement.setString(3, email_address);
				callableStatement.setString(4, password);
				callableStatement.setString(5, gender);
				callableStatement.setTimestamp(6, dob);
				callableStatement
						.registerOutParameter(7, java.sql.Types.BIGINT);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				long userID = callableStatement.getLong(7);
				userObj.put("UserID", userID + "");

				
				String q1_frequency = request.findPath("q1_frequency").textValue();
				String q2_readingtime = request.findPath("q2_readingtime").textValue();
				String q3_browsingstrategy = request.findPath("q3_browsingstrategy").textValue();
				String q4_readingstyle = request.findPath("q4_readingstyle").textValue();
				String q5_location = request.findPath("q5_location").textValue();
				
				callableStatement_addUserSurveyResponse = con.prepareCall(addUserResponse);
				callableStatement_addUserSurveyResponse.setLong(1, userID);
				callableStatement_addUserSurveyResponse.setString(2, q1_frequency);
				callableStatement_addUserSurveyResponse.setString(3, q2_readingtime);
				callableStatement_addUserSurveyResponse.setString(4, q3_browsingstrategy);
				callableStatement_addUserSurveyResponse.setString(5, q4_readingstyle);
				callableStatement_addUserSurveyResponse.setString(6, q5_location);
				
				
				callableStatement_addUserSurveyResponse.executeUpdate();
				
				return ok(userObj);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}

	}

	/**
	 * Checks whether an email_address is unique and can be used during
	 * registration
	 * 
	 * @return Boolean, indicates if exists or not. True-Unique, False-Not
	 */
	public static Result isEmailUnique(String email_address) {

		Result result = null;

		JsonNode request = request().body().asJson();

		if (email_address.isEmpty()) {
			return result = internalServerError("Not valid request");
		} else {

			CallableStatement callableStatement = null;
			String isEmailUnique = "{call isEmailUnique(?,?)}";
			ObjectNode userObj = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(isEmailUnique);

				callableStatement.setString(1, email_address);

				callableStatement.registerOutParameter(2,
						java.sql.Types.BOOLEAN);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				boolean isEmailExist = callableStatement.getBoolean(2);
				userObj.put("Email Exists", isEmailExist + "");

				return ok(userObj);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}
	}

	/**
	 * Stores the reading behavior in the database
	 * 
	 * @return Bigint, The reading_behavior id
	 */
	public static Result storeReadingBehavior() {

		Result result = null;

		JsonNode request = request().body().asJson();

		System.out.println("HERE");
		if (request.size() == 0) {
			return result = internalServerError("Not valid request");
		} else if (request.findPath("userID").textValue().isEmpty()
				|| request.findPath("readingSession").textValue().isEmpty()
				|| request.findPath("articleName").textValue().isEmpty()
				|| request.findPath("articleUrl").textValue().isEmpty()
				|| request.findPath("readingDuration").textValue().isEmpty()
				|| request.findPath("isScrollUsed").textValue().isEmpty()
				|| request.findPath("numberOfWords").textValue().isEmpty()
				|| request.findPath("isReadWholeArticle").textValue().isEmpty()) {

			return result = internalServerError("Json doesn't contain any values");
		} else {

			long userID = request.findPath("userID").asLong();
			String readingSession = request.findPath("readingSession")
					.textValue();
			long articleID = request.findPath("articleID").asLong();
			String articleName = request.findPath("articleName").textValue();
			String articleUrl = request.findPath("articleUrl").textValue();
			double readingDuration = request.findPath("readingDuration")
					.asDouble();
			Boolean isScrollUsed = request.findPath("isScrollUsed").asBoolean();
			int numberOfWords = request.findPath("numberOfWords").asInt();
			Boolean isReadWholeArticle = request.findPath("isReadWholeArticle")
					.asBoolean();

			CallableStatement callableStatement = null;
			String storeReadingBehavior = "{call storeReadingBehavior(?,?,?,?,?,?,?,?,?,?)}";
			ObjectNode userObj = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(storeReadingBehavior);

				callableStatement.setLong(1, userID);
				callableStatement.setString(2, readingSession);
				callableStatement.setLong(3, articleID);
				callableStatement.setString(4, articleName);
				callableStatement.setString(5, articleUrl);
				callableStatement.setDouble(6, readingDuration);
				callableStatement.setBoolean(7, isScrollUsed);
				callableStatement.setInt(8, numberOfWords);
				callableStatement.setBoolean(9, isReadWholeArticle);
				callableStatement
						.registerOutParameter(10, java.sql.Types.BIGINT);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				long readingBehaviorID = callableStatement.getLong(10);
				userObj.put("readingBehaviorID", readingBehaviorID + "");

				return ok(userObj);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}
	}

	/**
	 * Stores the reading scroll in the database
	 * 
	 * @return Bigint, The reading_scroll id
	 */
	public static Result storeReadingScroll() {

		String request = request().body().asJson().toString();
		ObjectNode returnObj = Json.newObject();

		Gson gsonObj = new Gson();
		ArticleMetaDataDAO[] articles = gsonObj.fromJson(request,
				ArticleMetaDataDAO[].class);

		if (articles.length == 0) {
			return internalServerError("Json doesn't contain any values");
		} else {
			for (ArticleMetaDataDAO articleMetaDataDAO : articles) {

				long userID = articleMetaDataDAO.getUserID();
				String readingSession = articleMetaDataDAO.getUserSession();
				long articleID = articleMetaDataDAO.getArticleID();
				int scrollRange = articleMetaDataDAO.getScrollRange();
				int scrollExtent = articleMetaDataDAO.getScrollExtent();
				int scrollOffset = articleMetaDataDAO.getScrollOffset();
				String dateTimeAsString = articleMetaDataDAO.getDateTime();

				Timestamp dateTime = null;

				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyy-MM-dd hh:mm:ss.SSS");
					Date parsedDate = dateFormat.parse(dateTimeAsString);
					dateTime = new java.sql.Timestamp(parsedDate.getTime());
				} catch (Exception e) {
					return internalServerError(e.getMessage());
				}

				CallableStatement callableStatement = null;
				String storeReadingScroll = "{call storeReadingScroll(?,?,?,?,?,?,?,?)}";

				Connection con = DBConnect.getConnection();

				try {

					callableStatement = con.prepareCall(storeReadingScroll);

					callableStatement.setLong(1, userID);
					callableStatement.setString(2, readingSession);
					callableStatement.setLong(3, articleID);
					callableStatement.setInt(4, scrollRange);
					callableStatement.setInt(5, scrollExtent);
					callableStatement.setInt(6, scrollOffset);
					callableStatement.setTimestamp(7, dateTime);
					callableStatement.registerOutParameter(8,
							java.sql.Types.BIGINT);

					// execute loginUser store procedure
					callableStatement.executeUpdate();

					long readingScrollID = callableStatement.getLong(8);
					returnObj.put("lastReadingScrollID", readingScrollID + "");

				} catch (SQLException e) {
					return internalServerError(e.getMessage());
				} finally {
					DBConnect.disconnect();
				}
			}
			return ok(returnObj);
		}
	}

	/**
	 * Stores the navigational metadata in the database
	 * 
	 * @return Bigint, The navigational_metadata id
	 */
	public static Result storeNavigationalMetaData() {

		Result result = null;

		JsonNode request = request().body().asJson();

		if (request.size() == 0) {
			return result = internalServerError("Not valid request");
		} else if (request.findPath("userID").textValue().isEmpty()
				|| request.findPath("userSession").textValue().isEmpty()
				|| request.findPath("categoryName").textValue().isEmpty()
				|| request.findPath("swipeDirection").textValue().isEmpty()
				|| request.findPath("itemPosition").textValue().isEmpty()
				|| request.findPath("dateTime").textValue().isEmpty()) {

			return result = internalServerError("Json doesn't contain any values");
		} else {

			long userID = request.findPath("userID").asLong();
			String userSession = request.findPath("userSession").textValue();
			String categoryName = request.findPath("categoryName").textValue();
			String swipeDirection = request.findPath("swipeDirection")
					.textValue();
			int itemPosition = request.findPath("itemPosition").asInt();
			String dateTimeAsString = request.findPath("dateTime").textValue();

			Timestamp dateTime = null;

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss.SSS");
				Date parsedDate = dateFormat.parse(dateTimeAsString);
				dateTime = new java.sql.Timestamp(parsedDate.getTime());
			} catch (Exception e) {

			}

			CallableStatement callableStatement = null;
			String storeNavigationalMetaData = "{call storeNavigationalMetaData(?,?,?,?,?,?,?)}";
			ObjectNode userObj = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(storeNavigationalMetaData);

				callableStatement.setLong(1, userID);
				callableStatement.setString(2, userSession);
				callableStatement.setString(3, categoryName);
				callableStatement.setString(4, swipeDirection);
				callableStatement.setInt(5, itemPosition);
				callableStatement.setTimestamp(6, dateTime);
				callableStatement
						.registerOutParameter(7, java.sql.Types.BIGINT);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				long navigationalMetaDataID = callableStatement.getLong(7);
				userObj.put("navigationalMetaDataID", navigationalMetaDataID
						+ "");

				return ok(userObj);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}
	}

	
	
	/**
	 * Stores the navigation behavior in the database
	 * 
	 * @return Bigint, The navigation_behavior id
	 */
	public static Result storeNavigationBehavior() {

		Result result = null;

		JsonNode request = request().body().asJson();

		if (request.size() == 0) {
			return result = internalServerError("Not valid request");
		} else if (request.findPath("userID").textValue().isEmpty()
				|| request.findPath("navigationSession").textValue().isEmpty()
				|| request.findPath("categoryName").textValue().isEmpty()
				|| request.findPath("position").textValue().isEmpty()
				|| request.findPath("orderID").textValue().isEmpty()) {
			return result = internalServerError("Json doesn't contain any values");
		} else {

			long userID = request.findPath("userID").asLong();
			String navigationSession = request.findPath("navigationSession")
					.textValue();
			String categoryName = request.findPath("categoryName").textValue();
			int position = request.findPath("position").asInt();
			int orderID = request.findPath("orderID").asInt();

			CallableStatement callableStatement = null;
			String storeNavigationBehavior = "{call storeNavigationBehavior(?,?,?,?,?,?)}";
			ObjectNode userObj = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(storeNavigationBehavior);

				callableStatement.setLong(1, userID);
				callableStatement.setString(2, navigationSession);
				callableStatement.setString(3, categoryName);
				callableStatement.setInt(4, position);
				callableStatement.setInt(5, orderID);
				callableStatement
						.registerOutParameter(6, java.sql.Types.BIGINT);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				long navigationBehaviorID = callableStatement.getLong(6);
				userObj.put("navigationBehaviorID", navigationBehaviorID + "");

				return ok(userObj);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}
	}

	/**
	 * Stores the runningNewsApps in the database
	 * 
	 * @return Bigint, The runningNewsApps id
	 */
	public static Result storeRunningNewsApps() {

		Result result = null;

		JsonNode request = request().body().asJson();

		if (request.size() == 0) {
			return result = internalServerError("Not valid request");
		} else if (request.findPath("userID").textValue().isEmpty()
				|| request.findPath("userSession").textValue().isEmpty()
				|| request.findPath("appName").textValue().isEmpty()
				|| request.findPath("packageName").textValue().isEmpty()
				|| request.findPath("categoryName").textValue().isEmpty()
				|| request.findPath("lat").textValue().isEmpty()
				|| request.findPath("lon").textValue().isEmpty()
				|| request.findPath("startTime").textValue().isEmpty()
				|| request.findPath("userActivity").textValue().isEmpty()
				|| request.findPath("userActivityConfidenceLevel").textValue().isEmpty()) {
			return result = internalServerError("Json doesn't contain any values");
		} else {

			long userID = request.findPath("userID").asLong();
			String userSession = request.findPath("userSession")
					.textValue();
			String appName = request.findPath("appName").textValue();
			String packageName = request.findPath("packageName").textValue();
			String categoryName = request.findPath("categoryName").textValue();
			double lat = request.findPath("lat").asDouble();
			double lon = request.findPath("lon").asDouble();
			String userActivity = request.findPath("userActivity").textValue();
			String userActivityConfidenceLevel = request.findPath("userActivityConfidenceLevel").textValue();
			
			String dateTimeAsString = request.findPath("startTime").textValue();

			Timestamp dateTime = null;

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss.SSS");
				Date parsedDate = dateFormat.parse(dateTimeAsString);
				dateTime = new java.sql.Timestamp(parsedDate.getTime());
			} catch (Exception e) {

			}
			
			CallableStatement callableStatement = null;
			String storeRunningNewsApps = "{call storeRunningNewsApps(?,?,?,?,?,?,?,?,?,?,?)}";
			ObjectNode userObj = Json.newObject();
			Connection con = DBConnect.getConnection();

			try {

				callableStatement = con.prepareCall(storeRunningNewsApps);

				callableStatement.setLong(1, userID);
				callableStatement.setString(2, userSession);
				callableStatement.setString(3, appName);
				callableStatement.setString(4, packageName);
				callableStatement.setString(5, categoryName);
				callableStatement.setDouble(6, lat);
				callableStatement.setDouble(7, lon);
				callableStatement.setTimestamp(8, dateTime);
				callableStatement.setString(9, userActivity);
				callableStatement.setString(10, userActivityConfidenceLevel);
				callableStatement
						.registerOutParameter(11, java.sql.Types.BIGINT);

				// execute loginUser store procedure
				callableStatement.executeUpdate();

				long runningNewsAppsID = callableStatement.getLong(11);
				userObj.put("runningNewsAppsID", runningNewsAppsID + "");

				return ok(userObj);

			} catch (SQLException e) {
				return result = internalServerError(e.getMessage());
			} finally {
				DBConnect.disconnect();
			}
		}
	}
}
