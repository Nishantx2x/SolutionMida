import Page.LoginPage;
import Utils.WebSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends WebSetup {

    LoginPage loginPage;
    @BeforeClass
    void object(){
        loginPage=new LoginPage(driver);
    }

    @Test
    public void LoginHere() throws InterruptedException {
        loginPage.enterTextInSearchBox("Amar");
        loginPage.clickEnterOnSearchBox();
        Thread.sleep(5000);
    }
}
