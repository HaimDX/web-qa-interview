package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {

  private WebDriver webDriver;

  private By userProfileTile;

  public SettingsPage(WebDriver webDriver){
    this.webDriver = webDriver;
  }

  public boolean isCorrectlyDisplayed(){
   return webDriver.findElement(userProfileTile).isDisplayed();
  }
}
