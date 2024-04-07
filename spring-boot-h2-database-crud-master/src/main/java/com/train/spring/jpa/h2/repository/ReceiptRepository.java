package com.train.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.train.spring.jpa.h2.model.Receipt;
/**
 * This class used to interact with database 
 */
@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
	
	/**
	 * Get the receipt by passing userId
	 * @param userId
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from receipt_details where user_id = :userId")
	List<Receipt> findByUserId(@Param("userId")Long userId);
	
	/**
	 * Get the Receipt by passing seat Id
	 * @param seatId
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from receipt_details where seat_id = :seatId")
	List<Receipt> findBySeatId(@Param("seatId")Long seatId);
	
	
  
}
