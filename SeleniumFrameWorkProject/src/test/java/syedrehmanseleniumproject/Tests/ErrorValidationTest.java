package syedrehmanseleniumproject.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import syedrehmanseleniumproject.pageobjects.CheckoutPage;
import syedrehmanseleniumproject.pageobjects.ConfirmationPage;
import syedrehmanseleniumproject.pageobjects.LandingPage;
import syedrehmanseleniumproject.pageobjects.ProductCatalogue;
import org.testng.annotations.Test;

import flipkartproject.pageObjects.CartPage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorValidationTest extends syedrehmanseleniumproject.TestComponents.BaseTest {

	@Test(groups = {"ErrorHandling"})
	public void submitOrder() throws IOException {
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("syedrehman9617@gmail.com", "Syed@19961");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void loginPageErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("syedrehman@appachhi.com", "Syed@199617");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertFalse(match);

	}
}
