package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages extends BasePages {
    //konstuktor
    public LoginPages(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.djaksport.com/");
        PageFactory.initElements(driver, this);
    }

//lokatori:

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Lozinka']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginbutton;

//metode:

    public void enterEmailField(String email){
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterPasswordField(String pass){
        passwordField.click();
        passwordField.sendKeys(pass);
    }

    public void clickLoginButton(){
        loginbutton.click();
    }








}
