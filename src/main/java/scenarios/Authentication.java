package scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.TractiveLoginPage;

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
    TractiveLoginPage tractiveLoginPage = new TractiveLoginPage(webDriver);
    tractiveLoginPage.acceptCookies();
    tractiveLoginPage.login("ana2@test.tractive.com","Shirou123!");
    Thread.sleep(5000);
  }

}
