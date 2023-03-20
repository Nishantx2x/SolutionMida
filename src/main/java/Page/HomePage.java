package Page;

import Utils.DriverMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class HomePage extends DriverMethods {

    private WebDriver driver;

    Logger logger= LogManager.getLogger(HomePage.class);

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

    public void clickSelectSportsArrow(){
        logger.info("Clicking on select arrow sports");
        selectSportsArrow.click();
    }

    public void clickOnSports(String sports){
        logger.info("Clicking on select arrow sports");
        driver.findElement(By.xpath("//span[text()='"+sports+"']")).click();
    }
    public void clickLeftDFS(){
        logger.info("Clicking DFS on left menu");
        leftDFS.click();
    }

    public void clickLeftFixture(){
        logger.info("Clicking Fixture on left menu");
        leftFixture.click();
    }

    public void clickUpcomingTab(String upcoming){
        logger.info("Clicking on upcoming tab");
        upcomingTab.click();
    }

    public void changeSports(String sportsName){
        logger.info("Selecting sports "+sportsName);
        clickSelectSportsArrow();
        clickOnSports(sportsName);
    }

}
