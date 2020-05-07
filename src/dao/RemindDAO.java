package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Remind;

public class RemindDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/REMINDER?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<Remind> findAll() {

		List<Remind> remindList = new ArrayList<>();

		Connection conn = null;

		try {

			//データベースにつなぐ処理
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//SELECT文の準備
			String sql = "SELECT USER_ID, REMIND, CATEGORY, CREATED_DATE, TARGET_DATE, IMPORTANT_MARK FROM REMIND WHERE USER_ID = \"1234\" ORDER BY CREATED_DATE DESC";

			//SQL文を送る
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を実行し結果を取得
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {

				String user_id = rs.getString("USER_ID");
				String remind = rs.getString("REMIND");
				String category = rs.getString("CATEGORY");
				String created_date = rs.getString("CREATED_DATE");
				String target_date = rs.getString("TARGET_DATE");
				String important_mark = rs.getString("IMPORTANT_MARK");

				Remind reminder = new Remind(user_id,remind,category,created_date,target_date,important_mark);
				remindList.add(reminder);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

		return remindList;

	} //findAll()





	public boolean create(Remind remindLatest) {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//SQL文の準備
			String sql = "INSERT INTO REMIND(USER_ID, REMIND, CATEGORY, CREATED_DATE, TARGET_DATE, IMPORTANT_MARK) VALUES('1234', ?, ?, CURRENT_DATE, ?, ?)";

			//SQL文を送る
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文に情報を渡す
			pStmt.setString(1, remindLatest.getRemind());
			pStmt.setString(2, remindLatest.getCategory());
			pStmt.setString(3, remindLatest.getTarget_date());
			pStmt.setString(4, remindLatest.getImportant_mark());


			//SQL文を実行して結果を取得する(rsには追加された行数が代入される)
			int rs = pStmt.executeUpdate();

			if(rs != 1) {
				return false;
			}


		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}


		return true;


	}// create()





}
