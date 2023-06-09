package testsDataProvider;

import dataprovider.TestDataProvider;
import family.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;

import static org.testng.AssertJUnit.*;

public class ManManagerDataProviderTest {
    private MenManager menManager;
    private Men men;
    UniqueId uniqueId;

    @BeforeMethod
    public void setUp(){
        uniqueId = new UniqueId();
        menManager = new MenManager();
    }


    @Test(description = "Перевірка створеного чоловіка"
            ,dataProvider = "providePersonDataMan"
            ,dataProviderClass = TestDataProvider.class
    )

    public void addManTest(String firstName, String lastName, int age){
        men = new Men(uniqueId, firstName,lastName,age);
        menManager.addMan(men);
        HashMap<Integer, Men> man = menManager.getMens();
        assertEquals(men, man.get(men.getId()));

    }


    @Test(description = "Видалення чоловіка"
            ,dataProvider = "providePersonDataMan"
            ,dataProviderClass = TestDataProvider.class
    )
    public void removeManTest(String firstName, String lastName, int age){
        addManTest(firstName, lastName, age);
        Men removeMan = menManager.removeMan(men.getId());
        Assert.assertEquals(men, removeMan);

        HashMap<Integer, Men> mens = menManager.getMens();
        assertEquals(0, mens.size());
    }
}
