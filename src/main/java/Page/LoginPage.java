package Page;

import Utils.DriverMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class LoginPage extends DriverMethods {

    private WebDriver driver;

    Logger logger= LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passInput;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginCTA;

    public void enterTextInSearchBox(String searchText){
        searchBox.sendKeys(searchText);
    }

    public void clickEnterOnSearchBox(){
        searchBox.sendKeys(Keys.ENTER);
    }

    public void typeEmail(String email){
        logger.info("Entering email");
        emailInput.sendKeys(email);
    }

    public void typePass(String password){
        logger.info("Entering Password");
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking login CTA");
        loginCTA.click();
    }
}
