package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    WebDriver driver;

    public AlertPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "j_idt88:j_idt91")
    public WebElement alertButton;

    @FindBy(id = "j_idt88:j_idt93")
    public WebElement confirmAlertButton;

    @FindBy(id = "j_idt88:j_idt104")
    public WebElement promptBox;

    public void acceptSimpleAlert(){
        alertButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public void confirmAlert(){
        confirmAlertButton.click();
        Alert confirmAlertButton= driver.switchTo().alert();
        confirmAlertButton.dismiss();
    }

    public void promptDialogAlert() throws InterruptedException {
        promptBox.click();
        Alert alertPrompt=driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText=alertPrompt.getText();
        System.out.println("Alert text is "+alertText);
        alertPrompt.sendKeys("ssssssss");
        alertPrompt.accept();
    }




}
