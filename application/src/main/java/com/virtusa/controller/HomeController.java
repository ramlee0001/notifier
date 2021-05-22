package com.virtusa.controller;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.dao.DbRepo;
import com.virtusa.model.LogModel;


@Controller
public class HomeController {
	
	@Autowired
	DbRepo dbrepo;
	
	public String getDate() {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	String currentDate = dateFormat.format(new Date());
	return currentDate;
	}
	
	public String getTime() {
		while(true) {
			try {
				Thread.sleep(5*100); 
				LocalTime time = LocalTime.now(ZoneId.of("Asia/Kolkata"));
				String currentTime=time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
				return currentTime;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("home")
	public String home() {

		return ("home");
	}

	
	@RequestMapping("checkin")
	public ModelAndView checkin(LogModel logmodel) {
		logmodel.setId(logmodel.getName()+getTime());
		logmodel.setLogType("IN");
		logmodel.setDate(getDate());
		logmodel.setTime(getTime());
		ModelAndView mv=new ModelAndView();
		mv.addObject("name",logmodel.getName());
		mv.setViewName("welcome");
		return mv;	
	}
	
	@RequestMapping("checkout")
	public String checkout(LogModel logmodel) {
		logmodel.setId(logmodel.getName()+getTime());
		logmodel.setLogType("OUT");
		logmodel.setDate(getDate());
		logmodel.setTime(getTime());
		dbrepo.save(logmodel);
		return("home");	
	}
	
	@RequestMapping("getLogByDate")
	@ResponseBody
	public String findByDate(@RequestParam("date") String date) {
		return(dbrepo.findByDate(date).toString());
	}
	
	@RequestMapping("getAllLogs")
	@ResponseBody
	public String findByDate() {
		return(dbrepo.findAll().toString());
	}


}
