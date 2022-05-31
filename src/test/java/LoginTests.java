import Pages.BasePages;
import Pages.InventoriPages;
import Pages.LoginPages;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test
    public void LoginWithValidCredentials() {
        ChromeDriver driver= openChromeDriver();

        try {
            print("Navigate to Login pages");
            LoginPages loginPages=new LoginPages(driver);
            print("Navigate to inventori pages");
            InventoriPages inventoriPages=new InventoriPages(driver);
            print("Cookies in down field");
            inventoriPages.clickCookies();
            print("Cookies in up field");
            inventoriPages.clickCookeis1();
            print("Navigate base pages");
            BasePages basePages=new BasePages(driver);
            print("Prijava");
            basePages.login();
            print("Enter email adress");
            loginPages.enterEmailField(Strings.Valid_Email);
            print("Enter password");
            loginPages.enterPasswordField(Strings.Valid_Password);
            print("Click login button");
            loginPages.clickLoginButton();
            print("verify thad users is SUCCEFFULY log in");
            Assert.assertEquals(driver.getCurrentUrl(),Strings.Login_Name);

        }finally {
            driver.quit();
        }
    }

    @Test
    public void LoginWithInvalidEmail(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to Login pages");
            LoginPages loginPages=new LoginPages(driver);
            print("Navigate to inventori pages");
            InventoriPages inventoriPages=new InventoriPages(driver);
            print("Coocies in down field");
            inventoriPages.clickCookies();
            print("Coocies in up field");
            inventoriPages.clickCookeis1();
            print("Navigate base pages");
            BasePages basePages=new BasePages(driver);
            print("Prijava");
            basePages.login();
            print("Enter email adress");
            loginPages.enterEmailField(Strings.Invalid_Email);
            print("Enter password");
            loginPages.enterPasswordField(Strings.Valid_Password);
            print("Click login button");
            loginPages.clickLoginButton();
            print("verify thad users is NOT log in");
            Assert.assertEquals(driver.getCurrentUrl(),Strings.Login_Field);


        }finally {
            driver.quit();
        }
    }

    @Test
    public void LoginWithInvalidPassword(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to Login pages");
            LoginPages loginPages=new LoginPages(driver);
            print("Navigate to inventori pages");
            InventoriPages inventoriPages=new InventoriPages(driver);
            print("Coocies in down field");
            inventoriPages.clickCookies();
            print("Coocies in up field");
            inventoriPages.clickCookeis1();
            print("Navigate base pages");
            BasePages basePages=new BasePages(driver);
            print("Prijava");
            basePages.login();
            print("Enter email adress");
            loginPages.enterEmailField(Strings.Valid_Email);
            print("Enter password");
            loginPages.enterPasswordField(Strings.Invalid_Password);
            print("Click login button");
            loginPages.clickLoginButton();
            print("verify thad users is NOT log in");
            Assert.assertEquals(driver.getCurrentUrl(),Strings.Login_Field);
        }finally {
            driver.quit();
        }
    }

}
