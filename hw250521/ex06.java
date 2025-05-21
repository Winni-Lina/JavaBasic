package hw250521;

import java.util.HashMap;
import java.util.Map;

public class ex06 {

	public static void main(String[] args) {
		Map<String, String> a = new HashMap<String, String>();
		a.put("호랑이", "tiger");
		a.put("표범", "leopard");
		a.put("사자", "lion");
		
		System.out.println("변경 전 : " + a.toString());
		a.replaceAll((key, value) -> value.toUpperCase());
		 
		System.out.println("변경 후 : " + a.toString());
	}

}
