package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//DB Driver 를 java 메모리 상으로 로드
		Class.forName("com.mysql.cj.jdbc.Driver");

//DB와 java를 연결하기 위한 url
		String url = "jdbc:mysql://localhost/jdbcprac?serverTimezone=UTC";

//DB와 java를 연결(url,id,pw)
		Connection con = DriverManager.getConnection(url, "root", "root");
//쿼리 전달객체
		Statement st = con.createStatement();

		String sql = "SELECT * FROM NOTICE";
//쿼리 보내주기
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			System.out.printf("id:%d,title:%s,writetId:%s,regDate:%s," + "content:%s,hit:%d\n", id, title, writerId,
					regDate, content, hit);
		}
		rs.close();
		st.close();
		con.close();
	}
}
