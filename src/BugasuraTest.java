

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BugasuraTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();

  }

  @Test
  public void testBugasura() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1536,737 | ]]
    driver.get("https://bugasura.io/");
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.linkText("Unlimited Free")).click();
    driver.get("https://my.bugasura.io/?go=sign_up");
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.id("email_field")).clear();
    driver.findElement(By.id("email_field")).sendKeys("syed.rehman@moolya.com");
    // ERROR: Caught exception [unknown command [waitFor]]
    // ERROR: Caught exception [unknown command [typeSecret]]
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.id("password_field_s")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    // ERROR: Caught exception [unknown command [typeSecret]]
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("button.signup-submit.mdl-button.mdl-js-button.mdl-js-ripple-effect > span.mdl-button__ripple-container")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("[data-target=\"#update_description\"]")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("[data-role=\"tester\"] > .job-description")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("button.mdl-button.mdl-button--icon.mdl-js-button.mdl-js-ripple-effect.js-go-to-slide.next.slide-button.in > span.mdl-button__ripple-container")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.name("nw_team_member_invite")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.name("nw_team_member_invite")).clear();
    driver.findElement(By.name("nw_team_member_invite")).sendKeys("syedrehman@appachhi.com");
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("button.mdl-button.mdl-js-button.mdl-js-ripple-effect.ap__btn.ap__btn--new.ap__btn--primary.js-invite-member-button > span.mdl-button__ripple-container")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("[data-toggle=\"dropdown\"]")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.linkText("Admin")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("button.mdl-button.mdl-button--icon.mdl-js-button.mdl-js-ripple-effect.js-go-to-slide.next.slide-button.in > span.mdl-button__ripple-container")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("div:nth-child(6) > div:nth-of-type(2) > div:nth-child(1)")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("div:nth-child(6) > div:nth-of-type(3) > div:nth-of-type(1)")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("div:nth-of-type(2) > div:nth-of-type(4) > div > img")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("div:nth-child(6) > div:nth-of-type(5) > div:nth-of-type(1)")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("div:nth-of-type(6) > div > img")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("button.mdl-button.mdl-button--icon.mdl-js-button.mdl-js-ripple-effect.js-go-to-slide.next.slide-button.in > span.mdl-button__ripple-container")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("button.mdl-button.mdl-button--icon.mdl-js-button.mdl-js-ripple-effect.js-go-to-slide.next.slide-button.in > span.mdl-button__ripple-container")).click();
    // ERROR: Caught exception [unknown command [waitFor]]
    driver.findElement(By.cssSelector("#nw_explore_bugasura > span.mdl-button__ripple-container")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      org.openqa.selenium.Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
