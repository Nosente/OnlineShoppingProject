package com.ab.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.BasketItem;

@Repository
public interface BasketRepository extends JpaRepository<BasketItem, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE BasketItem b SET b.quantity =:b.quantity + amount WHERE b.itemID =:itemID")
	void addPrice(@Param("itemID") int userID, @Param("amount") double d);

	@Transactional
	@Modifying
	@Query("UPDATE BasketItem b SET b.quantity =:b.quantity - amount WHERE b.itemID =:itemID")
	void removePrice(@Param("itemID") int userID, @Param("amount") double d);

	@Transactional
	@Modifying
	@Query("UPDATE BasketItem b SET b.quantity =:b.quantity WHERE b.itemID =:itemID")
	BasketItem UpdateQuantityById(@Param("itemID") int itemID, @Param("quantity") int quantity);

}
