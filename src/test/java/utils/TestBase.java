package utils;

import PageObjects.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public HomePage hp;
    public WebDriver driver;
     ExtentReports extent;


    @BeforeMethod
    public WebDriver openBrowser() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            System.out.println("Launching:"+browserName);
            String pathDriver = System.getProperty("user.dir") + "\\src\\test\\java\\executables\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", pathDriver);
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")){
            System.out.println("Launching:"+browserName);
            String pathDriver = System.getProperty("user.dir") + "\\src\\test\\java\\executables\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", pathDriver);
            driver = new FirefoxDriver();
        }

        //esta linea de abajo no se usa, ya que se creo un método en el page object
        //model de HomePage, que se llama goTo, y ejecuto ese método para que se
        //abra el browser con esa url
        //driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read a json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath));
        //string to hashmap dependency jackson Datbind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
        });
        return data;
    }




    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//" + testCaseName+".png";

    }



    @AfterMethod
    public void tearDown() throws IOException {
        driver.quit();
    }



}
