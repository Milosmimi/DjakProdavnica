package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FitnesPages extends BasePages{
    //konstruktor
    public FitnesPages(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.djaksport.com/fitnes");
        PageFactory.initElements(driver,this);
    }
    //lokatoir:

 @FindBy(xpath ="//span[text()='PROGRAM']" )
    WebElement programField;

 @FindBy(xpath = "//span[text()='Muški']")
    WebElement fieldMuski;
 @FindBy(xpath ="//p[text()='011083-7043']")
    WebElement blueShorts;
    //Metode:
/*
 public void sortProgramBytext(String text){
     Select dropDown=new Select(programField);
     dropDown.selectByVisibleText(text);
     clickFieldMuski();*/


 public void clickFieldMuski(){
     fieldMuski.click();
 }
 public void clickBlueShorts(){
     blueShorts.click();
 }


}
