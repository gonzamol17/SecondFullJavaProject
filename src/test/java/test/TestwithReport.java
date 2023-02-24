package test;

import PageObjects.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.IOException;

public class TestwithReport extends TestBase {
    public HomePage hp;
    ExtentReports extent = new ExtentReports();

    @Test()
    public void testWithReport() throws InterruptedException, IOException {


        extent.createTest("testWithReport");
        hp= new HomePage(driver);
        hp.goTo();
        hp.acceptCookies();
        hp.selectJSDealys();
        //test.addScreenCaptureFromPath();
        extent.flush();

    }

}
