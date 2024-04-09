package com.train.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.spring.jpa.h2.model.Seat;

/**
 * This method used to get Seat Details
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	List<Seat> findBySectionAndSeat(String section, Integer seat);
  
}
