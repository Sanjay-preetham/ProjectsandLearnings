package OpenGoogle;

import java.util.HashMap;

public class dummy2 {

	public static void main(String[] args) {
		
		String a = "This is hello world program";
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		for (int i = 0 ; i< a.length();i++) {
			if(h.get(a.charAt(i)) != null) {
				int v = h.get(a.charAt(i));
				v++;
				h.put(""+a.charAt(i), v);
			} else {
				h.put(""+a.charAt(i), 0);
			}
		}
		System.out.println(h);
	}

}
