package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Item;
import com.ab.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	public Item getItemByID(int itemID) {
		return itemRepository.getById(itemID);
	}
	
	public Item addItem(Item newItem) {
		return itemRepository.save(newItem);
	}
	
	public Item removeItemByID(int itemID) {
		Item removedItem = itemRepository.getById(itemID);
		itemRepository.deleteById(itemID);
		return removedItem;
	}
	
	public Item updateItemInfo(Item updatedItem) {
		int itemID = updatedItem.getItemID();
		itemRepository.updateItem(updatedItem.getPrice(), updatedItem.getQuantity(), updatedItem.getDescription(), updatedItem.getItemID());
		return itemRepository.getById(itemID);
	}
}
