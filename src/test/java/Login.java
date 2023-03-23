import Page.HomePage;
import Page.LoginPage;
import Utils.Assertions;
import Utils.WebSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends WebSetup {

    LoginPage loginPage;
    HomePage homePage;
    Assertions assertion;

    @BeforeClass
    void object(){
        loginPage=new LoginPage(driver);
        homePage= new HomePage(driver);
        assertion= new Assertions(driver);
    }

    @Test(description = "Login method ", invocationCount = 1)
    public void Login() throws InterruptedException {
        loginPage.typeEmail("amar.gupta@supersixsports.com");
        loginPage.typePass("");
        loginPage.clickLogin();
        assertion.assertAll();
    }

    @Test(description = "This ", invocationCount = 1 )
    public void PublishMatch() throws InterruptedException {
        homePage.changeSports("CRICKET");
        homePage.clickLeftDFS();
        homePage.clickLeftFixture();
        homePage.clickUpcomingTab();
        homePage.clickPublishMatch();
        homePage.clickVerifyAndPublish();
        homePage.clickYes();
        Thread.sleep(3000);
        assertion.assertAll();
    }
}
