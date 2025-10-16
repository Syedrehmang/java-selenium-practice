package syedrehmanseleniumproject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import flipkartproject.pageObjects.CartPage;
import syedrehmanseleniumproject.pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public CartPage goToCartPage() {
		waitForWebElementToAppear(cartHeader);
		cartHeader.click();
		return new CartPage(driver);
	}
	public OrderPage goToOrdersPage() {
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

}
