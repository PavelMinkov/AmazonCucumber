package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GiftCardsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'feature_three')]//span[@dir='auto']")
    private List<WebElement> formatCardsCheckbox;

    @FindBy(xpath = "//a[contains(@href,'gift-card')]//span[contains(@class,'text-normal')]")
    private List<WebElement> cardsList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    public GiftCardsPage(WebDriver driver) { super(driver); }

    public WebElement getFormatCardsRadioButton( final int format){ return formatCardsCheckbox.get(format);}

    public List<WebElement> getFormatCardsRadioList(){ return formatCardsCheckbox;}

    public WebElement getCardsList(final int number){return cardsList.get(number);}

    public void clickCards(final int number) {cardsList.get(number).click();}
}