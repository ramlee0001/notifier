package data;

import java.io.Serializable;

public class Note implements Serializable{
	private int no;
	private String title;
	private String desc;
	private String date;
	
	public Note(int a,String b,String c,String d) {
		this.no=a;
		this.title=b;
		this.desc=c;
		this.date=d;
	}
	
	public void setNo(int a) {
		this.no=a;
	}
	
	public void setTitle(String a) {
		this.title=a;
	}
	
	public void setDesc(String a) {
		this.desc=a;
	}
	
	public void setDate(String a) {
		this.date=a;
	}
	
	public int getNo() {
		return this.no;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDate() {
		return this.date;
	}
	public String toString() {
		return this.no +" "+this.date+" "+this.desc+" "+this.title;
	}
	
}
