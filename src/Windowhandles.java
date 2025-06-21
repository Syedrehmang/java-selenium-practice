import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// Open the login page
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		// Click the link that opens a new window
		driver.findElement(By.cssSelector("a.blinkingText")).click();

		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();

		String parentId = it.next();
		String childId = it.next();

		// Switch to the child window
		driver.switchTo().window(childId);

		// Extract the email text from the paragraph
		String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(text);

		// Extract just the email address from the text
		String email = text.split("at")[1].trim().split(" ")[0];

		// Switch back to the parent window
		driver.switchTo().window(parentId);

		// Send the extracted email to the username field
		driver.findElement(By.id("username")).sendKeys(email);

		// Optional: Close both windows
		driver.quit();
	}
}
