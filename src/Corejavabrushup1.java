import java.util.Arrays;
import java.util.List;

public class Corejavabrushup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Data type and Variables
		int myNum = 5;
		String name = "Syed Rehman";
		char letter = 'R';
		double decimal = 1.5;
		boolean result = true;

		System.out.println(myNum + "is a number");

		// Arrays

		int[] array = new int[5];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		array[4] = 5;

		int[] array1 = { 0, 1, 2, 3, 4, 5 };

		System.out.println(array[1]);

		// Loops

		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i]);
		}

		for (int i = 0; i < array1.length; i++) {

			System.out.println(array1[i]);

		}

		String[] names = { "Syed", "Rehman", "G" };

		for (int i = 0; i < names.length; i++) {

			System.out.println(names[i]);
		}

		for (String s : names) {
			System.out.println(s);

			if (s == "Syed") {
				System.out.println(s);

			}

		}
	}

}
