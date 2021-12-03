package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@data-action='delete']")
    private WebElement deleteProductFromCartButton;

    @FindBy(xpath = "//input[contains(@data-action,'save')]")
    private WebElement saveForLater;

    @FindBy(xpath = "//span[contains(@class,'button')]//input[@data-action='move-to-cart']")
    private WebElement moveToCart;

    @FindBy(xpath = "//div[@id='selectQuantity']//span[contains(@class,'text')]")
    private WebElement quantity;

    @FindBy(xpath = "//a[contains(@id,'quantity')]")
    private List<WebElement> selectQuantity;

    public ProductPage(WebDriver driver) { super(driver); }

    public WebElement getAddToCartButton() { return addToCartButton;}

    public void clickAddToCartButton() { addToCartButton.click();}

    public WebElement deleteProductFromCartButton() { return deleteProductFromCartButton;}

    public void clickDeleteProductFromCartButton() { deleteProductFromCartButton.click();}

    public WebElement getSaveForLater() { return saveForLater;}

    public void clickSaveForLater() { saveForLater.click();}

    public WebElement getMoveToCart() { return moveToCart;}

    public void clickMoveToCart() { moveToCart.click();}

    public WebElement getQuantity() { return quantity;}

    public void clickQuantity() { quantity.click();}

    public WebElement getSelectQuantity(final int quantity) { return selectQuantity.get(quantity);}

    public void selectQuantity(final int quantity) { selectQuantity.get(quantity).click();}
}
