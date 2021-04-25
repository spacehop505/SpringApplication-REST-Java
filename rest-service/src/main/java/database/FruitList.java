package database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Fruit;

@Service
public class FruitList {

	private List<Fruit> myFruitList = new ArrayList<>();

	// GET LIST
	public List<Fruit> getList() {
		return myFruitList;
	}

	// CREATE
	public void addToList(Fruit dataObj) {
		myFruitList.add(dataObj);
	}

	// READ
	public List<Fruit> searchList(int id) {
		List<Fruit> newList = new ArrayList<>();
		for (Fruit item : getList()) {
			if (item.getId() == id) {
				newList.add(item);
			}
		}
		return newList;

	}

	// UPDATE
	public void updateFromList(int id, String name, double price, int quantity) {
		for (Fruit item : getList()) {
			if (item.getId() == id) {
				item.setName(name);
				item.setPrice(price);
				item.setQuantity(quantity);
			}
		}

	}

	// DELETE
	public void deleteFromList(int id) {
		Iterator<Fruit> itr = getList().iterator();
		while (itr.hasNext()) {
			Fruit st = itr.next();
			if (st.getId() == id) {
				itr.remove();
			}
		}
	}

	public Object findAllBrands(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
