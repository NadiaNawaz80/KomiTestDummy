package Komi.Dummy.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Komi.Dummy.utils.Driver.getDriver;

public class Task2Page extends BasePage{

    WebDriver driver;
    public Task2Page(){
        driver = getDriver();
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = ".swiper-slide > .ant-row")
    WebElement musicData;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-text ant-btn-sm btn-swiper text--white m__l--16 p__x--0']//*[name()='svg']")
    WebElement nextBtn;

    @FindBy(xpath = "(//span[@class='ant-typography text text--semibold14 undefined'])[1]")
    WebElement preSavebtn;

    @FindBy(xpath = "//p[@id='login-to-continue']")
    WebElement login;

    @FindBy(xpath = "(//div[@class='ant-typography ant-typography-ellipsis ant-typography-ellipsis-multiple-line text text--semibold24 undefined'])[1]")
    WebElement subscribeBtn;

    @FindBy(xpath = "//input[@id='INPUT']")
    WebElement name;

    @FindBy(xpath = "//input[@id='EMAIL_ADDRESS']")
    WebElement email;

    @FindBy(xpath = "//span[normalize-space()='Submit']")
    WebElement submitBtn;

    @FindBy(css = ".text--semibold18")
    WebElement moreBtn;

    @FindBy(css = ".music-card__right > .ant-typography-ellipsis-multiple-line")
    WebElement moreLink;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M24.728 35')]")
    WebElement playBtn;

    @FindBy(xpath = "//div[@class='youtube-player youtube-player--full-width']")
    WebElement redirectYouTube;



    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }


    public void selectTabFromNavbar(String options) {
        System.out.println(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='"+options+"']"));
        jse.executeScript("arguments[0].scrollIntoView()", element);
        waitForWebElementToAppear(element);
        waitForWebElementToClickable(element);
        element.click();
    }

    public void verifyTabTitle(String options){
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+options+"')]"));
        waitForWebElementToAppear(element);
        waitForWebElementToClickable(element);
        Assert.assertTrue(options+ " title is not displayed",element.isDisplayed());
    }

    public void clickOnNextBtn(){
        waitForWebElementToAppear(nextBtn);
        nextBtn.click();
    }


    public void verifyPagesAndData(){
        Assert.assertTrue("next page button is not displayed",nextBtn.isDisplayed());
        Assert.assertTrue("Data is not displayed", musicData.isDisplayed());
    }


    public void clickOnPreSaveBtn(){
        waitForWebElementToAppear(preSavebtn);
        waitForWebElementToClickable(preSavebtn);
        preSavebtn.click();
    }

    public void verifyPreSaveBtnEffect(){
        waitForWebElementToAppear(login);
        Assert.assertTrue("no effect by pre save btn",login.isDisplayed());
    }

    public void clickOnSubscribeBtn(){
        waitForWebElementToAppear(subscribeBtn);
        waitForWebElementToClickable(subscribeBtn);
        subscribeBtn.click();
    }

    public void fillSubscriveForm(String nameText, String emailText){
        waitForWebElementToAppear(name);
        name.sendKeys(nameText);
        email.sendKeys(emailText);
        submitBtn.click();
    }

    public  void clickOnMoreBtn(){
        waitForWebElementToAppear(moreBtn);
        waitForWebElementToClickable(moreBtn);
        moreBtn.click();
    }

    public void verifyMoreBtnNextLink(){
        waitForWebElementToAppear(moreLink);
        Assert.assertTrue("not appear more link",moreLink.isDisplayed());
    }

    public void clickOnPlayBtn(){
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("**** iframe : " +size);
        waitForWebElementToAppear(playBtn);
        waitForWebElementToClickable(playBtn);
        playBtn.click();
    }

    public void redirectToYoutube(){
        waitForWebElementToAppear(redirectYouTube);
        waitForWebElementToClickable(redirectYouTube);
        redirectYouTube.click();
    }




    /*
        @FindBy(id = "se-searchbox-input-field")
    public WebElement searchBox;

    @FindBy(xpath = "//ul[@role='list']//p/span")
    public List<WebElement> articleList;

     */
}
