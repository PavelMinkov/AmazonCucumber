package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 90;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    LocationPage locationPage;
    ComputersAndTabletsPage computersAndTabletsPage;
    GiftCardsPage giftCardsPage;
    GirlsFashionPage girlsFashionPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.isHeaderVisible();
    }

    @And("User checks logo visibility")
    public void userChecksLogoVisibility() {
        homePage.isLogoVisible();
    }

    @And("User checks location visibility")
    public void userChecksLocationVisibility() {
        homePage.isLocationVisible();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User checks language field visibility")
    public void userChecksLanguageFieldVisibility() {
        homePage.isLanguageFieldVisible();
    }

    @And("User checks orders visibility")
    public void userChecksOrdersVisibility() {
        homePage.isOrdersVisible();
    }

    @And("User checks cart visibility")
    public void userChecksCartVisibility() {
        homePage.isCartVisible();
    }

    @And("User checks main navigation visibility")
    public void userChecksMainNavigationVisibility() {
        homePage.isMainNavigationVisible();
    }

    @And("User checks 'Menu Hamburger' visibility")
    public void userChecksMenuHamburgerVisibility() {
        homePage.isMenuHamburgerVisible();
    }

    @When("User click 'Menu Hamburger' button")
    public void userClickMenuHamburgerButton() {
        homePage.clickMenuHamburgerButton();
    }

    @And("User checks menu popup visibility")
    public void userChecksMenuPopupVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMenu());
        homePage.isMenuVisible();
    }

    @When("User close 'Main Navigation' button")
    public void userCloseMainNavigationButton() {
        homePage.clickCloseMainNavigation();
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks account list visibility")
    public void userChecksAccountListVisibility() {
        homePage.isAccountListVisible();
    }

    @When("User click account List")
    public void userClickAccountList() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getAccountList());
        homePage.clickAccountList();
    }

    @And("User checks email or mobile field visibility")
    public void userChecksEmailOrMobileFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isEmailOrMobileFieldVisible();
    }

    @And("User click 'Continue' button")
    public void userClickContinueButton() {
        homePage.clickContinueButton();
    }

    @Then("User checks that sign in form have {string}")
    public void userChecksThatSignInFormHaveWarning(final String expectedText) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getEmailFieldError());
        assertEquals(homePage.getTextEmailField(), expectedText);
    }

    @And("User click logo name")
    public void userClickLogoName() {
        homePage.clickLogoName();
    }

    @And("User click language button")
    public void userClicksLanguageButton() {
        homePage.clickLanguageFieldButton();
    }

    @And("User click language radio {int} button")
    public void userClickLanguageRadioButton(final int keyword) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getLanguageRadioButton(keyword));
        homePage.clickLanguageListRadioButton(keyword);
    }

    @Then("User checks that current url contains {string} language")
    public void userChecksThatCurrentUrlContainsEsLanguage(final String language) {
        assertTrue(driver.getCurrentUrl().contains(language));
    }

    @And("User input {string} in search field")
    public void userInputKeywordInSearchField(final String keyword) {
        homePage.searchField(keyword);
    }

    @When("User click search button")
    public void userClickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that current url contains{string}")
    public void userChecksThatCurrentUrlContainsSearch(final String search) {
        assertTrue(driver.getCurrentUrl().contains(search));
    }

    @And("User click 'Computers' button")
    public void userClickComputersButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getCategoryComputers());
        homePage.clickCategoryComputers();
    }

    @And("User click 'ComputersAndTablets' button")
    public void userClickComputersAndTabletsButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getCategoryComputersAndTablets());
        homePage.clickCategoryComputersAndTablets();
    }

    @And("User choose product and click")
    public void userChooseProductAndClick() {
        computersAndTabletsPage = pageFactoryManager.getComputersAndTabletsPage();
        computersAndTabletsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        computersAndTabletsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,computersAndTabletsPage.getProductList(2));
        computersAndTabletsPage.clickProduct(2);
    }

    @And("User click 'Add to Cart' button on product")
    public void userClickAddToCartButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickAddToCartButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.cartButton());
        homePage.clickCartButton();
    }

    @And("User click 'Cart' button")
    public void userClickCartButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.cartButton());
        homePage.clickCartButton();
    }

    @Then("User checks that amount in cart correct{string}")
    public void userChecksThatAmountInCartCorrectAmount(final String amount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.cartButton());
        assertEquals(homePage.getAmountInCart(), amount);
    }

    @When("User click 'Delete' button on product")
    public void userClickDeleteButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.deleteProductFromCartButton());
        productPage.clickDeleteProductFromCartButton();
    }

    @When("User click 'Gift Cards' button")
    public void userClickGiftCardsButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickGiftCards();
    }

    @And("User click Greeting Card checkbox")
    public void userClickGreetingCardCheckbox() {
        String format="Greeting Card";
        giftCardsPage=pageFactoryManager.getGiftCardsPage();
        giftCardsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,giftCardsPage.getFormatCardsRadioButton(1));
        for (WebElement webElement: giftCardsPage.getFormatCardsRadioList()){
            if (webElement.getText().contains(format)){
                webElement.click();
                break;
            }
        }
    }

    @And("User choose product from 'Greeting Card' and click")
    public void userChooseProductFromGreetingCardAndClick() {
        giftCardsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,giftCardsPage.getCardsList(0));
        giftCardsPage.clickCards(0);
    }

    @Then("User click 'Delivery' button")
    public void userClickDeliveryButton() {
        locationPage=pageFactoryManager.getLocationPage();
        locationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,locationPage.getDeliveryButton());
        locationPage.clickDeliveryButton();
    }

    @And("User click delivery radio group")
    public void userClickDeliveryRadioGroup() {
        locationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,locationPage.deliveryRadioGroupButton());
        locationPage.clickDeliveryRadioGroupButton();
    }

    @And("User click different location")
    public void userClickDifferentLocation() {
        locationPage.clickOptionDeliveryRadioGroup();
    }

    @Then("User click 'Continue Delivery' button")
    public void userClickDoneButton() {
        locationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,locationPage.continueDeliveryButton());
        locationPage.clickContinueDeliveryButton();
    }

    @And("User click currency button")
    public void userClickCurrencyButton() {
        homePage.clickCurrencyButton();
    }

    @And("User choose currency {int} and click button")
    public void userChooseCurrencyKeywordCurrencyAndClickButton(final int keywordCurrency) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.currencyDropDown());
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.getCurrencyDropDownList(keywordCurrency);
    }

    @And("User click 'Save changes' button")
    public void userClickSaveChangesButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.saveChangesButton());
        homePage.clickSaveChangesButton();
    }

    @Then("User checks that currency product contains{string}")
    public void userChecksThatCurrencyProductContainsSearch(final String search) {
        for (WebElement webElement: searchResultsPage.getSearchPriceSymbolProductsList()){
            assertTrue(webElement.getText().contains(search));
        }
    }

    @And("User click 'Create account' button")
    public void userClickCreateAccountButton() {
        homePage.clickCreateAccountButton();
    }

    @And("User put email field {string}")
    public void userContainEmailFieldEmail(final String email) {
        homePage.emailField(email);
    }

    @And("User put password field {string}")
    public void userContainPasswordFieldPassword(final String password) {
        homePage.passwordField(password);
    }

    @When("User click 'Create your account' button")
    public void userClickCreateYourAccountButton() {
        homePage.clickCreateYourAccountButton();
    }

    @Then("User checks that email field contain data is incorrect {string}")
    public void userChecksThatEmailFieldContainDataIsIncorrectWarningEmail(final String alertEmail) {
        assertTrue(homePage.alertEmail().getText().contains(alertEmail));
    }

    @Then("User checks that password field contain data is incorrect {string}")
    public void userChecksThatPasswordFieldContainDataIsIncorrectWarningPassword(final String alertPassword) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.alertPassword());
        assertEquals(homePage.alertPassword().getText(), alertPassword);
    }

    @And("User checks dropdown 'All' visibility")
    public void userChecksDropdownAllVisibility() {
        homePage.allDropDown();
    }

    @When("User click dropdown 'All'")
    public void userClickDropdownAll() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickAllDropDown();
    }

    @And("User choose and click category 'Girls' Fashion'")
    public void userChooseAndClickCategoryGirlsFashion() {
        homePage.clickCategoryGirls();
    }

    @And("User choose shoes and click")
    public void userChooseShoesAndClick() {
        girlsFashionPage=pageFactoryManager.getGirlsFashionPage();
        girlsFashionPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        girlsFashionPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,girlsFashionPage.getProductList(0));
        girlsFashionPage.clickProduct(0);
    }

    @And("User choose and click size shoes")
    public void userChooseAndClickSizeShoes() {
        girlsFashionPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,girlsFashionPage.getSizeDropdownButton());
        girlsFashionPage.clickSizeDropdownButton();
        girlsFashionPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,girlsFashionPage.getSizeList(6));
        girlsFashionPage.clickSize(6);
    }

    @And("User choose and click {int}")
    public void userChooseAndClickQuantity(final int quantity) {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getQuantity());
        productPage.clickQuantity();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getSelectQuantity(quantity-1));
        productPage.selectQuantity(quantity-1);
    }

    @And("User click 'Save For Later' button on product")
    public void userClickSaveForLaterButtonOnProduct() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getSaveForLater());
        productPage.clickSaveForLater();
    }

    @Then("User checks that 'Wish List' contain {string}")
    public void userChecksThatSavedCartListContainSearch(final String search) {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getSavedCartList());
        assertTrue(homePage.getSavedCartList().getText().contains(search));
    }

    @And("User click 'Move to cart' button")
    public void userClickMoveToCartButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getMoveToCart());
        productPage.clickMoveToCart();
    }

    @Then("User click 'logo' button")
    public void userClickLogoButton() {
        homePage.clickLogo();
    }

    @And("User click 'See more Brand'")
    public void userClickSeeMoreBrand() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,homePage.getBrandList());
        homePage.clickBrandList();
    }

    @And("User click {string} checkbox")
    public void userClickBrandCheckbox(final String brand) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        for (WebElement webElement: searchResultsPage.getBrandList()){
            if (webElement.getText().contains(brand)){
                webElement.click();
                break;
            }
        }
    }

    @Then("User checks brand{string}")
    public void userChecksBrand(final String search) {
        for (WebElement webElement: searchResultsPage.getProductDescriptionList()){
            assertTrue(webElement.getText().toLowerCase().contains(search.toLowerCase()));
        }
    }

    @And("User click 'Filter Price' checkbox {int}")
    public void userClickFilterPriceFilterCheckbox(final int number) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,searchResultsPage.getFilterPrice(number-1));
        searchResultsPage.getFilterPrice(number-1).click();

    }

    @Then("User checks price")
    public void userPriceBrand() {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,searchResultsPage.getProductDescriptionPrice(0));
        for (WebElement webElement: searchResultsPage.getProductDescriptionPriceList()){
            System.out.println(webElement.getText()+"--");
            assertTrue(parseInt(webElement.getText()) >= 20 && parseInt(webElement.getText()) <=150 );
            if(parseInt(webElement.getText()) < 50 )
                System.out.println(parseInt(webElement.getText()));
            if (parseInt(webElement.getText()) >100 )
                System.out.println(parseInt(webElement.getText()));
        }
    }

    @Then("User checks summa price {int}")
    public void userChecksSummaPrice(final int quantity) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        double price=parseDouble(searchResultsPage.getPriceList(0).getText()
                .replace("$","").replace(",",""));
        double sumPrice=parseDouble(searchResultsPage.getSummaPrice(0).getText()
                .replace("$","").replace(",",""));
        assertEquals(price*quantity,sumPrice,0);
    }
}