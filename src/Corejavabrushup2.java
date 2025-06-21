
public class Corejavabrushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 2, 3, 4, 5, 6, 8, 10, 11, 122 };

//		for (int i = 0; i<array.length; i++)

		for (int i : array) {
			if (array[i] % 2 == 0) {
				System.out.println(array[i]);

			}

			else {
				System.out.println(array[i] + "is not multiple by 2");
			}
		}

	}

}
