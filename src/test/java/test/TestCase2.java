package test;

import PageObjects.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestBase;

import java.io.IOException;

public class TestCase2 extends TestBase {
    public HomePage hp;

    @Test(dataProvider = "getData")
    public void openShowValues(String name, String lastName) throws InterruptedException, IOException {


        hp = new HomePage(driver);
        hp.goTo();
        System.out.println("Nombre: "+name);
        System.out.println("Apellido: "+lastName);

    }

    @DataProvider
    public Object[][] getData(){
    return new Object[][] {{"pepe", "Argento"}, {"Moni", "Argento"}};
    }
}
