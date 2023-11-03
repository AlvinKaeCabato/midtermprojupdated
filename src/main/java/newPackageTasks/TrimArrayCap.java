package newPackageTasks;

import java.util.ArrayList;

public class TrimArrayCap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> st = new ArrayList<String>(9);
		st.add("QWERTY");
		st.add("SD@EDS");
		st.add("SDADSAZX");
		st.add("ASDSAZ");
		st.add("ASDZZ");
		st.add(null);
		st.add(null);
		st.add("SDSDS");
		System.out.println("Original list: " + st + " With size: " + st.size());
		st.trimToSize();
		System.out.println("Trimmed list: " + st + " With size: " + st.size());
		
	}

}
