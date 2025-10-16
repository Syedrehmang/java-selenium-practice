package syedrehmanseleniumproject.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import syedrehmanseleniumproject.TestComponents.Retry;
import syedrehmanseleniumproject.pageobjects.CheckoutPage;
import syedrehmanseleniumproject.pageobjects.ConfirmationPage;
import syedrehmanseleniumproject.pageobjects.LandingPage;
import syedrehmanseleniumproject.pageobjects.OrderPage;
import syedrehmanseleniumproject.pageobjects.ProductCatalogue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flipkartproject.pageObjects.CartPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitOrderTest extends syedrehmanseleniumproject.TestComponents.BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "PurchaseOrder")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "submitOrder" }, retryAnalyzer = Retry.class)
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("syedrehman9617@gmail.com", "Syed@199617");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "/src/test/java/syedrehmanseleniumproject/data/PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	/*
	 * @DataProvider public Object[][] getData() { return new Object [] []
	 * {{"syedrehman9617@gmail.com", "Syed@199617",
	 * "ZARA COAT 3"},{"syedrehman@appachhi.com", "Syed@199617",
	 * "ADIDAS ORIGINAL"}}; }
	 */

	/*
	 * @DataProvider public Object[][] getData() { HashMap<String, String> map = new
	 * HashMap<String, String>(); map.put("email", "syedrehman9617@gmail.com");
	 * map.put("password", "Syed@199617"); map.put("product", "ZARA COAT 3");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map.put("email", "syedrehman@appachhi.com"); map.put("password",
	 * "Syed@199617"); map.put("product", "ADIDAS ORIGINAL");
	 * 
	 * return new Object[][] { { map }, { map1 } };
	 * 
	 * }
	 */

}
