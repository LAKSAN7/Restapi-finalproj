package com.AppStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppStore.entity.MyAppList;
import com.AppStore.repository.MyAppRepository;

@Service
public class MyAppListService {
	
	@Autowired
	private MyAppRepository myapp;
	
	public void saveMyApps(MyAppList book) {
		myapp.save(book);
	}
	
	public List<MyAppList> getAllMyApps(){
		return myapp.findAll();
	}
	
	public void deleteById(int id) {
		myapp.deleteById(id);
	}
}