import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_friendsandfamily']"))
				.isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_friendsandfamily']"))
				.isSelected());
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_friendsandfamily']"))
				.isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_friendsandfamily']"))
				.isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), "6");
		driver.close();

	}

}
