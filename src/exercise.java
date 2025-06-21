
public class exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] numbers = { 12, 7.5, 23, 4, 18.9 };

//      The first element of the numbers array.
		System.out.println("First element" + numbers[0]);

//		The last element of the numbers array.
		System.out.println("Last element" + numbers[numbers.length - 1]);

		// Using a loop, print the elements of the numbers array in reverse order.
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.println(numbers[i]);
		}

		// Bonus: Element count
		System.out.println("Total number of elements: " + numbers.length);

	}

}
