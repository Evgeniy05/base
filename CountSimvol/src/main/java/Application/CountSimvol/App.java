package Application.CountSimvol;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String");
		String vvod = s.nextLine();
		System.out.println("Enter the  char");
		String charA = s.nextLine();
		char[] a = charA.toCharArray();
		System.out.println(schet(vvod, a[0]));
		s.close();
	}

	public static int schet(String s, char a) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == a) {
				result += 1;
			}
		}

		return result;
	}
}
