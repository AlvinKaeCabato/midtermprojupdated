package newPackageTasks;

import java.util.ArrayList;
import java.util.List;

public class CompareTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ArrayList<String> ListA = new ArrayList<String>();

	    ListA.add("QWERT");
	    ListA.add("ASDF");
	    ListA.add("ZXCV");
	    ListA.add("QWDASC");
	    ListA.add("QWDAsdadaSC");
	    ListA.add("QWDasdadfaASC");
	    
	    ArrayList<String> ListB = new ArrayList<String>();

	    ListB.add("QWERT");
	    ListB.add("ASDF");
	    ListB.add("ZXCV");
	    ListB.add("POIUJ");
	    ListB.add("SDAZZXZC");
	    
	    List<Integer> compare = new ArrayList<Integer>();
	    // adding default values as one
	    for (int a = 0; a < ListA.size(); a++) {
	        compare.add(0);

	    }

	    for (int counter = 0; counter < ListA.size(); counter++) {
	        if (ListB.contains(ListA.get(counter))) {
	            compare.set(counter, 1);
	        }
	    }

	    System.out.println(compare);
	    
	}
}