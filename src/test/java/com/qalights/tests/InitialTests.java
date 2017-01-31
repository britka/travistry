package com.qalights.tests;


import com.opencsv.CSVReader;
import com.qalights.User;
import com.qalights.models.ProfileUserModel;
import com.qalights.pages.site.LandingPage;
import com.qalights.pages.site.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by brit on 1/15/17.
 */
public class InitialTests extends BaseTest {

    @BeforeMethod
    public void alwaysGoToLoginPage() {
        goToUrl(BASE_URL + "/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void initialTest() {
        LandingPage landingPage = loginPage.login("sturdent", "909090", LandingPage.class);
        System.out.println(landingPage.hideMenu().isSideBarVisible());
        System.out.println(landingPage.showMenu().isSideBarVisible());

    }


    @Test
    public void loginLogoutTest() {
        Assert.assertTrue(loginPage.login("student", "909090", LandingPage.class).logout().isPageLoaded());
    }

    /**
     * Incorrect login test that uses @{@link DataProvider} from SCV file
     *
     * @param name     user login
     * @param password user password
     */
    @Test(dataProvider = "userNameAndPasswordsFromCSV")
    public void incorrectLoginTest(String name, String password) {
        Assert.assertTrue(loginPage.login(name, password, LoginPage.class).isPageLoaded());
    }

    /**
     * Incorrect login test that uses @{@link DataProvider} from SCV file
     *
     * @param user parameter as {@link User} class
     */
    @Test(dataProvider = "userNameAndPasswordsFromCSVAsObjects")
    public void incorrectLoginTest(User user) {
        Assert.assertTrue(loginPage.login(user, LoginPage.class).isPageLoaded());
    }

    /**
     * Incorrect login test that uses @{@link DataProvider} from array
     *
     * @param name     user login
     * @param password user password
     */
    @Test(dataProvider = "userNamesAndPasswords")
    public void incorrectLoginTest_FromArray(String name, String password) {
        Assert.assertTrue(loginPage.login(name, password, LoginPage.class).isPageLoaded());
    }

    @Test
    public void fillUserProfileTest() {
        ProfileUserModel profileUserModel = new ProfileUserModel()
                .setEmail("some@some.soem")
                .setUserNickName("SomeNickName")
                .setLoginName("SomeLoginName");
        loginPage.login("student", "909090", LandingPage.class)
                .getTopMenu()
                .openUserMenu()
                .toUserProfile()
                .fillForm(profileUserModel);

    }

    @DataProvider
    public Object[][] userNamesAndPasswords() {
        Object[][] objects = new Object[][]{
                {"strudent", "909090"},
                {"student", "90901111"},
                {"strudent", "526555"},
                {"student", ""},
                {"", "909090"},
                {"", ""}
        };
        return objects;
    }

    @DataProvider
    public Object[][] userNameAndPasswordsFromCSV() {
        CSVReader csvReader;
        ArrayList<String[]> list = new ArrayList<>();
        try {
            csvReader = new CSVReader(new FileReader(getClass().getClassLoader().getResource("data.csv").getFile()));
            csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] result = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    @DataProvider
    public Object[][] userNameAndPasswordsFromCSVAsObjects() {
        CSVReader csvReader;
        ArrayList<User> list = new ArrayList<>();
        try {
            csvReader = new CSVReader(new FileReader(getClass().getClassLoader().getResource("data.csv").getFile()));
            csvReader.readNext();
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(new User(line[0], line[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] result = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = new Object[]{list.get(i)};
        }
        return result;
    }


}
