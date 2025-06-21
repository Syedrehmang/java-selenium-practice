import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList();

		names.add("Syed");
		names.add("Rehman");
		names.add("G");
//		names.remove(2);

//		System.out.println(names.get(0));

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		System.out.println("*********");

		for (String val : names) {
			System.out.println((val));
		}

		System.out.println(names.contains("Rehman"));

		String[] usernames = { "Syed", "Rehman", "G" };

		List<String> arraylist = Arrays.asList(usernames);

		System.out.println(arraylist.contains("Rehman"));

	}

}
