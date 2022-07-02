package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Notice;

public class NoticeService {
	String url="jdbc:mysql://localhost/jdbcprac?serverTimezone=UTC";
	String id="root";
	String pw="root";
public int createNotice(Notice notice) throws SQLException, ClassNotFoundException {
	String title=notice.getTitle();
	String writerId=notice.getWriterId();
	String content=notice.getContent();
	String files=notice.getFiles();
	//외부 클래스
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql="insert into notice (title,writer_id,content,files) values(?,?,?,?)";
		
		Connection con=DriverManager.getConnection(url,id,pw);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,title);
		st.setString(2,writerId);
		st.setString(3,content);
		st.setString(4,files);
		int result=st.executeUpdate();
		System.out.println(result);
		return result;
}
public List<Notice> getNotices(int page) throws ClassNotFoundException, SQLException{
	List<Notice> notices=new ArrayList<>(); 
	int start=1+(page-1)*10;
	int end=10*page;
	//외부 클래스
	Class.forName("com.mysql.cj.jdbc.Driver");
	String sql="select * from notice orders limit ?,?";
	
	Connection con=DriverManager.getConnection(url,id,pw);
	PreparedStatement st=con.prepareStatement(sql);
	st.setInt(1,start);
	st.setInt(2,end);
	ResultSet res=st.executeQuery();
	while(res.next()) {
		Notice no=new Notice(res.getInt("ID"),res.getString("TITLE"),res.getString("WRITER_ID"),
				res.getString("CONTENT"),res.getDate("REGDATE"),res.getInt("HIT"),res.getString("FILES"));
		notices.add(no);
		System.out.println(no.getTitle());
	}
	return notices;
}
public int deleteNotice(int noticeId) throws SQLException, ClassNotFoundException {
	//외부 클래스
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql="delete from notice where id=?";
		
		Connection con=DriverManager.getConnection(url,id,pw);
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,noticeId);
		int result=st.executeUpdate();
		System.out.println(result);
		return result;
}
public int updateNotice(Notice notice) throws SQLException, ClassNotFoundException {
	String title=notice.getTitle();
	String writerId=notice.getWriterId();
	String content=notice.getContent();
	String files=notice.getFiles();
	int noticeId=notice.getId();
	//외부 클래스
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql="update notice set title=?,writer_id=?,content=?,files=? where id=?";
		
		Connection con=DriverManager.getConnection(url,id,pw);
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,title);
		st.setString(2,writerId);
		st.setString(3,content);
		st.setString(4,files);
		st.setInt(5,noticeId);
		int result=st.executeUpdate();
		System.out.println(result);
		return result;
}

}
