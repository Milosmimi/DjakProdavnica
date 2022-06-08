package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SneakersingPages extends BasePages {

    public SneakersingPages(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.djaksport.com/default.aspx?nodeid=2&text=patike");
        PageFactory.initElements(driver,this);
    }
    //lokatori:
    @FindBy(xpath = "//h4[text()='LFS PATIKE LOGO GALTER 5']")
    WebElement Sneakers;

    @FindBy(xpath = "//a[@id='ctl06_ctl02_RepeaterRaster_ctl01_aRaster']")
    WebElement size41;

    @FindBy(xpath = "//span[text()='Dodaj u korpu']")
    WebElement shopingCartButton;

    // metode:
    public void clickShopingCartButton(){
        shopingCartButton.click();
    }

    public void clickSneakers(){
        Sneakers.click();
    }

    public void clickSize(){
        size41.click();
    }

    public void clickSize(String size) {
        WebElement sizeElement = driver.findElement(By.xpath("" +
                "//ul[@class = 'sizes no-margin']//li[@size = '" + size + "']"));

        //             "//ul[@class = 'sizes no-margin']//li[@size = '41']"
        sizeElement.click();
    }






}
