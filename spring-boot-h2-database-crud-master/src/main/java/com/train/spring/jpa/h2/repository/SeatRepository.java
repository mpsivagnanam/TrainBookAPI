package com.train.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.spring.jpa.h2.model.Seat;

/**
 * This method used to get Seat Details
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
  
}
