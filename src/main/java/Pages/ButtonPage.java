package Pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ButtonPage {
    WebDriver driver;

    public ButtonPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='j_idt88:j_idt90']")
    public WebElement clickConfirmBtn;

    @FindBy(id = "j_idt88:j_idt94")
    public WebElement getPosition;

    @FindBy(id = "j_idt88:j_idt96")
    public WebElement colorOfBtn;

    @FindBy(id = "j_idt88:j_idt98")
    public WebElement sizeOfBtn;


    public void clickAndConfirmBtnClick(){
        clickConfirmBtn.click();
    }

    public void verifyTitle(){
        String expectedTitle="Dashboard";
        String actualTitle= driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected.");
        }else {
            System.out.println("Actual is not same as expected");
        }
        Assert.assertEquals(actualTitle,expectedTitle, "Title mismatch");
        driver.navigate().back();
    }

    public void getPositionOfBtn(){
        Point xyPoint =getPosition.getLocation();
        int x=xyPoint.getX();
        int y= xyPoint.getY();
        System.out.println("X position is "+x+" and y point is "+y);
    }

    public void getColorOfBtn(){
        String color=colorOfBtn.getCssValue("background-color");
        System.out.println("button color is "+color);
    }

    public void getSizeOfBtn(){
        int height=sizeOfBtn.getSize().getHeight();
        int width=sizeOfBtn.getSize().getWidth();
        System.out.println("Height "+height+" width is "+width);
    }


}
