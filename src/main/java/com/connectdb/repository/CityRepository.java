package com.connectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connectdb.mssql.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
