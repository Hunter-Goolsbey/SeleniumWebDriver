package Section07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L20_Iterator {
	
	public static void main(String[] args) {
		
		List<String> animals = new ArrayList<String>();
		
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Lizard");
		animals.add("Horse");
		//animals.remove(0);
		
		Iterator<String> it = animals.iterator();
		
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		
		
	}
		
}