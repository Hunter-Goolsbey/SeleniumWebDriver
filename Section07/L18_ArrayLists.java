package Section07;

import java.util.ArrayList;

public class L18_ArrayLists {
	
	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<String>();
		
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Lizard");
		animals.add("Horse");
		animals.remove(0);
		
		for (int i = 0; i<animals.size(); i++) {
			System.out.println(animals.get(i));
		}
		
	}
}