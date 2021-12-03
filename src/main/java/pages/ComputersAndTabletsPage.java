package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComputersAndTabletsPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-price']")
    private List<WebElement> productList;

    public ComputersAndTabletsPage(WebDriver driver) { super(driver); }

    public WebElement getProductList(final int number){return productList.get(number);}

    public void clickProduct(final int number) {productList.get(number).click();}
}