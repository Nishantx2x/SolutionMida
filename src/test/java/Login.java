import Page.HomePage;
import Page.LoginPage;
import Utils.Assertions;
import Utils.WebSetup;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
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
    @Parameters({"email","password"})
    public void Login(String email,String password) {
        loginPage.typeEmail(email);
        loginPage.typePass(password);
        loginPage.clickLogin();
        assertion.assertAll();
    }

    @Test(description = "This ", invocationCount = 80 )
    public void PublishMatch() throws InterruptedException {
        homePage.changeSports("CRICKET");
        homePage.clickLeftDFS();
        homePage.clickLeftFixture();
        homePage.clickUpcomingTab();
        homePage.clickPublishMatch();
        if(homePage.playerData()<=0){
            homePage.clickUpdateSquad();
            Thread.sleep(3000);
        }
        homePage.updateSalary();
        homePage.clickVerifyAndPublish();
        homePage.clickYes();
        Thread.sleep(3000);
        if (homePage.getAllTemplateSize()==0){
            String currentURL= driver.getCurrentUrl();
            String currentLeague= homePage.getLeagueName();
            driver.get("https://admin.devakhada.com/#/contesttemplate");
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//div[@class='Select-multi-value-wrapper'])[3]")).click();
            driver.findElement(By.id("template_league_id")).sendKeys(currentLeague+Keys.RETURN);
            homePage.clickAllTemplate();
            driver.findElement(By.xpath("//button[text()='CONFIRM']")).click();
            homePage.acceptCreateAlert();
            driver.get(currentURL);
            Thread.sleep(2000);
        }
        homePage.clickAllTemplate();
        homePage.clickCreateContest();
        homePage.acceptCreateAlert();
        assertion.assertAll();
    }
}
