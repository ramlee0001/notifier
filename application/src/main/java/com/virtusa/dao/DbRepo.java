package com.virtusa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.virtusa.model.LogModel;
public interface DbRepo extends JpaRepository<LogModel,String>{
	List<LogModel> findByDate(String date);
}	
