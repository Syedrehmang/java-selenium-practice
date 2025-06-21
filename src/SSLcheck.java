import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;

import java.util.HashMap;
import java.util.Map;

public class SSLcheck {

	public static void main(String[] args) {
		// Set Chrome options
		ChromeOptions options = new ChromeOptions();

		// Accept insecure certificates
		options.setAcceptInsecureCerts(true);

		// Set up proxy (example: 8080 on localhost, modify as needed)
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("localhost:8080");
		proxy.setSslProxy("localhost:8080"); // Optional: if SSL traffic needs to go through proxy
		options.setCapability("proxy", proxy);

		// Set download directory
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", "/path/to/download"); // Use absolute path
		options.setExperimentalOption("prefs", prefs);

		// Launch Chrome with configured options
		WebDriver driver = new ChromeDriver(options);

		// Navigate to a site with an invalid SSL cert
		driver.get("https://expired.badssl.com/");

		// Print the page title
		System.out.println("Page Title: " + driver.getTitle());

		driver.quit();
	}
}
