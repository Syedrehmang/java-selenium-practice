package syedrehmanseleniumproject.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import flipkartproject.pageObjects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import syedrehmanseleniumproject.TestComponents.BaseTest;
import syedrehmanseleniumproject.pageobjects.CheckoutPage;
import syedrehmanseleniumproject.pageobjects.ConfirmationPage;
import syedrehmanseleniumproject.pageobjects.LandingPage;
import syedrehmanseleniumproject.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce page")
	public void i_landed_on_Ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void logged_In_With_UserName_And_Password(String email, String password) {
		productCatalogue = landingPage.loginApplication(email, password);
	}

	@When("^I add product \"([^\"]*)\" to the cart$")
	public void i_Add_Product_To_The_Cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_And_Submit_The_Order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		//Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_Is_Displayed_On_ConfirmationPage(String expectedMessage) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(expectedMessage));
		driver.close();
	}

	@Then("{string} message is displayed")
	public void error_message_is_displayed(String expectedMessage) {
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		driver.close();
	}

}
