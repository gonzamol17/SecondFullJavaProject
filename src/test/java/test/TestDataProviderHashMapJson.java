package test;

import PageObjects.HomePage;
import org.apache.batik.svggen.font.table.LigatureSet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestDataProviderHashMapJson extends TestBase {
    public HomePage hp;

    @Test(dataProvider = "getData")
    public void openShowValues(HashMap<String,String> input) throws InterruptedException, IOException {

        hp= new HomePage(driver);
        hp.goTo();
        System.out.println("Nombre: "+input.get("name"));
        System.out.println("Apellido: "+input.get("LastName"));

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\utils\\users.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }
}
