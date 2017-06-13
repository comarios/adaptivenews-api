package controllers;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.ArticleDAO;
import model.NavigationDAO;
import model.NavigationMetaDataDAO;
import model.ReadingScrollDAO;
import model.RunningNewsAppsDAO;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import umfactors.DailyReadingTime;
import umfactors.Frequency;
import utils.DBTranformRawData;
import utils.DBUMTransactions;

/**
 * The `UM` class implements the User Modeling component. 
 * It defines methods for computing and retrieving the user model.
 * 
 * @author marios
 * 
 */
public class UM extends Controller {

	private static DBUMTransactions dbRawDataHandler = new DBUMTransactions();
	private static DBTranformRawData dbFactorsDataHandler = new DBTranformRawData();
	
	public static Result getUserClass() {

		JsonNode request = request().body().asJson();
		
		if (request.size() == 0) {
			return internalServerError("Request is empty");
		} else if (request.findPath("userID").textValue().isEmpty()) {
			return internalServerError("Json doesn't contain any value for userID");
		} else if (Integer.valueOf(request.findPath("userID").textValue()) == -1) {
			return internalServerError("Not valid request");
		} else {
			//retrieveUserDBInfo(userID);
			
			long userID = request.findPath("userID").asLong();
			ObjectNode userObj = Json.newObject();
			userObj.put("size", getDailyReadingTime(userID).size() + "");
//			ArrayList<ArticleDAO> arr = loadArticleDAO(userID);
//			ObjectNode userObj = Json.newObject();
//			for (ArticleDAO articleDAO : arr) {
//				
//				userObj.put("userID", articleDAO.getUserID() + "");
//				userObj.put("timestamp", articleDAO.getDateAdded() + "");
//			}
			
			
			return ok(userObj);
		}
		
		
	}
	
	private static ArrayList<NavigationMetaDataDAO> loadNavigationMetaData(long userID){
		 return dbRawDataHandler.getNavigationalData(userID);	
	}
	
	private static ArrayList<NavigationDAO> loadNavigation(long userID){
		return dbRawDataHandler.getNavigation(userID);
	}

	private static ArrayList<ArticleDAO> loadReading(long userID){
		return dbRawDataHandler.getReading(userID);
	}

	private static ArrayList<ReadingScrollDAO> loadReadingScroll(long userID){
		return dbRawDataHandler.getReadingScroll(userID);
	}
	
	private static ArrayList<RunningNewsAppsDAO> loadRunningNewsApps(long userID){
		return dbRawDataHandler.getRunningNewsApps(userID);
	}
	
	private static ArrayList<Frequency> getFrequency(long userID){
		return dbFactorsDataHandler.getFrequency(userID);
	}
	
	private static ArrayList<DailyReadingTime> getDailyReadingTime(long userID){
		return dbFactorsDataHandler.getDailyReadingTime(userID);
	}
}
