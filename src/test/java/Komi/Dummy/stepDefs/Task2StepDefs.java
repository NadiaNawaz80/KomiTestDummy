package Komi.Dummy.stepDefs;

import Komi.Dummy.pages.BasePage;
import Komi.Dummy.pages.Task2Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;


public class Task2StepDefs {

    BasePage basePage = new BasePage();
    Task2Page task2Page = new Task2Page();

    static String title;

    @Given("User is on the Dummy Test page")
    public void userIsOnTheDummyTestPage() {
        basePage.navigateToPage();
    }

    @Then("i can see all the thumbnail images and they are loaded")
    public void iCanSeeAllTheThumbnailImagesAndTheyAreLoaded() {
        basePage.verifyThumbnailImagesIsDisplayed();
    }

    @When("i click on {string} title")
    public void i_click_on_title(String title) throws InterruptedException {
        Task2StepDefs.title = title;
        task2Page.selectTabFromNavbar(title);

    }

    @Then("it takes me to correct module")
    public void itTakesMeToCorrectModule() {
        System.out.println(Task2StepDefs.title);
        task2Page.verifyTabTitle(Task2StepDefs.title);
    }

    @When("i click on side navigation arrow on the Music Tracks module")
    public void iClickOnSideNavigationArrowOnTheMusicTracksModule() {
        task2Page.selectTabFromNavbar("Music Tracks");
    }

    @Then("i verify i can see pages and data")
    public void iVerifyICanSeePagesAndData() {
        task2Page.clickOnNextBtn();
        task2Page.verifyPagesAndData();
    }

    @When("i click on Pre-Save button")
    public void iClickOnPreSaveButton() {
        task2Page.selectTabFromNavbar("Pre-Save Music");
        task2Page.clickOnPreSaveBtn();
    }

    @Then("i verify i changes to Pre-Save button")
    public void iVerifyIChangesToPreSaveButton() {
        task2Page.verifyPreSaveBtnEffect();
    }

    @When("i click on the youtube video")
    public void iClickOnTheYoutubeVideo() {
        task2Page.selectTabFromNavbar("New Video");
        task2Page.clickOnPlayBtn();
    }

    @Then("i verify it redirects successfully")
    public void iVerifyItRedirectsSuccessfully() {
        task2Page.redirectToYoutube();
    }

    @When("i click on More button in the Single Music module")
    public void iClickOnMoreButtonInTheSingleMusicModule() {
        task2Page.clickOnMoreBtn();
    }

    @Then("i verify it redirects to the correct link")
    public void iVerifyItRedirectsToTheCorrectLink() {
        task2Page.verifyMoreBtnNextLink();
    }

    @When("i click the subscription module")
    public void iClickTheSubscriptionModule() {
        task2Page.selectTabFromNavbar("Subscribe");
        task2Page.clickOnSubscribeBtn();
    }

    @Then("i can fill in the form")
    public void iCanFillInTheForm() {
        Date date = new Date();
        task2Page.fillSubscriveForm("Geroge"+date.getTime(), "Geroge"+date.getTime()+"@testdummy.io");
    }

}
