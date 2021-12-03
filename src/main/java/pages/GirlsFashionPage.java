package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GirlsFashionPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-price']")
    private List<WebElement> productList;

    @FindBy(xpath = "//li[contains(@class,'dropdownAvailable')]//a[contains(@id,'size')]")
    private List<WebElement> sizeList;

    @FindBy(xpath = "//span[contains(@id,'size')]//span[contains(@data-action,'dropdown')]")
    private WebElement sizeDropdownButton;

    public GirlsFashionPage(WebDriver driver) { super(driver);}

    public WebElement getProductList(final int number){ return productList.get(number);}

    public void clickProduct(final int number) { productList.get(number).click();}

    public WebElement getSizeDropdownButton(){return sizeDropdownButton;}

    public void clickSizeDropdownButton() { sizeDropdownButton.click();}

    public WebElement getSizeList(final int size){ return sizeList.get(size);}

    public void clickSize(final int size) { sizeList.get(size).click();}

}
