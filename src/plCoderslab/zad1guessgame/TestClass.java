package plCoderslab.zad1guessgame;



public class TestClass {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,6};
		int num = 4;
		
		System.out.println(arrHasInt(arr, num));

	}

	static boolean arrHasInt (int [] input, int num) {
		
		for (int i = 0; i < input.length; i++) {
			if(input[i]==num) {
				return true; 			
			}
		} 
		return false;
	}
}
