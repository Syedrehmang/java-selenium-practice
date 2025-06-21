public class string {

	public static void main(String[] args) {

		// Strings is an Object that represents sequence of characters
		// String literal

		String s = "Syed Rehman G";
		String g = "Syed Rehman G";

		// new
		String name = new String("Syed Rehman G");
		String names = "Syed Rehman G";
		String[] spilttedname = names.split("Rehman");
		System.out.println(spilttedname[0]);
		System.out.println(spilttedname[1].trim());

		for (int i = 0; i < names.length(); i++) {
			System.out.println(names.charAt(i));

		}

		for (int i = names.length() - 1; i >= 0; i--)

		{

			System.out.println(names.charAt(i));
		}

	}

}