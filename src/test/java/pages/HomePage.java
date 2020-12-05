package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends WebPage{
    @FindBy(id = "create_link")
    WebElement createIssueButton;
    @FindBy(id = "header-details-user-fullname")
    WebElement userOptionsButton;
    @FindBy(id = "user-options-content")
    WebElement userOptionsContent;
    @FindBy(id = "log_out")
    WebElement logoutButton;

    private static HomePage instance = null;

    public static HomePage getInstance(WebDriver driver){
        if (instance == null){
            instance = new HomePage(driver);
        }
        return instance;
    }

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOptionsButton(){
        userOptionsButton.click();
        wait.until(ExpectedConditions.visibilityOf(userOptionsContent));
    }

    public void clickLogout(){
        logoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(MainPage.getInstance(driver).logoutMessage));
    }
}
