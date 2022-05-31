import Pages.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoriTests extends BaseTests {

    @Test
 public void addSneakersingToShopingCart(){
       ChromeDriver driver=openChromeDriver();
        try {
            print("succeffuly login");
            login(driver);
            print("navigate to Sneakers Pages");
            InventoriPages inventoriPages=new InventoriPages(driver);
            print("searching field");
            inventoriPages.enterTextField("patike");
            print("click searching button");
            inventoriPages.clickSearchButton();
            SneakersingPages sneakersingPages=new SneakersingPages(driver);
            print("click in the sneakersing field");
            sneakersingPages.clickSneakersing();
            print("size for sneakers");
            sneakersingPages.clickSize("41");
            print("click the buy button");
            sneakersingPages.clickShopingCartButton();
            print("navigate to base pages");
            BasePages basePages=new BasePages(driver);
            print("Clic shoping cart");
            basePages.clickShopingCart();
            print("get number for shoping cart");
            String actualNumberFromC=basePages.getNumberFromShopingCart();
            print("the number in shoping cart is one");
            assert actualNumberFromC.equals("1"):"Wrong number in shoping cart";

        }finally {
          driver.quit();
        }
    }

        @Test
    public void dropDownMenu(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to inventori page");
            InventoriPages inventoriPages=new InventoriPages(driver);
            print("Cookies in down field");
            inventoriPages.clickCookies();
            print("Clikc the sport field");
            inventoriPages.clickSportoviField();
            print("Click the ickon fudbal");
            inventoriPages.clickOnTheIckonFudbal();
            print("Sort items by price: ceni (rastuće)");
            inventoriPages.sortItemsByText(Strings.DropDown_By_Price);
            Assert.assertEquals(driver.getCurrentUrl(),Strings.Url_Fudbal_Page);

        }finally {
            driver.quit();
        }

    }

    @Test
    public void addAndRemoveItemsInShopingCArt(){
        ChromeDriver driver=openChromeDriver();
    try {
        print("Succeffuly login");
        login(driver);
        print("Navigate to inventori pages");
      InventoriPages inventoriPages=new InventoriPages(driver);
        print("Open sportovi field");
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
        String actualNumberFromC=basePages.getNumberFromShopingCart();
        assert actualNumberFromC.equals("0"):"Wrong number in shoping cart";
    }finally {
       driver.quit();
    }

     }
     @Test
    public void addToShopingCart(){
        ChromeDriver driver=openChromeDriver();
        try {
            login(driver);
            InventoriPages inventoriPages=new InventoriPages(driver);
            inventoriPages.testing();

        }finally {
          //  driver.quit();
        }
     }
     @Test
     public void removeItems(){
        ChromeDriver driver=openChromeDriver();
        try {
            BasePages basePages=new BasePages(driver);
            login(driver);
            InventoriPages inventoriPages=new InventoriPages(driver);
            inventoriPages.removeItemsInShopingCArt();
            String actualNumberFromC=basePages.getNumberFromShopingCart();
            assert actualNumberFromC.equals("0"):"Wrong number in shoping cart";
        }finally {
            driver.quit();
        }
     }

}
