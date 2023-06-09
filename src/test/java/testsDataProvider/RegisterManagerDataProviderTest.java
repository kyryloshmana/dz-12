package testsDataProvider;
import dataprovider.TestDataProvider;
import family.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.*;

import java.util.HashMap;
public class RegisterManagerDataProviderTest {
    private RegisterManager registerManager;
    private MenManager menManager;
    private WomanManager womanManager;
    private Men man;
    private Woman woman;
    UniqueId uniqueId;

    @BeforeMethod
    public void setUp() {
        menManager = new MenManager();
        womanManager = new WomanManager();
        registerManager = new RegisterManager();
        uniqueId = new UniqueId();
            }

    @Test (description = "Додавання чоловіка до списку одружених"
            ,dataProvider = "providePersonDataMan"
            ,dataProviderClass = TestDataProvider.class)
    public void testAddManToMeritedMap(String firstName, String lastName, int age) {
        man = new Men(uniqueId, firstName,lastName,age);
        menManager.addManToMeritedMap(man);
        assertEquals(man, menManager.getMeritedMan(man.getId()));
    }

    @Test (description = "Додавання жінки до списку заміжніх"
            ,dataProvider = "providePersonDataWoman"
            ,dataProviderClass = TestDataProvider.class)
    public void testAddWomanToMeritedMap(String firstName, String lastName, int age) {
        woman = new Woman(uniqueId, firstName,lastName,age);
        womanManager.addWomanToMeritedMap(woman);
        assertEquals(woman, womanManager.getMeritedWoman(woman.getId()));
    }

    @Test (description = "Видалення чоловіка зі списку одружених"
            ,dataProvider = "providePersonDataMan"
            ,dataProviderClass = TestDataProvider.class)
    public void testRemoveManToMeritedMap(String firstName, String lastName, int age) {
        testAddManToMeritedMap(firstName, lastName, age);
        Men removeMan = menManager.removeManFromMeritedMap(man.getId());
        assertEquals(man, removeMan);

        HashMap<Integer, Men> mens = menManager.getMeritedMens();
        assertEquals(0, mens.size());
    }

    @Test (description = "Видалення жінки зі списку заміжніх"
            ,dataProvider = "providePersonDataWoman"
            ,dataProviderClass = TestDataProvider.class)
    public void testRemoveWomanToMeritedMap(String firstName, String lastName, int age) {
        testAddWomanToMeritedMap(firstName, lastName, age);
        Woman removeWoman = womanManager.removeWomanFromMeritedMap(woman.getId());
        assertEquals(woman, removeWoman);

        HashMap<Integer, Woman> women = womanManager.getMeritedWomen();
        assertEquals(0, women.size());
    }

    @Test (description = "Отримати одружених чоловіків"
            ,dataProvider = "providePersonDataMan"
            ,dataProviderClass = TestDataProvider.class)
    public void testGetMeritedMens(String firstName, String lastName, int age) {
        man = new Men(uniqueId, firstName,lastName,age);
        menManager.addManToMeritedMap(man);
        HashMap<Integer, Men> meritedMens = menManager.getMeritedMens();
        assertEquals(man, meritedMens.get(man.getId()));
        }

    @Test (description = "Отримати заміжніх жінок"
            ,dataProvider = "providePersonDataWoman"
            ,dataProviderClass = TestDataProvider.class)
    public void testGetMeritedWomen(String firstName, String lastName, int age) {
        woman = new Woman(uniqueId, firstName,lastName,age);
        womanManager.addWomanToMeritedMap(woman);
        HashMap<Integer, Woman> meritedWomen = womanManager.getMeritedWomen();
        assertEquals(woman, meritedWomen.get(woman.getId()));
    }
}

