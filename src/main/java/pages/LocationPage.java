package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocationPage extends BasePage{

    @FindBy(xpath = "//div[contains(@id,'glow-ingress')]")
    private WebElement delivery;

    @FindBy(xpath = "//span[@role='radiogroup']")
    private WebElement deliveryRadioGroup;

    @FindBy(xpath = "//li[@role='option']//a[contains(text(),'United States')]")
    private WebElement optionDeliveryRadioGroup;

    @FindBy(xpath = "//div[contains(@class,'popover-footer')]//input[contains(@class,'button-input')]")
    private WebElement continueDelivery;

    public LocationPage(WebDriver driver) { super(driver); }

    public WebElement getDeliveryButton() { return delivery;}

    public void clickDeliveryButton() { delivery.click();}

    public WebElement deliveryRadioGroupButton() { return deliveryRadioGroup;}

    public void clickDeliveryRadioGroupButton() { deliveryRadioGroup.click();}

    public void clickOptionDeliveryRadioGroup() { optionDeliveryRadioGroup.click();}

    public WebElement continueDeliveryButton() { return continueDelivery;}

    public void clickContinueDeliveryButton() { continueDelivery.click();}

}
