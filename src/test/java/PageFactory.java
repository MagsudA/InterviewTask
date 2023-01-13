import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactory {


    public PageFactory(){

            org.openqa.selenium.support.PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchGelPem;

    @FindBy(id="nav-search-submit-button")
    public WebElement clickSearchBtn;

    @FindBy(how = How.XPATH, using = "//div[@data-component-type='s-search-result']")
    public List<WebElement> webElements;

    @FindBy(how = How.XPATH, using = "//div[@data-component-type='s-search-result']//span//span[@class='a-price-whole']")
    public List<WebElement> priceLists;

    @FindBy(how = How.XPATH, using = "//div[@data-component-type='s-search-result']//span//span[@class='a-price-fraction']")
    public  List<WebElement> priceFraction;

    @FindBy(id="add-to-cart-button")
    public WebElement addToCardBTN;

    @FindBy(className = "a-button-text")
    public WebElement goToCard;

    @FindBy(how =How.XPATH , using = "//input[@value='Delete']")
    public WebElement deleteBtn;

    @FindBy(how =How.XPATH , using = "(//span[@class='a-size-base'])[1]")
    public WebElement message;

}
