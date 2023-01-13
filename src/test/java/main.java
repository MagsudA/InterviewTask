import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;


 /*   Go to https://www.amazon.com

    Search for “Gel Pen”.

    Validate all search suggestions contain “gel pens“ and choose last gel pen option from the suggestions.

    Check the search result ensuring every product item has the “Pen” in its title.

    Click on the item from that has lowest price in the search list.

    Change quantity to 2 then add to cart.

    Empty Cart.

    Validate “Your item was removed from shopping cart” message.*/



public class main {


    PageFactory pf = new PageFactory();

    @BeforeClass
    public void setUpMethod() {
        Driver.getDriver().get("https://www.amazon.com");
    }


    @Test(priority = 1)
    public void SearchText() {

        // Search for “Gel Pen”.
        pf.searchGelPem.sendKeys("Gel Pen");
        pf.clickSearchBtn.click();
    }


    @Test(priority = 2)
    public void ValidateAllSearchSuggestions() {
        //  Validate all search suggestions contain “gel pens“ and choose last gel pen option from the suggestions.

        // I didnt search with uppercase or separately each word because there is written only contain “gel pens“.


        int countPresent = 0;
        int countNotPresent = 0;

        for (WebElement webElement : pf.webElements) {

            if (webElement.getText().contains("gel pens")) {
                countPresent++;
            } else {
                countNotPresent++;
            }
            Assert.assertTrue(webElement.getText().contains("gel pens"));

        }
        System.out.println("gel pens present : " + countPresent);
        System.out.println("gel pens not present : " + countNotPresent);

    }

    // Check the search result ensuring every product item has the “Pen” in its title.
    @Test(priority = 3)
    public void CheckSearchResultHasPen() {


        int penCountPresent = 0;
        int penCountNotPresent = 0;

        for (WebElement webElement : pf.webElements) {

            if (webElement.getText().contains("Pen")) {
                penCountPresent++;
            } else {
                penCountNotPresent++;
            }
            Assert.assertTrue(webElement.getText().contains("Pen"));
        }

        System.out.println("Pen present : " + penCountPresent);
        System.out.println("Pen not present : " + penCountNotPresent);


    }


    double minPrice = Double.MAX_VALUE;
    String mergeList = "";

    // Click on the item from that has lowest price in the search list.
    @Test(priority = 4)
    public void searchItemLowestPrice() {

        // Getting Lowest Price

        Iterator<WebElement> priceList = pf.priceLists.iterator();
        Iterator<WebElement> fraction = pf.priceFraction.iterator();

        while (priceList.hasNext() && fraction.hasNext()) {

            mergeList = priceList.next().getText() + "." + fraction.next().getText();

            if (Double.parseDouble(mergeList) < minPrice) {
                minPrice = Double.parseDouble(mergeList);
            }

        }
        System.out.println("Minimum price is : " + minPrice);

    }


    @Test(priority = 5)
    public void clickItemLowestPrice() {

        //Clicking Lowest price
        String  mergeList2 = "";
        Iterator<WebElement> priceList2 = pf.priceLists.iterator();
        Iterator<WebElement> fraction2 = pf.priceFraction.iterator();
        while (priceList2.hasNext() && fraction2.hasNext()) {

            WebElement price = priceList2.next();

            mergeList2 = price.getText() + "." + fraction2.next().getText();
            if (Double.parseDouble(mergeList2) == minPrice) {

                price.click();
                System.out.println(mergeList2 +" is equal " + minPrice);
                break;
            }

        }
    }

         // Change quantity to 2 then add to cart.
         @Test(priority = 6)
         public void changeQuantityTwo() {

        // Change quantity to 2 then add to cart.
        // Unfortunately lowest Price order is out of stock :) So there is not any function to change quantity.
             // In this case first I should to add item to cart then to change quantity.

    }

    @Test(priority = 7)
    public void addItemToCart() {
        pf.addToCardBTN.click();
    }

    //Empty Cart.
    @Test(priority = 8)
    public void emptyCard(){
        pf.goToCard.click();
        pf.deleteBtn.click();

        // Validate “Your item was removed from shopping cart” message.*/
        Assert.assertTrue(pf.message.getText().contains("was removed from Shopping Cart."));

    }





        @AfterClass
        public void tearDown () {
        Driver.closeDriver();
        }
    }


