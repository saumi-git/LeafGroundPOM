package TestCases;

import Pages.LinkPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC004_LinkTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }

    @Test
    public void linkTest(){
        LinkPage linkPage=new LinkPage(driver);
        linkPage.clickHomeLink();
        linkPage.findWhereTheLinkGoes();
        linkPage.findLinkIsBroken();
        linkPage.findDuplicateLink();
        linkPage.countPageLinks();
        linkPage.countLayoutElements();
    }
}
