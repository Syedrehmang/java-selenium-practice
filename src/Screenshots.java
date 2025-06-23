import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("cookie");
		driver.get("https://www.google.com/");
		
		
		// Take screenshot and store as file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copy the screenshot to desired location
        FileUtils.copyFile(src, new File("C:\\Users\\Moolya\\eclipse-workspace\\SeleniumPractice\\screenshot.png"));

        driver.quit();
	}

}
