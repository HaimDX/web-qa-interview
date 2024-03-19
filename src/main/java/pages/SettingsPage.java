package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {

  private WebDriver webDriver;

  private By userProfileTile = By.cssSelector("tcommon-tile[ui-sref='^.userProfile.profile']");

  public SettingsPage(WebDriver webDriver){
    this.webDriver = webDriver;
  }

  public boolean isCorrectlyDisplayed(){
   return webDriver.findElement(userProfileTile).isDisplayed();
  }
}
