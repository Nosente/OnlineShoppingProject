package com.ab.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ab.models.BasketItem;

import lombok.Data;

@Entity
@Table(name = "Basket")
@Data
public class ItemBasket {
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
