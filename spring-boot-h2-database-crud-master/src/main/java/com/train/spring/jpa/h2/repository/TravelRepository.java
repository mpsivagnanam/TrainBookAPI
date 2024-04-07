package com.train.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.spring.jpa.h2.model.Travel;
/**
 * 
 */
@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
	/**
	 * 
	 * @param departure
	 * @param arrival
	 * @return
	 */
	List<Travel> findByDepartureAndArrival(String departure, String arrival);
}
