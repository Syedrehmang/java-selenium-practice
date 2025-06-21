import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsclass {

	public static void main(String[] args) {
		// Launch Firefox
		WebDriver driver = new FirefoxDriver();

		// Create Actions instance
		Actions action = new Actions(driver);

		// Open Amazon
		driver.get("https://www.amazon.com/");

		// Hover over the account menu
		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
		action.moveToElement(move).perform();

		// Enter "HELLO WORLD" in uppercase in the search bar and double click to select
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello world").keyUp(Keys.SHIFT)
				.doubleClick().perform();

		// Right-click (context click) on the account menu
		action.moveToElement(move).contextClick().perform();

		// Close the browser
		driver.quit();
	}
}
