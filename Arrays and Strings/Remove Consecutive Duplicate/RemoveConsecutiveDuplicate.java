package helloworld;

import java.util.Scanner;

public class RemoveConsecutiveDuplicate {

	//Time : O(n) & Space : O(n)
	public static String removeConsecutiveDuplicate(String input) {
		String ans = "";
		if(input.length()>0) {
			//int pos1 = 0;
			int pos2 = 1;
			
			while(pos2<input.length()) {
				if(input.charAt(pos2-1)!=input.charAt(pos2)) {
					ans+=input.charAt(pos2-1);
				}
				//pos1++;
				pos2++;
			}
			ans+=input.charAt(pos2-1);
			return ans;
		}else {
			return "Empty String";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string:");
		String input = sc.next();
		System.out.println(removeConsecutiveDuplicate(input));
		//System.out.println(removeConsecutiveDuplicate(""));
		sc.close();
	}

}
