package test;

import PageObjects.HomePage;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.IOException;

public class TestCase1 extends TestBase {
    public HomePage hp;

    @Test()
    public void openJavaScriptDelay() throws InterruptedException, IOException {


        hp = new HomePage(driver);
        hp.goTo();
        hp.acceptCookies();
        hp.selectJSDealys();

    }



}
