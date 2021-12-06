package com.ab.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Item i SET i.price =:updated.price, i.quantity =:updated.quantity, i.description =:updated.description WHERE i.itemID =:updated.itemID")
	void updateItem(@Param("updated")Item updatedItem);

}
