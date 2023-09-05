package com.AppStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppStore.entity.App;
import com.AppStore.repository.AppRepository;

@Service
public class AppService {
	
	@Autowired
	private AppRepository bRepo;
	
	public void save(App b) {
		bRepo.save(b);
	}
	
	public List<App> getAllApp(){
		return bRepo.findAll();
	}
	
	public App getAppById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}