import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();

		// Open the URL with an embedded frame
		driver.get("https://jqueryui.com/droppable/");

		// Switch to the iframe that contains the draggable/droppable elements
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		// Locate source and target elements inside the frame
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		// Perform drag and drop action
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();

		// Switch back to the default page content
		driver.switchTo().defaultContent();

		// Optionally close the browser
		driver.quit();
	}
}
