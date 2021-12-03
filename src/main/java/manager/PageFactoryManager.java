package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver); }

    public ProductPage getProductPage(){ return new ProductPage(driver);}

    public SearchResultsPage getSearchResultsPage(){ return new SearchResultsPage(driver);}

    public LocationPage getLocationPage(){ return new LocationPage(driver);}

    public ComputersAndTabletsPage getComputersAndTabletsPage() { return new ComputersAndTabletsPage(driver); }

    public GiftCardsPage getGiftCardsPage(){ return new GiftCardsPage(driver);}

    public GirlsFashionPage getGirlsFashionPage(){ return new GirlsFashionPage(driver);}
}
