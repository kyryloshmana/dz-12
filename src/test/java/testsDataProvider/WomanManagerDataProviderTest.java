package testsDataProvider;

import dataprovider.TestDataProvider;
import family.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

public class WomanManagerDataProviderTest {
    private WomanManager womanManager;
    private Woman woman;
    UniqueId uniqueId;

    @BeforeMethod
    public void setUp(){
        uniqueId = new UniqueId();
        womanManager = new WomanManager();
    }
    @Test(description = "Перевірка створеного жінки"
            ,dataProvider = "providePersonDataWoman"
            ,dataProviderClass = TestDataProvider.class
    )

    public void addWomanTest(String firstName, String lastName, int age){
        woman = new Woman(uniqueId, firstName,lastName,age);
        womanManager.addWoman(woman);
        HashMap<Integer, Woman> women = womanManager.getWomen();
        assertEquals(woman, women.get(woman.getId()));
    }

    @Test(description = "Видалення жінки"
            ,dataProvider = "providePersonDataWoman"
            ,dataProviderClass = TestDataProvider.class
    )
    public void removeWomanTest(String firstName, String lastName, int age){
        addWomanTest(firstName, lastName, age);
        Woman removeWoman = womanManager.removeWoman(woman.getId());
        Assert.assertEquals(woman, removeWoman);

        HashMap<Integer, Woman> women = womanManager.getWomen();
        assertEquals(0, women.size());
    }

}
