package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FruitTest {

	@Test
	public void testConstuctor() {
		Fruit fruit = new Fruit(1, "orange", 3.2, 22);
		assertEquals(1, fruit.getId());
		assertEquals("orange", fruit.getName());
		assertEquals(3.2, fruit.getPrice(), 0.001);
		assertEquals(22, fruit.getQuantity());
	}

	@Test
	public void testEmptyConstuctor() {
		Fruit fruit = new Fruit();
		assertEquals(0, fruit.getId());
		assertEquals(null, fruit.getName());
		assertEquals(0, fruit.getPrice(), 0.001);
		assertEquals(0, fruit.getQuantity());
	}

	@Test
	public void testSetId() {
		Fruit fruit = new Fruit(1, "orange", 3.2, 22);
		fruit.setId(2);
		assertEquals(2, fruit.getId());
	}

	@Test
	public void testSetName() {
		Fruit fruit = new Fruit(1, "orange", 3.2, 22);
		fruit.setName("apple");
		assertEquals("apple", fruit.getName());
	}

	@Test
	public void testSetPrice() {
		Fruit fruit = new Fruit(1, "orange", 3.2, 22);
		fruit.setPrice(3.7);
		assertEquals(3.7, fruit.getPrice(), 0.001);
	}

	@Test
	public void testSetQuantity() {
		Fruit fruit = new Fruit(1, "orange", 3.2, 22);
		fruit.setQuantity(3);
		assertEquals(3, fruit.getQuantity());
	}

}
