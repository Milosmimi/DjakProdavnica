import Pages.BasePages;
import Pages.InventoryPages;
import Pages.LoginPages;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test
        /*
              Test steps:

        1.You are in Djak pages
        2.You are in login pages
        3.Yoi are in inventori pages
        4.Clear away cookies in down field
        5.Clear away cookies in up field
        6.You are in base pages
        7.Move mouse in prijava field
        8.Enter valid email
        9.Enter valid password
        10.Click login button
        11.Verify 'Milos Petrovic' in the upper field
     */
    public void LoginWithValidCredentials() {
        ChromeDriver driver= openChromeDriver();

        try {
            print("Navigate to Login pages");
            LoginPages loginPages=new LoginPages(driver);
            print("Navigate to inventori pages");
            InventoryPages inventoryPages=new InventoryPages(driver);
            print("Cookies in down field");
            inventoryPages.clickCookies();
            print("Cookies in up field");
            inventoryPages.clickCookeis1();
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
            print("verify thad users is log in");
            String actualNameOfMember=loginPages.getText();
            assert actualNameOfMember.equals(Strings.Succeffuly_Login):"Wrong name.Expected" + Strings.Succeffuly_Login + "Actual: " + actualNameOfMember;

        }finally {
            driver.quit();
        }
    }

    @Test
    /*
          Test steps:

        1.You are in Djak pages
        2.You are in login pages
        3.Yoi are in inventori pages
        4.Clear away cookies in down field
        5.Clear away cookies in up field
        6.You are in base pages
        7.Move mouse in prijava field
        8.Enter invalid email
        9.Enter valid password
        10.Click login button
        11.Verify 'prijava' in the upper field

     */
    public void LoginWithInvalidEmail(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to Login pages");
            LoginPages loginPages=new LoginPages(driver);
            print("Navigate to inventori pages");
            InventoryPages inventoryPages=new InventoryPages(driver);
            print("Coocies in down field");
            inventoryPages.clickCookies();
            print("Coocies in up field");
            inventoryPages.clickCookeis1();
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
            String prijavaField=loginPages.prijava();
            assert prijavaField.equals(Strings.Faild_Login):"Wrong name.Expected" + Strings.Faild_Login + "Actual: " + prijavaField;

            /*print("verify thad users is NOT log in");
            Assert.assertEquals(driver.getCurrentUrl(),Strings.Login_Field);*/


        }finally {
            driver.quit();
        }
    }

    @Test
    /*
              Test steps:

        1.You are in Djak pages
        2.You are in login pages
        3.Yoi are in inventori pages
        4.Clear away cookies in down field
        5.Clear away cookies in up field
        6.You are in base pages
        7.Move mouse in prijava field
        8.Enter valid email
        9.Enter invalid password
        10.Click login button
        11.Verify 'prijava' in the upper field
     */
    public void LoginWithInvalidPassword(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to Login pages");
            LoginPages loginPages=new LoginPages(driver);
            print("Navigate to inventori pages");
            InventoryPages inventoryPages=new InventoryPages(driver);
            print("Coocies in down field");
            inventoryPages.clickCookies();
            print("Coocies in up field");
            inventoryPages.clickCookeis1();
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
            String prijavaField=loginPages.prijava();
            assert prijavaField.equals(Strings.Faild_Login):"Wrong name.Expected" + Strings.Faild_Login + "Actual: " + prijavaField;
        }finally {
            driver.quit();
        }
    }

}
