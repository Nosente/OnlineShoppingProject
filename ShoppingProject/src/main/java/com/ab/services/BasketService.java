package com.ab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.BasketItem;
import com.ab.entities.Item;
import com.ab.entities.User;
import com.ab.repositories.BasketRepository;

@Service
public class BasketService {
	
	@Autowired
	private BasketRepository basketRepository;

	public BasketItem addItem(Item item, int quantity) {
		BasketItem basketItem = new BasketItem(item,quantity);
		basketRepository.addPrice(item.getItemID(), item.getPrice() * quantity);
		return basketRepository.save(basketItem);
	}
	
	public BasketItem removeItem(Item item) {
		BasketItem removedItem = basketRepository.findById(item.getItemID()).get();
		basketRepository.removePrice(item.getItemID(), removedItem.getItem().getPrice() * removedItem.getQuantity());
		basketRepository.deleteById(item.getItemID());
		return removedItem;
	}
	
	public BasketItem increaseQuantity(Item item,int quantity) {
		basketRepository.addPrice(item.getItemID(), item.getPrice());
		return basketRepository.UpdateQuantityById(item.getItemID(), quantity + 1);
	}
	
	public BasketItem decreaseQuantity(Item item,int quantity) {
		basketRepository.removePrice(item.getItemID(), item.getPrice());
		return basketRepository.UpdateQuantityById(item.getItemID(), quantity - 1);
	}
	
	public BasketItem changeQuantity(Item item,int quantity) {
		return basketRepository.UpdateQuantityById(item.getItemID(), quantity);
	}
	
	public void checkoutBasket() {
		
	}
	
	
}
