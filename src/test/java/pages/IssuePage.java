package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePage extends WebPage{
    @FindBy(id = "edit-issue")
    WebElement editIssueButton;
    @FindBy(id = "summary-val")
    WebElement summaryValue;

    private static IssuePage instance = null;

    public static IssuePage getInstance(WebDriver driver){
        if(instance == null){
            instance = new IssuePage(driver);
        }
        return instance;
    }

    private IssuePage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(){
        driver.get(System.getenv("BASE_URL") + "/browse/MTP-1431");
        wait.until(ExpectedConditions.visibilityOf(editIssueButton));
    }

    public void clickEditButton(){
        editIssueButton.click();
        wait.until(ExpectedConditions.visibilityOf(EditIssueModal.getInstance(driver).summaryField));
    }

    public String getSummary(){
        return summaryValue.getText();
    }
}
