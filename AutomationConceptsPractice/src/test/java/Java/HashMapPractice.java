package Java;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class HashMapPractice {
	@Test
	public void hashMap() {
		HashMap<Integer, String>hashMap = new HashMap<Integer, String>();
		hashMap.put(2, "Cat");
		hashMap.put(8, "Cat");
		hashMap.put(4, "Cat");
		hashMap.put(5, "Cat");
		hashMap.put(6, "Cat");
		System.out.println("Entries in hashmap are");
		for(Map.Entry m : hashMap.entrySet()){
			
			System.out.println(m.getKey() +" " + m.getValue());
			}
		hashMap.put(3, "abc");
	
		System.out.println("Entries in hashmap are after updation");
		for(Map.Entry m : hashMap.entrySet()){
			
			System.out.println(m.getKey() +" " + m.getValue());
			}
	}


}
