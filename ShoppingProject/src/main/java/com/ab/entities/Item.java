package com.ab.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Items")
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemID;
	
	private double price;
	private int quantity;
	private String description;
	
	public Item() {}
	
	public Item(double price, int quantity, String description) {
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public int getItemID() {
		return itemID;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}
	
	

}
