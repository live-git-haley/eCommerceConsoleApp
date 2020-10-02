
public class Testing {

	public static void main(String[] args) {
		
		String[] arr1 = {"hey", "heyhey", "hello"};
		String[] arr2 = {"haley", "hey", "boy"};
		String s = "";
		for(int i = 0; i <= arr1.length-1;i++) {
			for (int k = 0; k <arr1[i].length()-1; k++) {
				if(arr1[i].charAt(k) == arr2[i].charAt(k)) {
					s = s + arr1[i].charAt(k);
					continue;
				}
			}
			if(!s.equals("")) {
				System.out.println(s);
			}
		}

		
	
	}

}
