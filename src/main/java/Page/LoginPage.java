package Page;

import Utils.DriverMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverMethods {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    public void enterTextInSearchBox(String searchText){
        searchBox.sendKeys(searchText);
    }

    public void clickEnterOnSearchBox(){
        searchBox.sendKeys(Keys.ENTER);
    }

}
