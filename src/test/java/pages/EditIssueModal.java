package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditIssueModal extends WebPage {
    @FindBy(id = "summary")
    WebElement summaryField;
    @FindBy(id = "edit-issue-submit")
    WebElement updateButton;
    @FindBy(id = "edit-issue-dialog")
    WebElement editIssueModal;

    private static EditIssueModal instance = null;

    public static EditIssueModal getInstance(WebDriver driver){
        if (instance == null){
            instance = new EditIssueModal(driver);
        }
        return instance;
    }

    private EditIssueModal(WebDriver driver) {
        super(driver);
    }

    public void typeSummary(String summary){
        summaryField.sendKeys(summary);
    }

    public void clickUpdate(){
        updateButton.submit();
        wait.until(ExpectedConditions.invisibilityOf(editIssueModal));
    }
}
