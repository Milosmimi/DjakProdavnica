import Pages.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTests extends BaseTests {

    @Test
    /*
    Test steps:
    1.You are in Djak pages
    2.Succeffuly login
    3.You're on inventori pages
    4.Enter text in the searching field
    5.Click searching button
    6.You're on sneakersing pages
    7.Choose sneakers
    8.Choose size sneakers
    9.Buy sneakers
    10.You're on Base pages
    11.Click shoping cart
    12.Get number for shoping cart
    13.Verifice that is number in shoping cart is one
     */

 public void addSneakersingToShopingCart(){
       ChromeDriver driver=openChromeDriver();
        try {
            print("succeffuly login");
            login(driver);
            print("navigate to Sneakers Pages");
            InventoryPages inventoryPages=new InventoryPages(driver);
            print("searching field");
            inventoryPages.enterTextField(Strings.Sneakers);
            print("click searching button");
            inventoryPages.clickSearchButton();
            SneakersingPages sneakersingPages=new SneakersingPages(driver);
            print("click in the sneakersing field");
            sneakersingPages.clickSneakers();
            print("size for sneakers");
            sneakersingPages.clickSize(Strings.Size_Sneakers);
            print("click the buy button");
            sneakersingPages.clickShopingCartButton();
            print("navigate to base pages");
            BasePages basePages=new BasePages(driver);
            print("Click shoping cart");
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
        /*
            Test steps

        1.You are in Djak pages
        2.You are in Inventori pages
        3.Click cookies button "SLAZEM SE"
        4.Click in field sport
        5.Click in the ickon fudbal
        6.Sort items by price: ceni (rastuće)
        7.Verifice that items is sort by price from botton to top
         */
    public void dropDownMenu(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to inventori page");
            InventoryPages inventoryPages=new InventoryPages(driver);
            print("Cookies in down field");
            inventoryPages.clickCookies();
            print("Clikc the sport field");
            inventoryPages.clickSportoviField();
            print("Click the ickon fudbal");
            inventoryPages.clickOnTheIckonFudbal();
            print("Sort items by price: ceni (rastuće)");
            inventoryPages.sortItemsByText(Strings.DropDown_By_Price);
            print("Verifice that items is sort by price from botton to top");
            String dropDownField=inventoryPages.sortItemsByText(Strings.DropDown_By_Price);
            assert dropDownField.equals(Strings.DropDown_By_Price):"ERROR" + Strings.DropDown_By_Price + "ACTUAL" + dropDownField;


        }finally {
            driver.quit();
        }

    }

    @Test
        /*
    Test steps:
    1.You are in DJak pages
    2.Succeffuly login
    3.You're on inventori pages
    4.Open sport field
    5.Click fitnes icon
    6.You're on fitnes pages
    7.Mark the field "MUSKI"
    8.Choose blue shorts
    9.You're on shorts pages
    10.Choose the size shorts
    11.Add shorts in the shoping cart
    12.You're on Base pages
    13.Open menu Shoping cart
    14.Click button 'moja korpa'
    15.Click button 'isprazni korpu'
    16.Back in frist pages
    17.Get number from shoping cart
    18.Verifice the shoping cart is empty
     */
    public void addAndRemoveItemsInShopingCArt(){
        ChromeDriver driver=openChromeDriver();
    try {
        print("Succeffuly login");
        login(driver);
        print("Navigate to inventori pages");
      InventoryPages inventoryPages=new InventoryPages(driver);
        print("Open sportovi field");
      inventoryPages.clickSportoviField();
        print("Click fitnes icon");
      inventoryPages.clickFitnesIcon();
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
        print("Click images Djak");
      basePages.clickImagesDJak();
        print(" Get number from shoping cart ");
        String actualNumberFromC=basePages.getNumberFromShopingCart();
        print("Verifice thad shoping cart is empty");
        assert actualNumberFromC.equals("0"):"Wrong number in shoping cart";
    }finally {
       driver.quit();
    }

     }
     @Test
    public void addToShopingCart(){
        ChromeDriver driver=openChromeDriver();
        try {
            BasePages basePages=new BasePages(driver);
            login(driver);
            InventoryPages inventoryPages=new InventoryPages(driver);
            inventoryPages.testing();
            print("get number for shoping cart");
            String actualNumberFromC=basePages.getNumberFromShopingCart();
            print("the number in shoping cart is one");
            assert actualNumberFromC.equals("1"):"Wrong number in shoping cart";
        }finally {
           driver.quit();
        }
     }
     @Test
             /*
    Test steps:
    1.You are in DJak pages
    2.Succeffuly login
    3.You're on inventori pages
    4.Open sport field
    5.Click fitnes icon
    6.You're on fitnes pages
    7.Mark the field "MUSKI"
    8.Choose blue shorts
    9.You're on shorts pages
    10.Choose the size shorts
    11.Add shorts in the shoping cart
    12.You're on Base pages
    13.Open menu Shoping cart
    14.Click button 'moja korpa'
    15.Click button 'isprazni korpu'
    16.Back in frist pages
    17.Get number from shoping cart
    18.Verifice the shoping cart is empty
     */
     public void removeItems(){
        ChromeDriver driver=openChromeDriver();
        try {
            print("Navigate to base pages");
            BasePages basePages=new BasePages(driver);
            print("Suceeffuly login");
            login(driver);
            print("Navigate to inventory pages");
            InventoryPages inventoryPages=new InventoryPages(driver);
            print("Add the items to the shoping cart and remove it");
            inventoryPages.removeItemsInShopingCArt();
            print("Get number from shoping cart");
            String actualNumberFromC=basePages.getNumberFromShopingCart();
            print("Verifice thad shoping cart is empty");
            assert actualNumberFromC.equals("0"):"Wrong number in shoping cart";
        }finally {
            driver.quit();
        }
     }
     @Test
     /*
      Steps:

      1.Open djak pages
      2.Succeffuly login
      3.Open inventory pages
      4.Click 'nova kolekcija' field
      5.Finding sneakrs
      6.Click on the sneaker
      7.Verifice 'kappa' sneakers pages


      */
    public void trackSneakersThruLoop(){
         ChromeDriver driver=openChromeDriver();
         try {
             print("Succeffuly login");
             login(driver);
             print("Navigate to inventory pages");
             InventoryPages inventoryPages=new InventoryPages(driver);
             print("Click nova kolekcija field");
             inventoryPages.clickNovaKolekcija();
             print("Finding sneakers");
             inventoryPages.findingSneakersThoroughTheLoop(Strings.Kappa_Sneakers);
             print("Click kappa sneaks");
             inventoryPages.clickKappaSneaks();
             print("Verify that you are on kappa pages");
             Assert.assertEquals(driver.getCurrentUrl(),Strings.Kappa_Sneakers_URL,"Wrong URL");

         }finally {driver.quit();

         }
     }

}
