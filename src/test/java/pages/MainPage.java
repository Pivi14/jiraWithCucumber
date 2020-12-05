package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends WebPage{
    @FindBy(id = "login-form-username")
    WebElement userNameField;
    @FindBy(id = "login-form-password")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(xpath = "//section[@id='content']/div/div/section/div/div/p[@class='title']/strong")
    WebElement logoutMessage;
    @FindBy(xpath = "//form[@id='login-form']/div[@class='form-body']/div/p[contains(., 'You must log in to access this page.')]")
    WebElement mustLogInMessage;

    private static MainPage instance = null;

    public static MainPage getInstance(WebDriver driver){
        if(instance == null){
            instance = new MainPage(driver);
        }
        return instance;
    }

    private MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(){
        System.out.println(System.getenv("BASE_URL"));
        driver.get(System.getenv("BASE_URL"));
        wait.until(ExpectedConditions.visibilityOf(userNameField));
    }

    public void typeUserName(String user){
        userNameField.sendKeys(user);
    }

    public void typePassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.submit();
        wait.until(ExpectedConditions.visibilityOf(HomePage.getInstance(driver).createIssueButton));
    }

    public String getLogoutMessage(){
        return logoutMessage.getText();
    }

    public String getMustLoginMessage(){
        return mustLogInMessage.getText();
    }
}
