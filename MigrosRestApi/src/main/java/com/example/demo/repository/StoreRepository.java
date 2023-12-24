package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long>  {
	@Query(value="SELECT s.* FROM store AS s where name=?1", nativeQuery = true)
	Store findByName(String name);
}
