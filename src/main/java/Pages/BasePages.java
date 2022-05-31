package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {
    ChromeDriver driver = null;
//lokatori:
@FindBy(xpath = "//span[text()='Korpa']")
    WebElement shopingCart;

@FindBy(xpath = "//a[@href='/Registracija']")
    WebElement registracijaMenu;

@FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

@FindBy(xpath = "//div[@id='ctl06_ctl08_quickSearchPnl']")
    WebElement searchFild;

@FindBy(xpath = "//span[@class='bg-box']")
    WebElement numberShopingCart;

@FindBy(xpath = "//span[text()='Prijava']")
    WebElement loginField;

@FindBy(xpath = "//span[text()='MOJA KORPA']")
    WebElement mojaKorpaBUtton;

@FindBy(xpath = "//span[text()='ISPRAZNI KORPU']")
    WebElement isprazniKorpuButton;

@FindBy(xpath = "//img[@src='/Images/Djak/v3/djaklogo1.svg']")
    WebElement imagesDjak;

//konstruktor
public BasePages(ChromeDriver driver){
    driver.get("https://www.djaksport.com/");
    PageFactory.initElements(driver,this);
    this.driver = driver;
}
//    public WebElement waitFOrElement(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }

    //metode:
    public void clickImagesDJak(){
        imagesDjak.click();
    }


    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void waitFOrElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickRegistrationMenu(){
    registracijaMenu.click();
    }

 public void clickSearchButton(){
    searchButton.click();
    }

 public void enterTextField(String text){
       searchFild.click();
     searchFild.sendKeys(text);
    }

    public void clickShopingCart(){
    moveToElement(shopingCart);
    shopingCart.click();
    }

    public String getNumberFromShopingCart(){
   return numberShopingCart.getText();
    }

    public void login(){
    moveToElement(loginField);
    }

    public void clickMojaKOrpaButton(){
        mojaKorpaBUtton.click();
    }

    public void clickIsprazniKorpuButton(){
        isprazniKorpuButton.click();
    }

    public void print(String s){
        System.out.println(s);
    }

}
