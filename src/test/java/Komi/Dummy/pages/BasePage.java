package Komi.Dummy.pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Komi.Dummy.utils.Driver.getDriver;

public class BasePage {

    WebDriver driver;
    public BasePage(){
        this.driver = getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindAll({@FindBy(css = ".swiper-container")})
    List<WebElement> thumbnails;

    @FindBy(css = ".talent-detail__header__avatar")
    WebElement headerAvatar;

    @FindBy(css = ".text--bold18")
    WebElement cookieAcceptBtn;

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }


    public void navigateToPage() {
        getDriver().get("https://testdummy.komi.io/");
        waitForWebElementToAppear(cookieAcceptBtn);
        waitForWebElementToClickable(cookieAcceptBtn);
        cookieAcceptBtn.click();
    }

    public void verifyThumbnailImagesIsDisplayed(){
        Assert.assertTrue("header avatar is not displayed",headerAvatar.isDisplayed());
        for (int thumbIndex = 1; thumbIndex <thumbnails.size() ; thumbIndex++){
            Assert.assertTrue("header avatar is not displayed",thumbnails.get(thumbIndex).isDisplayed());
        }
    }



}
