package syedrehmanseleniumproject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Dimension;

import syedrehmanseleniumproject.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
	            + "\\src\\main\\java\\syedrehmanseleniumproject\\resources\\GlobalData.properties");
	    prop.load(fis);
	    String browserName = prop.getProperty("browser").trim();
	    System.out.println("Launching browser: " + browserName);

	    if (browserName.contains("chrome")) {
	        ChromeOptions option = new ChromeOptions();
	        System.setProperty("webdriver.chrome.driver", 
	                "C:\\Users\\Moolya\\.cache\\selenium\\chromedriver\\win64\\chromedriver-win64\\chromedriver.exe");
//	        WebDriverManager.chromedriver().driverVersion("138.0.7244.0").setup();
	        if(browserName.contains("headless")) {
	            option.addArguments("headless");
	        }

	        driver = new ChromeDriver(option);
	        driver.manage().window().setSize(new Dimension(1400, 900));
	    } else if (browserName.equalsIgnoreCase("FireFox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	    } else if (browserName.equalsIgnoreCase("Edge")) {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    } else {
	        throw new RuntimeException("Unsupported browser: " + browserName);
	    }

	    // Ensure driver is not null
	    if (driver == null) {
	        throw new RuntimeException("WebDriver initialization failed. Driver is null.");
	    }

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    return driver;
	}

	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(
				filePath),
				StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"//reports//"+ testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") +"//reports//"+ testCaseName + ".png";
		
		
	}


	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {

		driver.close();

	}

}
