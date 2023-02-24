package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractComponent{

    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#post-399 div:nth-child(1)>div.wp-container-1>div")
    WebElement btn_JSDelays;
    @FindBy(css = "#cookie_action_close_header")
    WebElement modalCookies;


    public void goTo(){
        driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/");
    }
    public void selectJSDealys(){
        btn_JSDelays.click();
    }
    public void acceptCookies(){
        modalCookies.click();
    }


}
