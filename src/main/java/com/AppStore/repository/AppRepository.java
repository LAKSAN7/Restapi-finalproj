package com.AppStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AppStore.entity.App;

@Repository
public interface AppRepository extends JpaRepository<App,Integer>  {

}