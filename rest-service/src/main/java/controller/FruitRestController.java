package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import database.FruitList;
import model.Fruit;

@RestController
public class FruitRestController {

	@Autowired
	FruitList fruitList = new FruitList();

	// GET- FRUIT ALL
	@GetMapping("/fruit")
	public List<Fruit> getAllFruitsJSON() {
		System.out.println("GET - Fruit");
		return fruitList.getList();
	}

	// GET- FRUIT BY ID
	@GetMapping("fruit/{id}")
	public List<Fruit> searchList(@PathVariable("id") int id) {
		System.out.println("GET - Fruit [id=" + id + "]");
		return fruitList.searchList(id);
	}

	// PUT- ADD NEW FRUIT
	@PutMapping("create/fruit/{id}")
	public void putFruit(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
			@RequestParam(value = "price") double price, @RequestParam(value = "quantity") int quantity) {

		Fruit fruitObj = new Fruit(id, name, price, quantity);
		System.out.println(
				"CREATE - Fruit [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]");
		fruitList.addToList(fruitObj);
	}

	// POST- UPDATE FRUIT BY ID
	@PostMapping("update/fruit/{id}")
	public void postFruit(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name,
			@RequestParam(value = "price") double price, @RequestParam(value = "quantity") int quantity) {
		System.out.println(
				"UPDATE - Fruit [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]");
		fruitList.updateFromList(id, name, price, quantity);
	}

	// DELETE- DELETE FRUIT BY ID
	@DeleteMapping("delete/fruit/{id}")
	public void deleteFruit(@PathVariable(value = "id") int id) {
		System.out.println("DELETE - Fruit [id=" + id + "]");
		fruitList.deleteFromList(id);
	}

}
