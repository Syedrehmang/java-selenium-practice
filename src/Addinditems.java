import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addinditems {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] viggies = { "Brocolli", "Cucumber", "Carrot","Pumpkin" };
		List<WebElement> viggiesList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < viggiesList.size(); i++) {

			String[] name = viggiesList.get(i).getText().split("-");
			String product = name[0].trim();
			List vegProduct= Arrays.asList(viggies);

			if (vegProduct.contains(product)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(3000);
				int j = 0;
				if (j == viggies.length) {
					break;
				}
			}

		}
		driver.close();

	}

}
