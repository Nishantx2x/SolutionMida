package Page;

import Utils.DriverMethods;
import Utils.Log;
import com.aventstack.extentreports.Status;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class HomePage extends DriverMethods {

    private WebDriver driver;

    Log logger= new Log();

    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='Select-arrow-zone']")
    private WebElement selectSportsArrow;

    @FindBy(xpath = "//a[text()='DFS']")
    private WebElement leftDFS;

    @FindBy(xpath = "//a[text()='Fixture']")
    private WebElement leftFixture;

    @FindBy(xpath = "(//label[text()='Upcoming'])[1]")
    private WebElement upcomingTab;

    @FindBy(xpath = "//div[@style='color: rgb(33, 33, 33); font-size: 16px; font-weight: bold;']")
    private List<WebElement> matchNames;

    @FindBy(xpath = "//i[@title='Publish Match']")
    private WebElement publishMatch;

    @FindBy(xpath = "//button[text()='Update Squad']")
    private WebElement updateSquad;
    @FindBy(xpath = "//button[text()='Verify and Publish']")
    private WebElement verifyAndPublish;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesPopUP;

    @FindBy(xpath = "//input[@name='SelectAllTemp']")
    private WebElement selectAllTemplate;
    
    @FindBy(xpath = "//button[@class='btn-secondary-outline btn btn-secondary']")
    private WebElement createContest;

    @FindBy(xpath = "//tr[@class='active']")
    private List<WebElement> playerData;

    @FindBy(xpath = "//div[@class='contest-list contest-card-body']")
    private List<WebElement> template;

    @FindBy(xpath = "(//h6[@class='livcardh6dfs'])[2]")
    private WebElement leagueName;

    @FindBy(xpath = "//div[@class='tab-pane active']/child::div/div/table/tbody/tr/td/input[@class='salary-input form-control']")
    private List<WebElement> salary;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/descendant::a[contains(@class,'nav-link')]/parent::li")
    private List<WebElement> players;


    public void clickSelectSportsArrow() throws InterruptedException {
        logger.info(Status.INFO,"Clicking on select arrow sports");
        hoverAndClick(selectSportsArrow);
    }

    public void clickOnSports(String sports){
        logger.info(Status.INFO,"Clicking on select arrow sports");
        click(findElement(driver,By.xpath("//div[text()='"+sports+"']")));
    }
    public void clickLeftDFS(){
        logger.info(Status.INFO,"Clicking DFS on left menu");
        click(leftDFS);
    }

    public void clickLeftFixture(){
        logger.info(Status.INFO,"Clicking Fixture on left menu");
        click(leftFixture);
    }

    public void clickUpcomingTab(){
        logger.info(Status.INFO,"Clicking on upcoming tab");
        click(upcomingTab);
    }

    public void changeSports(String sportsName) throws InterruptedException {
        logger.info(Status.INFO,"Selecting sports "+sportsName);
        clickSelectSportsArrow();
        clickOnSports(sportsName);
    }

    public void clickPublishMatch(){
        logger.info(Status.INFO,"Clicking on publish match icon");
        click(publishMatch);
    }

    public void clickUpdate(){
        logger.info(Status.INFO,"Clicking on update squad");
        click(updateSquad);
    }
    public void clickVerifyAndPublish(){
        logger.info(Status.INFO,"Clicking on verify and publish squad");
        click(verifyAndPublish);
    }

    public void clickYes(){
        logger.info(Status.INFO,"Clicking on yes");
        click(yesPopUP);
    }

    public void clickAllTemplate(){
        logger.info(Status.INFO,"Clicking on select all template");
        click(selectAllTemplate);
    }

    public void clickCreateContest(){
        logger.info(Status.INFO,"Clicking on create contest");
        click(createContest);
    }

    public void acceptCreateAlert() throws InterruptedException {
        logger.info(Status.INFO,"Accepting the create contest alert");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public int playerData(){
        logger.info(Status.INFO,"Checking players are available or not");
        return playerData.size();
    }

    public void clickUpdateSquad(){
        logger.info(Status.INFO,"Clicking on update squad");
        click(updateSquad);
    }

    public int getAllTemplateSize(){
        logger.info(Status.INFO,"Checking templates are available or not");
        return template.size();
    }

    public String getLeagueName(){
        return leagueName.getText();
    }

    public void updateSalary() throws InterruptedException {
        for (WebElement player:players) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'}); arguments[0].style.border='3px solid green';", player);
            Thread.sleep(2000);
            click(player);
            for (WebElement web : salary) {
                if (Float.parseFloat(web.getAttribute("value")) < 7) {
                    web.clear();
                    web.sendKeys("7");
                }
            }
        }
    }
}
