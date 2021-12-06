package com.ab.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ab.entities.Item;
import com.ab.entities.ItemBasket;

import lombok.Data;
@Data
public class BasketItem {
	
	@ManyToOne
    @JoinColumn(name = "userID")
	private ItemBasket basket;
	
	private Item item;
	private int quantity;
	
	public BasketItem(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public ItemBasket getBasket() {
		return basket;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
	
}
