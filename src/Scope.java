import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. Count all links on the entire page
		System.out.println("Total links on the page: " + driver.findElements(By.tagName("a")).size());

		// 2. Limit scope to the footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println("Links in footer: " + footer.findElements(By.tagName("a")).size());

		// 3. Limit further scope to the first column of footer
		WebElement firstColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Links in first footer column: " + firstColumn.findElements(By.tagName("a")).size());

		// 4. Open each link in a new tab (starting from index 1 to skip "REST API"
		// which opens in same tab)
		for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER); // open in new tab
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(2000); // wait for the tab to open
		}

		// 5. Get window handles and print title of each tab
		Set<String> windows = driver.getWindowHandles(); // Set of all opened windows/tabs
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("Title of tab: " + driver.getTitle());
		}

		driver.quit();
	}
}
