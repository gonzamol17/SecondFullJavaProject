package test;

import PageObjects.HomePage;
import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.IOException;
import java.util.HashMap;

public class TestDataProviderHashMap extends TestBase {
    public HomePage hp;

    @Test(dataProvider = "getData")
    public void openShowValues(HashMap<String,String>input) throws InterruptedException, IOException {


        hp = new HomePage(driver);
        hp.goTo();
        System.out.println("Nombre: "+input.get("name"));
        System.out.println("Apellido: "+input.get("LastName"));

    }

    @DataProvider
    public Object[][] getData(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "pepe");
        map.put("LastName", "Argento");


        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Moni");
        map1.put("LastName", "Argento");

        return new Object[][] {{map}, {map1}};
    }
}
