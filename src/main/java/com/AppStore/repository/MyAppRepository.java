package com.AppStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AppStore.entity.MyAppList;



@Repository
public interface MyAppRepository extends JpaRepository<MyAppList,Integer>{

}