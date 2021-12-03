package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class,'price-symbol')]")
    private List<WebElement> searchPriceSymbolProductsList;

    @FindBy(xpath = "//a[contains(@class,'dropdown-link')]")
    private List<WebElement> currencyList;

    @FindBy(xpath = "//a[contains(@class,'text')]//span[contains(@class,'text-normal')]")
    private List<WebElement> productDescriptionList;

    @FindBy(xpath = "//ul[contains(@aria-labelledby,'p_89-title')]//span[@dir='auto']")
    private List<WebElement> brandList;

    @FindBy(xpath = "//span[contains(@class,'price-whole')]")
    private List<WebElement> productDescriptionPriceList;

    @FindBy(xpath = "//div[@data-name=\"Subtotals\"]//span[contains(@class,'price sc-white')]")
    private List<WebElement> summaPrice;

    @FindBy(xpath = "//span[contains(@class,'product-price')]")
    private List<WebElement> priceList;

    @FindBy(xpath = "//ul[contains(@aria-labelledby,'p_36-title')]//span[contains(@class,'list')]")
    private List<WebElement> filterPriceList;

    public WebElement getFilterPrice(final int number){ return filterPriceList.get(number); }

    public SearchResultsPage(WebDriver driver) {  super(driver); }

    public List<WebElement> getSearchPriceSymbolProductsList() { return searchPriceSymbolProductsList; }

    public void getCurrencyDropDownList(final int currencyListNumber){
        currencyList.get(currencyListNumber).click();
    }

    public List<WebElement> getProductDescriptionList() { return productDescriptionList; }

    public List<WebElement> getBrandList(){ return brandList; }

    public List<WebElement> getProductDescriptionPriceList() { return productDescriptionPriceList; }

    public WebElement getProductDescriptionPrice(final int number) { return productDescriptionPriceList.get(number); }

    public WebElement getSummaPrice(final int summa){ return summaPrice.get(summa); }

    public WebElement getPriceList(final int productNumber){ return priceList.get(productNumber); }
}
