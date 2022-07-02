package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Notice;
import service.NoticeService;

public class application {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
NoticeService nos=new NoticeService();
int a=nos.deleteNotice(101);

}
}
