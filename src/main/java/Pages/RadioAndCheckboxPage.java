package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioAndCheckboxPage {
    WebDriver driver;

    public RadioAndCheckboxPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "j_idt87:console2:0")
    public WebElement firstRadio;

    @FindBy(id = "j_idt87:console2:1")
    public WebElement secondRadio;

    @FindBy(id = "j_idt87:console2:2")
    public WebElement thirdRadio;

    @FindBy(id = "j_idt87:console2:3")
    public WebElement fourthRadio;

    @FindBy(id = "j_idt87:age:0")
    public WebElement myAge;

    public void findDefaultSelectedRadioBtn(){
        boolean chromeRadioOption=firstRadio.isSelected();
        boolean firefoxRadioOption=secondRadio.isSelected();
        boolean safariRadioOption=thirdRadio.isSelected();
        boolean edgeRadioOption=fourthRadio.isSelected();

        if (chromeRadioOption){
            String chromeText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default selected button is "+chromeText);
        } else if (firefoxRadioOption) {
            String firefoxText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default selected button is "+firefoxText);
        } else if (safariRadioOption) {
            String safariText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default selected button is "+safariText);
        } else if (edgeRadioOption) {
            String edgeText=driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default selected button is "+edgeText);
        }

    }

    public void selectTheAge(){
        boolean isChecked=myAge.isSelected();
        if (!isChecked){
            //myage.click();
            WebElement myAgeFirstOption=driver.findElement(By.xpath("//label[@for='j_idt87:age:0']"));
            myAgeFirstOption.click();
        }
    }





}
