package database;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import model.Fruit;

public class FruitListTest {

	// TEST GET LIST
	@Test
	public void testGetList() {
		FruitList fruitList = new FruitList();
		fruitList.getList();
	}

	// TEST ADD LIST
	@Test
	public void testAddList() {
		FruitList fruitList = new FruitList();
		fruitList.addToList(new Fruit(1, "apple", 2, 2));
		List<Fruit> list = fruitList.getList();
		assertEquals(list.size(), 1);
		// assertEquals(list, hasItems(new Fruit(1,"apple", 2,2)));
	}

	// TEST DELETE LIST
	@Test
	public void testDeleteList() {
		FruitList fruitList = new FruitList();
		fruitList.addToList(new Fruit(1, "apple", 6, 23));
		fruitList.deleteFromList(1);
		List<Fruit> list = fruitList.getList();
		assertEquals(list.size(), 0);
	}

	// TEST UPDATE LIST
	@Test
	public void testUpdateList() {
		FruitList fruitList = new FruitList();
		fruitList.addToList(new Fruit(1, "apple", 6, 23));

		fruitList.updateFromList(1, "peach", 3, 8);
		List<Fruit> list = fruitList.getList();
		assertEquals(list.size(), 1);

		Fruit fruitObj = list.get(0);
		fruitObj.getId();
		fruitObj.getName();
		fruitObj.getPrice();
		fruitObj.getQuantity();

		assertEquals(1, fruitObj.getId());
		assertEquals("peach", fruitObj.getName());
		assertEquals(3, fruitObj.getPrice(), 0.01);
		assertEquals(8, fruitObj.getQuantity());
	}

	
	
	// TEST SEARCH LIST
	@Test
	public void testSearchList() {
		FruitList fruitList = new FruitList();
		fruitList.addToList(new Fruit(1, "apple", 6, 23));

		fruitList.searchList(1);
		List<Fruit> list = fruitList.getList();
		assertEquals(list.size(), 1);

		Fruit fruitObj = list.get(0);
		fruitObj.getId();
		fruitObj.getName();
		fruitObj.getPrice();
		fruitObj.getQuantity();

		assertEquals(1, fruitObj.getId());
		assertEquals("apple", fruitObj.getName());
		assertEquals(6, fruitObj.getPrice(), 0.01);
		assertEquals(23, fruitObj.getQuantity());
	}
	
	
}
