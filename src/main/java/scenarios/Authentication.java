package scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;

import java.util.concurrent.TimeUnit;

public class Authentication  {

  WebDriver webDriver;

  @BeforeSuite
  static void setupSuite(){
    WebDriverManager.chromedriver().driverVersion("122").setup();
  }

  @BeforeTest
  public void setupTest(){
    webDriver = new FirefoxDriver();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.get("https://my.tractive.com");
  }

  @AfterTest
  public void teardown() {
    webDriver.quit();
  }

  @Test
  public void testLogin() throws InterruptedException {
    LoginPage loginPage = new LoginPage(webDriver);
    loginPage.acceptCookies();
    SettingsPage settingsPage = loginPage
          .login("qa.interview@test.tractive.com","123456789");
    Thread.sleep(5000);
    Assert.assertTrue(settingsPage.isCorrectlyDisplayed(),
          "Expected to land on the settings page after login");
  }

}
