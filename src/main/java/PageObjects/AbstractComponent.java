package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
      this.driver= driver;
      PageFactory.initElements(driver, this);
    }


    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }


}
