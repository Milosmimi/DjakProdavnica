import Pages.BasePages;
import Pages.InventoriPages;
import Pages.LoginPages;
import Pages.Strings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTests {


    ChromeDriver driver;

    ChromeDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--incognito"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;


    }
    public void print(String s){
        System.out.println(s);
    }


    public void login(ChromeDriver driver){
        LoginPages loginPages=new LoginPages(driver);
        InventoriPages inventoriPages=new InventoriPages(driver);
        inventoriPages.clickCookies();
        inventoriPages.clickCookeis1();
        BasePages basePages=new BasePages(driver);
        basePages.login();
        loginPages.enterEmailField(Strings.Valid_Email);
        loginPages.enterPasswordField(Strings.Valid_Password);
        loginPages.clickLoginButton();

    }


}
