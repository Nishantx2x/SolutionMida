import Page.HomePage;
import Page.LoginPage;
import Utils.WebSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends WebSetup {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    void object(){
        loginPage=new LoginPage(driver);
        homePage= new HomePage(driver);
    }

    @Test
    public void LoginHere() throws InterruptedException {
        loginPage.typeEmail("amar.gupta@supersixsports.com");
        loginPage.typePass("");
        loginPage.clickLogin();
        Thread.sleep(5000);
        homePage.changeSports("SOCCER");
        homePage.clickLeftDFS();
        homePage.clickLeftFixture();
        Thread.sleep(10000);
    }
}
