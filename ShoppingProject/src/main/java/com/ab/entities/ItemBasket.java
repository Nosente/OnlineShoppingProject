package com.ab.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Basket")
@Data
public class ItemBasket implements Serializable{
	@Id
	@OneToOne
    @JoinColumn(name = "userID")
	private User user;
	
	@OneToMany( fetch =FetchType.EAGER,
			mappedBy = "basket",
			cascade = CascadeType.ALL)
	private List<BasketItem> items;
	
	private double overallPrice;
	
	public ItemBasket() {}
}
