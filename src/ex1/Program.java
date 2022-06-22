package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
//DB Driver �� java �޸� ������ �ε�
Class.forName("com.mysql.cj.jdbc.Driver");

//DB�� java�� �����ϱ� ���� url
String url="jdbc:mysql://localhost/jdbcprac?serverTimezone=UTC";

//DB�� java�� ����(url,id,pw)
Connection con=DriverManager.getConnection(url,"root","root");
//���� ���ް�ü
Statement st=con.createStatement();

String sql="SELECT * FROM NOTICE";
//���� �����ֱ�
ResultSet rs=st.executeQuery(sql);

if(rs.next()) {
	String title= rs.getString("TITLE");
	System.out.printf("title:%s\n",title);
}
rs.close();
st.close();
con.close();
}
}
