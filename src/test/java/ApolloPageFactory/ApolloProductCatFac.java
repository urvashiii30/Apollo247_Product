package ApolloPageFactory;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApolloProductCatFac {

	WebDriver driver;

	public ApolloProductCatFac(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ExplicitWait(WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

//----------------------XPATH FOR ADD TO CART (SCENARIO 1)-------------------------

	@FindBy(xpath = "//a[@title=\"Personal Care\"]")
	WebElement personalCare;

	@FindBy(xpath = "//div[@class=\"Ov\"]//h2[text()='Hair 4U Shampoo, 100 ml']")
	WebElement productLink;

	@FindBy(xpath = "//div[@class=\"jV\"]//span")
	WebElement addToCart;

	@FindBy(xpath = "//div[@class=\"jV\"]//span[@class=\"kV\"]")
	WebElement viewCart;

//----------------------XPATH FOR SEARCH (SCENARIO 2)-------------------------

	@FindBy(xpath = "//li[contains(@class, 'Navigation_addOn__F_KmZ') and not(span[@class='Navigation_subTitle__GRqNx'])]")
	WebElement medicine;

	@FindBy(xpath = "//input[@id='searchProduct' and @placeholder='Search Medicines']")
	WebElement searchBar;

	@FindBy(xpath = "//input[@id='searchProduct' and @placeholder='Search medicines, brands and more']")
	WebElement search;

//----------------------XPATH FOR FIND PHARMACY (SCENARIO 3)-------------------------

	@FindBy(xpath = "//a[@title='Buy Medicines and Essentials']")
	WebElement buyButton;

	@FindBy(xpath = "//img[contains(@src, 'store_icon_image')]")
	WebElement findStore;

	@FindBy(xpath = "//div[@class='StorelLocatorlanding_pincodeSearchWrap__iiQX8']//input[@type='search']")
	WebElement enterPincode;

//----------------------XPATH FOR APOLLO PRODUCT (SCENARIO 4)-------------------------

	@FindBy(xpath = "//li[contains(@class, 'Navigation_addOn__F_KmZ') and not(span[@class='Navigation_subTitle__GRqNx'])]")
	WebElement medicine2;

	@FindBy(xpath = "//h2[text()='Apollo Products']")
	WebElement apolloProduct;

	@FindBy(id = "headlessui-disclosure-button-:R3iqekm:")
	WebElement category;

	@FindBy(xpath = "//label[text()='baby care']")
	WebElement babyCare;

	@FindBy(xpath = "//button[contains(@class, 'ProductSortWeb_sortRoot__k2sgt')]")
	WebElement sort;

	@FindBy(xpath = "//label[normalize-space(text())='Price : Low to High']/preceding-sibling::input[@type='radio']")
	WebElement lowToHigh;

//----------------------XPATH FOR Invalid Sort Function (SCENARIO 5)-------------------------

	@FindBy(xpath = "//a[@title='View All Brands']")
	WebElement viewAllBrands;

	@FindBy(xpath = "//a[@href='#l' and text()='l']")
	WebElement selectAlphabet;

	@FindBy(xpath = "//a[@href='/shop-by-brand/lakme']")
	WebElement selectBrand;

	@FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div/button")
	WebElement sortButton;

	@FindBy(xpath = "//label[text()='Price : High to Low']/preceding-sibling::input[@type='radio']")
	WebElement highToLow;

//----------------------METHODS FOR ADD TO CART (SCENARIO 1)-------------------------

	public void clickOnPersonalCare() {
		Actions actions = new Actions(driver);
		actions.moveToElement(personalCare).click().build().perform();

	}

	// Method to click on a product link
	public void clickOnProductLink() {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		productLink.click();
	}

	public void clickOnAddToCartButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(addToCart).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
	}

	public void clickOnViewCartButton() {
		viewCart.click();
	}

//----------------------METHODS FOR SEARCH (SCENARIO 2)-------------------------

	public void MedicineSection() {
		Actions actions = new Actions(driver);
		actions.moveToElement(medicine).click().build().perform();

	}

	public void SearchMedicine() {
		searchBar.click();
		search.click();
	}

	public void EnterMedicine(String Medicine) throws InterruptedException {
		search.sendKeys(Medicine);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(search));
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}

//----------------------METHODS FOR FIND PHARMACY (SCENARIO 3)-------------------------

	public void BuyMedicinesAndEssentials() {
		buyButton.click();
	}

	public void FindStores() {
		findStore.click();
	}

	public void EnterPincode(String pin) throws InterruptedException {
		ExplicitWait(enterPincode, 1000);
		enterPincode.sendKeys(pin);
		;
	}

//----------------------METHODS FOR APOLLO PRODUCT (SCENARIO 4)-------------------------

	public void MedicineSection2() {
		Actions actions = new Actions(driver);
		actions.moveToElement(medicine2).click().build().perform();
	}

	public void ShopByCategory() {
		Actions actions = new Actions(driver);
		actions.moveToElement(apolloProduct).click().build().perform();

	}

	public void Filter() {

		Actions actions = new Actions(driver);
		actions.moveToElement(category).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(category));
	}

	public void SelectCategory() {
		Actions actions = new Actions(driver);
		actions.moveToElement(babyCare).click().build().perform();
	}

	public void SortFunctionality() {
		Actions actions = new Actions(driver);
		actions.moveToElement(sort).click().build().perform();
		lowToHigh.click();
	}

//----------------------METHODS FOR Invalid Sort Function (SCENARIO 5)-------------------------

	public void ClickOnViewAllBrands() {
		viewAllBrands.click();
	}

	public void SelectAlphabet() {
		selectAlphabet.click();
	}

	public void SelectBrand() {
		selectBrand.click();
	}

	public void SortButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.elementToBeClickable(sortButton));
		sortButton.click();
	}

	public void SelectSortFunction() {
		highToLow.click();
	}

}
