package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  private WebDriver webDriver;

  private By emailField = By.cssSelector("input[ng-model='form.email']");

  private By passwordField;

  private By signinButton;

  private By cookiesConsentButton = By.className("cookie-consent-accept");

  public LoginPage(WebDriver webDriver){
    this.webDriver = webDriver;
  }

  public SettingsPage login(String email, String password){
    webDriver.findElement(emailField).sendKeys(email);
  }

  public void acceptCookies(){
    webDriver.findElement(cookiesConsentButton).click();
  }
}
