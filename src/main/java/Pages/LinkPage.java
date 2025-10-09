package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinkPage {
    WebDriver driver;

    public LinkPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Go to Dashboard")
    public WebElement homeLink;

    @FindBy(partialLinkText = "Find the URL without clicking me.")
    public WebElement whereToGo;

    @FindBy(linkText = "Broken?")
    public WebElement brokenLink;

    @FindBy(linkText = "Go to Dashboard")
    public WebElement duplicateLink;

    @FindBy(tagName = "a")
    public List<WebElement> countFullPageLinks;

    @FindBy(className = "layout-main-content")
    public WebElement layoutElement;

    public void clickHomeLink(){
        homeLink.click();
        driver.navigate().back();
    }

    public void findWhereTheLinkGoes(){
        String path=whereToGo.getAttribute("href");
        System.out.println("this link is going to "+path);
    }

    public void findLinkIsBroken(){
        brokenLink.click();
        String title=driver.getTitle();
        if(title.contains("404")){
            System.out.println("the link is broken");
        }else {
            System.out.println("The link is not broken");
        }
        driver.navigate().back();
    }

    public void findDuplicateLink(){
        duplicateLink.click();
        driver.navigate().back();
    }

    public void countPageLinks(){
        int pageLinkCount=countFullPageLinks.size();
        System.out.println("No of links"+pageLinkCount);
    }

    public void countLayoutElements(){
        List<WebElement> countOfLayoutLinks=layoutElement.findElements(By.tagName("a"));
        int noOfLayoutLinks=countOfLayoutLinks.size();
        System.out.println("no of layout links "+noOfLayoutLinks);
    }

}
