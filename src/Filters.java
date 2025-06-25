import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> searchedList = driver.findElements(By.xpath("//tr/td[1]"));
		System.out.println("Searched list:");
		for (WebElement veg : searchedList) {
			System.out.println(veg.getText());
		}
		List<WebElement> filteredList = searchedList.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());

		System.out.println("Filtered list:");
		for (WebElement veg : filteredList) {
			System.out.println(veg.getText());
		}

		Assert.assertEquals(searchedList.size(), filteredList.size());

	}

}
