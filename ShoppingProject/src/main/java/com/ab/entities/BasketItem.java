package com.ab.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class BasketItem implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int basketID;
	
	@ManyToOne
    @JoinColumn(name = "userID")
	private ItemBasket basket;
	
	@OneToOne( fetch =FetchType.EAGER,
	mappedBy = "basketItem",
	cascade = CascadeType.ALL)
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
