package testsDataProvider;

import dataprovider.TestDataProvider;
import family.Men;
import family.Person;
import family.UniqueId;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreatePersonDataProvideTest {
    private Person person;
    UniqueId uniqueId;

    @BeforeMethod(groups = {"gets_sets"})
    public void setUp() {
        uniqueId = new UniqueId();

    }

    @Test(description = "Перевірка отриманих даних створеного особи", groups = {"gets_sets"}, dataProvider = "providePersonDataMan", dataProviderClass = TestDataProvider.class)

    public void getPersonData(String firstName, String lastName, int age){
        person = new Men(uniqueId, firstName, lastName, age);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstName, person.getFirstName());
        softAssert.assertEquals(lastName, person.getLastName());
        softAssert.assertEquals(age, person.getAge());
        softAssert.assertAll();
    }

    @Test (description = "Перевірка перезапису даних особи", groups = {"gets_sets"}, dataProvider = "providePersonDataMan", dataProviderClass = TestDataProvider.class)

    public void setPersonData(String firstName, String lastName, int age){
        person = new Men(uniqueId, firstName, lastName, age);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(person.getFirstName(), firstName);
        softAssert.assertEquals(person.getLastName(), lastName);
        softAssert.assertEquals(person.getAge(), age);
        softAssert.assertAll();
    }
}
