import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		WebDriver driver = new ChromeDriver();

		// Creating a list of names manually using ArrayList
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");

		// Traditional for-loop: counts how many names start with "A". Finally, prints
		// the count.
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

	}

	@Test
	public void streamFilter() {

		// Initializes a list of names.
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");

		// Uses stream() and filter() to count how many names start with "A".
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.print(c);

		Long d = Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Ram").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();

		System.out.println(d);

		// First line prints names where length > 4.
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		// Second line limits it to the first matching name with length > 4.
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}

	@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekya");
		names.add("Adam");
		names.add("Ram");

		// Filters names ending with "a", then converts to uppercase and prints.
		Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Ram").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Filters names starting with lowercase "a", sorts them, uppercases, then
		// prints.
		List<String> names1 = Arrays.asList("Abhijeet", "Don", "Alekya", "Adam", "Ram");
		names1.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Combines both names and names1 lists into one stream and prints sorted
		// values.
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s -> System.out.println(s));

		// Re-create the stream for matching check
		boolean flag = Stream.concat(names.stream(), names1.stream()).anyMatch(s -> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag); 
		System.out.println(flag);
	}

	@Test
	public void streamCollect() {

		// Filters names ending in "a", uppercases them, collects into a list, prints
		// the first item.
		List ls = Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Ram").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));

		// Prints each unique number (removes duplicates).
		List<Integer> numbers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		numbers.stream().distinct().forEach(s -> System.out.println(s));

		// Removes duplicates, sorts the list, collects into a new list, prints the
		// third item (index 2).
		List<Integer> Li = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(Li.get(2));

	}

}
