import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		// Implicitly Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Explicitly Wait
		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] viggies = { "Brocolli", "Cucumber", "Carrot", "Pumpkin" };
		Wait wait = new Wait();
		wait.addingCart(driver, viggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		// Explicitly Wait
//		expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		// Explicitly Wait
//		expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.close();

	}

	public void addingCart(WebDriver driver, String[] viggies) throws InterruptedException {
		List<WebElement> viggiesList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < viggiesList.size(); i++) {

			String[] name = viggiesList.get(i).getText().split("-");
			String product = name[0].trim();
			List vegProduct = Arrays.asList(viggies);

			if (vegProduct.contains(product)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(3000);
				int j = 0;
				if (j == viggies.length) {
					break;
				}
			}

		}
		
	}

}
