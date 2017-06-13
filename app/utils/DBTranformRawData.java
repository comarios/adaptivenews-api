package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import umfactors.DailyReadingTime;
import umfactors.Frequency;

public class DBTranformRawData {

	private static DBConnect dbConnect = null;

	/*
	 * Loads the Frequency from DB
	 */
	public ArrayList<Frequency> getFrequency(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<Frequency> arrFrequency = new ArrayList<Frequency>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String getFrequency = "{call getFrequency(?)}";

		try {

			cs = con.prepareCall(getFrequency);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				Frequency fr = new Frequency();

				fr.setUserID(rs.getLong("user_id"));
				fr.setDistinctReadingSessions(rs
						.getInt("distinctReadingSessions"));
				fr.setDateAdded(rs.getTimestamp("date_added"));

				arrFrequency.add(fr);
			}

			return arrFrequency;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}

	/*
	 * Loads the DailyReadingTime from DB
	 */
	public ArrayList<DailyReadingTime> getDailyReadingTime(long userID) {

		Connection con = DBConnect.getConnection();
		ArrayList<DailyReadingTime> arrDailyReadingTime = new ArrayList<DailyReadingTime>();

		if (con == null)
			return null;

		CallableStatement cs = null;
		String getDailyReadingTime = "{call getDailyReadingTime(?)}";

		try {

			cs = con.prepareCall(getDailyReadingTime);

			cs.setLong(1, userID);
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {

				DailyReadingTime drt = new DailyReadingTime();

				drt.setUserID(rs.getLong("user_id"));
				drt.setDailyReadingTime(rs
						.getDouble("dailyReadingTime"));
				drt.setDateAdded(rs.getTimestamp("date_added"));

				arrDailyReadingTime.add(drt);
			}

			return arrDailyReadingTime;

		} catch (SQLException e) {
			return null;
		} finally {
			DBConnect.disconnect();
		}
	}
}
