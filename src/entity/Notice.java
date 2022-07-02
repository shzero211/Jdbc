package entity;

import java.util.Date;

public class Notice {

int id;
String title;

String writerId;
String content;
Date regdate;
int hit;
String files;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getWriterId() {
	return writerId;
}
public void setWriterId(String writerId) {
	this.writerId = writerId;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public int getHit() {
	return hit;
}
public void setHit(int hit) {
	this.hit = hit;
}
public String getFiles() {
	return files;
}
public void setFiles(String files) {
	this.files = files;
}
public Notice(int id, String title, String writerId, String content, Date regdate, int hit, String files) {
	this.id = id;
	this.title = title;
	this.writerId = writerId;
	this.content = content;
	this.regdate = regdate;
	this.hit = hit;
	this.files = files;
}
public Notice(String title,String writerId,String content,String files) {
	this.title=title;
	this.writerId=writerId;
	this.content=content;
	this.files=files;
}
public Notice(int id,String title,String writerId,String content,String files) {
	this.id=id;
	this.title=title;
	this.writerId=writerId;
	this.content=content;
	this.files=files;
}
}
