package Page;

import Utils.DriverMethods;
import Utils.Log;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


}
