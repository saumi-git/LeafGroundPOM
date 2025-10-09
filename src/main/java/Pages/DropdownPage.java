package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownPage {
    WebDriver driver;

    public DropdownPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@class='ui-selectonemenu']")
    public WebElement dropDown;

    @FindBy(xpath = "//div[@id='j_idt87:country']")
    public WebElement countryDropdown;

    public void selectAutomationTool(){
        Select selectObject=new Select(dropDown);
        selectObject.selectByIndex(1);
        selectObject.selectByVisibleText("Playwright");
    }

    public void getNumberOfOptions(){
        Select selectObject=new Select(dropDown);
        List<WebElement> listOfOption=selectObject.getOptions();
        int size=listOfOption.size();
        System.out.println("Number of elements in dropdown"+ size);

        for (WebElement element:listOfOption){
            System.out.println(element.getText());
        }
        dropDown.sendKeys("Puppeteer");

    }

    public void selectCountry(){
        countryDropdown.click();
    }




}
