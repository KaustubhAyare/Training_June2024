package hashM;

import java.util.LinkedHashMap;

public class LHM {

	public static void main(String[] args) {
		LinkedHashMap <Integer, String> lhm = new LinkedHashMap<Integer, String>();
		
		lhm.put(1,"kaustubh");
		lhm.put(2,"Prathmesh");
		lhm.put(3,"Deepak");
		
		System.out.println("Your entries are: "+lhm);
		
		System.out.println("Coder of C2L: "+lhm.get(2));
		
		lhm.remove(3);
		
		System.out.println("Top 2 Coders: "+lhm);
		
		System.out.println("Is map empty? "+ lhm.isEmpty());
		
		System.out.println("delete someone: "+ lhm.remove(2));
		
		System.out.println("Contains key? "
                + lhm.containsKey(2));
		System.out.println("Keys: "+lhm.keySet());  
		

	}

}
