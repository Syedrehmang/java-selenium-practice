import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascriptexecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;

		for (int i = 0; i < amount.size(); i++) {
			sum = sum + Integer.parseInt(amount.get(i).getText());

		}
		System.out.println(sum);
		int actualAmount = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(actualAmount, sum);

		driver.close();
	}

}
