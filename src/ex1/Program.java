package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//DB Driver �� java �޸� ������ �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");

//DB�� java�� �����ϱ� ���� url
		String url = "jdbc:mysql://localhost/jdbcprac?serverTimezone=UTC";

//DB�� java�� ����(url,id,pw)
		Connection con = DriverManager.getConnection(url, "root", "root");
//���� ���ް�ü
		Statement st = con.createStatement();

		String sql = "SELECT * FROM NOTICE";
//���� �����ֱ�
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
