package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header[@id='navbar-main']")
    private WebElement header;

    @FindBy(xpath = "//a[contains(@href,'nav_logo')]")
    private WebElement logo;

    @FindBy(xpath = "//span[contains(@id,'location')]")
    private WebElement location;

    @FindBy(xpath = "//input[@name='field-keywords']")
    private WebElement searchField;

    @FindBy(xpath = "//input[contains(@id,'search-submit-button')]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(@class,'nav-link')]")
    private WebElement languageField;

    @FindBy(xpath = "//i[contains(@class,'icon-radio')]")
    private List<WebElement> languageListRadioButton;

    @FindBy(xpath = "//a[@id='nav-orders']")
    private WebElement orders;

    @FindBy(xpath = "//div[contains(@id,'cart-count')]")
    private WebElement cart;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountInCart;

    @FindBy(xpath = "//div[@id='nav-main']")
    private WebElement mainNavigation;

    @FindBy(xpath = "//a[contains(@id,'hamburger-menu')]")
    private WebElement menuHamburger;

    @FindBy(xpath = "//a[contains(@id,'hamburger-menu')]")
    private WebElement allButton;

    @FindBy(xpath = "//div[@id='hmenu-content']")
    private WebElement menu;

    @FindBy(xpath = "//div[contains(@class,'close')]")
    private WebElement closeMainNavigation;

    @FindBy(xpath = "//div[@id='navFooter']")
    private WebElement footer;

    @FindBy(xpath = "//span[@class='nav-line-2 ']")
    private WebElement accountList;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailOrMobileField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@id,'auth-email')]//div[@class='a-alert-content']")
    private WebElement textError;

    @FindBy(xpath = "//i[contains(@class,'icon-logo')]")
    private WebElement logoName;

    @FindBy(xpath = "//a[@data-menu-id='6']")
    private WebElement categoryComputers;

    @FindBy(xpath = "//a[contains(@href,'computers_tablets')][@class='hmenu-item']")
    private WebElement categoryComputersAndTablets;

    @FindBy(xpath = "//a[contains(@href,'gift-card')]")
    private WebElement giftCards;

    @FindBy(xpath = "//span[contains(@data-action,'dropdown-button')]")
    private WebElement currencyButton;

    @FindBy(xpath = "//input[contains(@class,'button-input')]")
    private WebElement saveChanges;

    @FindBy(xpath = "//div[contains(@class,'popover-inner')]")
    private WebElement currencyDropDown;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccount;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[contains(@id,'email-alert')]//div[contains(@class,'alert-content')]")
    private WebElement alertEmail;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(@id,'password-alert')]//div[contains(@class,'alert-content')]")
    private WebElement alertPassword;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement createYourAccount;

    @FindBy(xpath = "//select[contains(@class,'search-dropdown')]")
    private WebElement allDropDown;

    @FindBy(xpath = "//option[contains(text(),'Girls')]")
    private WebElement categoryGirls;

    @FindBy(xpath = "//div[contains(@id,'saved-cart-list')]")
    private WebElement savedCartList;

    @FindBy(xpath = "//a[contains(@aria-label,'Brand')]")
    private WebElement brandList;

    public void allDropDown() { allDropDown.isDisplayed(); }

    public void clickAllDropDown() { allDropDown.click(); }

    public void clickCategoryGirls() { categoryGirls.click(); }

    public HomePage(WebDriver driver) { super(driver); }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() { header.isDisplayed(); }

    public void isLogoVisible() { logo.isDisplayed(); }

    public void clickLogo() { logo.click(); }

    public void isLocationVisible() {
        location.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void searchField(final String keyword){searchField.sendKeys(keyword);}

    public void clickSearchButton() { searchButton.click(); }

    public void isLanguageFieldVisible() {
        languageField.isDisplayed();
    }

    public void clickLanguageFieldButton() { languageField.click(); }

    public WebElement getLanguageRadioButton(final int keyword){return languageListRadioButton.get(keyword);}

    public void clickLanguageListRadioButton(final int keyword) {languageListRadioButton.get(keyword).click();}

    public void isOrdersVisible() { orders.isDisplayed(); }

    public void isCartVisible() { cart.isDisplayed(); }

    public WebElement cartButton() { return cart; }

    public void clickCartButton() { cart.click(); }

    public String getAmountInCart() { return amountInCart.getText(); }

    public void isMainNavigationVisible() { mainNavigation.isDisplayed(); }

    public void isMenuHamburgerVisible() { menuHamburger.isDisplayed(); }

    public void clickMenuHamburgerButton() { menuHamburger.click(); }

    public WebElement getMenu(){ return menu;}

    public void isMenuVisible() { menu.isDisplayed(); }

    public void clickCloseMainNavigation() { closeMainNavigation.click(); }

    public void isFooterVisible() { footer.isDisplayed(); }

    public void isAccountListVisible() { accountList.isDisplayed(); }

    public WebElement getAccountList() { return accountList; }

    public void clickAccountList() { accountList.click(); }

    public void isEmailOrMobileFieldVisible() { emailOrMobileField.isDisplayed(); }

    public void clickContinueButton() { continueButton.click(); }

    public WebElement getEmailFieldError(){return textError;}

    public String getTextEmailField() { return textError.getText(); }

    public void clickLogoName() { logoName.click(); }

    public WebElement getCategoryComputers() { return categoryComputers; }

    public void clickCategoryComputers() { doubleClick(categoryComputers);  }

    public WebElement getCategoryComputersAndTablets() { return categoryComputersAndTablets; }

    public void clickCategoryComputersAndTablets() { categoryComputersAndTablets.click(); }

    public void clickGiftCards() { giftCards.click(); }

    public void clickCurrencyButton() { currencyButton.click(); }

    public WebElement currencyDropDown() { return currencyDropDown; }

    public WebElement saveChangesButton() { return saveChanges; }

    public void clickSaveChangesButton() { saveChanges.click(); }

    public void clickCreateAccountButton() { createAccount.click(); }

    public void emailField(final String email){emailField.sendKeys(email);}

    public WebElement alertEmail() { return alertEmail; }

    public void passwordField(final String password){passwordField.sendKeys(password);}

    public WebElement alertPassword() { return alertPassword; }

    public void clickCreateYourAccountButton() { createYourAccount.click(); }

    public WebElement getSavedCartList() { return savedCartList; }

    public void clickBrandList() { brandList.click(); }

    public WebElement getBrandList() { return brandList; }
}
