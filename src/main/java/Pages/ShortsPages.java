package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShortsPages extends BasePages {
    public ShortsPages(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.djaksport.com/default.aspx?nodeid=601&p=77626");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='ctl06_ctl02_RepeaterRaster_ctl14_aRaster']")
    WebElement sizeM;
    @FindBy(xpath = "//span[text()='Dodaj u korpu']")
    WebElement dodajUKorpuButton;


    public void clickSizeM(){
        sizeM.click();
    }

    public void clickDodajUKorpuButton(){
        dodajUKorpuButton.click();
    }

}