package utils;

import java.util.List;
import java.util.Set;

public class Commons {
	public void printList(List<Integer> list) {
		for(Integer i : list) {
			System.out.print(i+",");
		}
		System.out.println();
	}
	
	public void printSet(Set<Integer> set) {
		for(Integer i : set) {
			System.out.print(i+",");
		}
		System.out.println();
	}
}
