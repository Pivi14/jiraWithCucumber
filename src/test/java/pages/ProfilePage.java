package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends WebPage{
    @FindBy(id = "up-d-username")
    WebElement username;

    private static ProfilePage instance = null;

    public static ProfilePage getInstance(WebDriver driver){
        if (instance == null){
            instance = new ProfilePage(driver);
        }
        return instance;
    }

    private ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(boolean waiting){
        driver.get(System.getenv("BASE_URL") + "/secure/ViewProfile.jspa");
        if (waiting){
            wait.until(ExpectedConditions.visibilityOf(username));
        }
    }

    public String getUserName(){
        return username.getText();
    }
}
