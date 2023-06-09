package dataprovider;

import org.testng.annotations.DataProvider;

import java.util.Objects;

public class TestDataProvider {
    @DataProvider(name = "providePersonDataMan")
    public static Object[][] providePersonDataMan() {
        return new Object[][]{
                {"Johny", "Depp", 55},
                {"Brad", "Pitt", 77}
        };
    }
    @DataProvider(name = "providePersonDataWoman")
        public static Object[][] providePersonDataWoman(){
            return new Object[][]{
                    {"Margot","Robby", 32},
                    {"Angelina", "Jolie", 88}
            };
    }

}
