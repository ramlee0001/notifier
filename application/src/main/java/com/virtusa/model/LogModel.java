package com.virtusa.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customerlog")
public class LogModel {
	@Id
	private String Id;
	private String logType;
	private String date;
	private String time;
	private String name;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "LogModel [Id=" + Id + ", logType=" + logType + ", date=" + date + ", time=" + time + ", name=" + name
				+ "]";
	}
	

}

	