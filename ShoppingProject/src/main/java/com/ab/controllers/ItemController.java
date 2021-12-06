package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.Item;
import com.ab.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item>getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping("/item/{itemId}")
	public Item getOrder(@PathVariable int itemID){
		return itemService.getItemByID(itemID);
	}

	@PostMapping("/addItem/{itemID}")
	public Item AddItem(@RequestBody Item item){
		return itemService.addItem(item);
	}
	
	@PutMapping("/removeItem/{itemID}")
	public Item RemoveItem(@PathVariable int itemID){
		return itemService.removeItemByID(itemID);
	}
	
	@PutMapping("/updateItem")
	public Item UpdateItem(@RequestBody Item item){
		return itemService.updateItemInfo(item);
	}
}
