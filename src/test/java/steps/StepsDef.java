package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class StepsDef {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage;
    HomePage homePage;
    ProfilePage profilePage;
    IssuePage issuePage;
    EditIssueModal editIssueModal;

    @Before
    public void setup(){
        mainPage = MainPage.getInstance(driver);
        homePage = HomePage.getInstance(driver);
        profilePage = ProfilePage.getInstance(driver);
        issuePage = IssuePage.getInstance(driver);
        editIssueModal = EditIssueModal.getInstance(driver);
        driver.manage().window().maximize();
    }

    @Given("go to the page")
    public void go_to_the_page(){
        mainPage.goToPage();
    }

    @When("type the username with {string}")
    public void typeTheUsernameWith(String user) {
        mainPage.typeUserName(user);
    }

    @And("type the password")
    public void typeThePassword() {
        mainPage.typePassword(System.getenv("PASSWORD"));
    }

    @And("click log in")
    public void clickLogIn() {
        mainPage.clickLoginButton();
    }

    @And("go to the profile page")
    public void goToTheProfilePage() {
        profilePage.goToPage(true);
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedUsername) {
        Assert.assertEquals(expectedUsername, profilePage.getUserName());
    }

    @Given("go to the issue's page")
    public void goToTheIssueSPage() {
        issuePage.goToPage();
    }

    @When("click on the Edit button")
    public void clickOnTheEditButton() {
        issuePage.clickEditButton();
    }

    @And("type new {string} summary")
    public void typeNewSummary(String summary) {
        editIssueModal.typeSummary(summary);
    }

    @And("click the update button")
    public void clickTheUpdateButton() {
        editIssueModal.clickUpdate();
    }

    @Then("should see the new {string} summary")
    public void shouldSeeTheNewSummary(String expectedSummary) {
        Assert.assertEquals(expectedSummary, issuePage.getSummary());
    }

    @Given("click profile icon in the top-right corner")
    public void clickProfileIconInTheTopRightCorner() {
        homePage.clickOptionsButton();
    }

    @When("click log out button")
    public void clickLogOutButton() {
        homePage.clickLogout();
    }

    @Then("should see {string}")
    public void shouldSee(String expectedMessage) {
        Assert.assertEquals(expectedMessage, mainPage.getLogoutMessage());
    }

    @When("go to the profile page with url")
    public void goToTheProfilePageWithUrl() {
        profilePage.goToPage(false);
    }

    @Then("should see error message with {string}")
    public void shouldSeeErrorMessageWith(String expectedMessage) {
        Assert.assertEquals(expectedMessage, mainPage.getMustLoginMessage());
    }

    @After
    public void close(){
        driver.close();
    }
}
