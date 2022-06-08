package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPages extends BasePages {

 @FindBy(xpath = "//a[@id='ctl06_ctl01_menu_ctl00_plainName']")
    WebElement novaKolekcija;

@FindBy(xpath = "//div[@id='product-image-container']")
    WebElement sneakersList;

@FindBy(xpath = "//h4[text()='PATIKE 243137NC BASH LR NC']")
    WebElement kappaSneaks;

@FindBy(xpath = "//a[text()='Slažem se']")
    WebElement cookeis;

@FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

@FindBy(xpath = "//input[@placeholder='Pretraga']")
    WebElement searchField;

@FindBy(xpath = "//button[text()='Ne, hvala']")
    WebElement cookeis1;

@FindBy(xpath = "//a[text()='SPORTOVI ']")
    WebElement sportoviMenu;

@FindBy(xpath = "//span[@class='sportIcon icon-Sport-Fudbal']")
    WebElement iconFudbal;

@FindBy(xpath = "//select[@class='textboxpager']")
    WebElement dropDownfield;

@FindBy(xpath = "//span[@class='sportIcon icon-Sport-Fitnes']")
    WebElement iconFitnes;

//konstruktor
 public InventoryPages(ChromeDriver driver){
     super(driver);
     driver.get("https://www.djaksport.com/");
     PageFactory.initElements(driver,this);
    }
//metode

    public void clickNovaKolekcija(){
     novaKolekcija.click();
    }

    public void clickKappaSneaks(){
     kappaSneaks.click();
    }

    public void clickFitnesIcon(){
     iconFitnes.click();
    }


 public void clickCookeis1(){
     waitFOrElement(cookeis1);
     cookeis1.click();
 }

 public void clickCookies(){
     cookeis.click();
  }

    public void enterTextField(String text){
        searchField.click();
        searchField.sendKeys(text);
        }
    public void clickSearchButton() {
        searchButton.click();
    }
    public void clickSportoviField(){
     moveToElement(sportoviMenu);
     sportoviMenu.click();
    }

    public void clickOnTheIckonFudbal(){
     iconFudbal.click();
    }

    public String  sortItemsByText(String text){
        Select dropDown=new Select(dropDownfield);
        dropDownfield.click();
        dropDown.selectByVisibleText(text);

        return text;
    }
    public void testing(){
        print("succeffuly login");
      //  login(driver);
        print("navigate to Sneakers Pages");
        InventoryPages inventoriPages=new InventoryPages(driver);
        print("searching field");
        inventoriPages.enterTextField("patike");
        print("click searching button");
        inventoriPages.clickSearchButton();
        SneakersingPages sneakersingPages=new SneakersingPages(driver);
        print("click in the sneakersing field");
        sneakersingPages.clickSneakers();
        print("size for sneakers");
        sneakersingPages.clickSize("41");
        print("click the buy button");
        sneakersingPages.clickShopingCartButton();
        print("navigate to base pages");
        BasePages basePages=new BasePages(driver);
        print("Clic shoping cart");
        basePages.clickShopingCart();
    }


    public void removeItemsInShopingCArt(){
        print("Navigate to inventori pages");
        InventoryPages inventoriPages=new InventoryPages(driver);
        print("Open sprtovi field");
        inventoriPages.clickSportoviField();
        print("Click fitnes icon");
        inventoriPages.clickFitnesIcon();
        print("Navigate to fitnes pages");
        FitnesPages fitnesPages=new FitnesPages(driver);
        print("Mark the field 'Muski' ");
        fitnesPages.clickFieldMuski();
        print("Click blue shorts");
        fitnesPages.clickBlueShorts();
        print("Navigate to Shorts pages");
        ShortsPages shortsPages=new ShortsPages(driver);
        print("Choose the size");
        shortsPages.clickSizeM();
        print("Click button 'dodaj u korpu' ");
        shortsPages.clickDodajUKorpuButton();
        print("Navigate to base pages");
        BasePages basePages=new BasePages(driver);
        print("Open menu Shoping cart");
        basePages.clickShopingCart();
        print("Click button 'moja korpa' ");
        basePages.clickMojaKOrpaButton();
        print("Click button 'isprazni korpu' ");
        basePages.clickIsprazniKorpuButton();
        basePages.clickImagesDJak();
    }
     public String  findingSneakersThoroughTheLoop (String text) {
    sneakersList=driver.findElement(By.xpath("//div[@id='product-image-container']"));
       List<WebElement> sneakersListElements=sneakersList.findElements(By.xpath("//h4[text()='PATIKE 243137NC BASH LR NC']"));
        for (WebElement element : sneakersListElements ) {
            if (element.getText().contains(text)) ;
       }
       return null;
     }
}
