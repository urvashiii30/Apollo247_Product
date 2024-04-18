package ApolloStepDefinition;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ApolloDriverSetUp.BaseSteps;
import ApolloPageFactory.ApolloProductCatFac;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApolloProductCategory {

	static WebDriver driver;
	ApolloProductCatFac ap;

//--------------------------ADD TO CART------------------------------------------
	/*
	 * Created By: Urvashi Pathak 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a specific step to add a product to cart
	 */

	@Given("User is on the Apollo Pharmacy website")
	public void user_is_on_the_apollo_pharmacy_website() {
		driver = BaseSteps.chromedriver();
		ap = new ApolloProductCatFac(driver);
	}

	@When("User navigate to the {string} section under product categories")
	public void user_navigate_to_the_section_under_product_categories(String string) {
		ap.clickOnPersonalCare();
	}

	@And("User click on the desired personal care product")
	public void user_click_on_the_desired_personal_care_product() {
		ap.clickOnProductLink();
	}

	@And("User add the selected products to the cart")
	public void user_add_the_selected_products_to_the_cart() {
		ap.clickOnAddToCartButton();
	}

	@Then("The products should be successfully added to the cart")
	public void the_products_should_be_successfully_added_to_the_cart() {
		ap.clickOnViewCartButton();
		String msg = "https://www.apollopharmacy.in/otc/hair-4u-shampoo-100ml?doNotTrack=true";
		Assert.assertEquals(driver.getCurrentUrl(), msg);
	}

//---------------------------------SEARCH-----------------------------------------------
	/*
	 * Created By: Urvashi Pathak 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a specific step to search for a product
	 */

	@When("User navigate to the {string} section")
	public void user_navigate_to_the_section(String string) {
		ap.MedicineSection();
	}

	@And("User click on the search bar to search the medicine")
	public void user_click_on_the_search_bar_to_search_the_medicine() {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		ap.SearchMedicine();
	}

	@And("^User enters (.*) name")
	public void user_enters_name(String Medicine) throws InterruptedException {
		ap.EnterMedicine(Medicine);
	}

	@Then("The desired products should be displayed")
	public void the_desired_products_should_be_displayed() {
		String str = "https://www.apollopharmacy.in/";
		Assert.assertEquals(driver.getCurrentUrl(), str);
	}

//------------------------------------FIND PHARMACY----------------------------------
	/*
	 * Created By: Urvashi Pathak 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a specific step to find nearby stores
	 */

	@When("User navigate to the {string}")
	public void user_navigate_to_the(String string) {
		ap.BuyMedicinesAndEssentials();
	}

	@And("User click on {string} button")
	public void user_click_on_button(String string) {
		ap.FindStores();
	}

	@And("User enters Pincode of the localityPincode")
	public void user_enters_pincode_of_the_locality_pincode(DataTable Pincode) throws InterruptedException {
		List<List<String>> cells = Pincode.cells();

		ap.EnterPincode(cells.get(0).get(0));
	}

	@Then("the User should see nearby Apollo Pharmacy stores location and other details")
	public void the_user_should_see_nearby_apollo_pharmacy_stores_location_and_other_details() {
		String a = "https://www.apollopharmacy.in/medical-stores";
		Assert.assertEquals(driver.getCurrentUrl(), a);

	}

//------------------------------APOLLO PRODUCT---------------------------------------
	/*
	 * Created By: Urvashi Pathak 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a specific step to search only Apollo products
	 */

	@When("User navigate to the Medicines section")
	public void user_navigate_to_the_medicines_section() {
		ap.MedicineSection2();
	}

	@And("User clicks on Apollo Products under Shop By Category")
	public void user_clicks_on_apollo_products_under_shop_by_category() {
		// ap.scroll();
		ap.ShopByCategory();
	}

	@And("User selects Category Filter")
	public void user_selects_category_filter() {
		ap.Filter();
	}

	@And("User selects the Baby Care Category from the given list")
	public void user_selects_the_baby_care_category_from_the_given_list() {
		ap.SelectCategory();
	}

	@And("User Sort the products in ascending price range")
	public void user_sort_the_products_in_ascending_price_range() {
		ap.SortFunctionality();
	}

	@Then("the User should see all the products")
	public void the_user_should_see_all_the_products() {
		String abc = "https://www.apollopharmacy.in/shop-by-category/apollo-products";
		Assert.assertEquals(driver.getCurrentUrl(), abc);
	}

//--------------------------INVALID SORT FUNCTION--------------------------------------
	/*
	 * Created By: Urvashi Pathak 
	 * Reviewed By: Akasha KC 
	 * Motive: It is a specific step to aplly sort filter 
	 */

	@When("User navigate to the View All Brands section")
	public void user_navigate_to_the_view_all_brands_section() {
		ap.ClickOnViewAllBrands();
	}

	@And("User selects {string} alphabet to search the brand name")
	public void user_selects_alphabet_to_search_the_brand_name(String string) {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		ap.SelectAlphabet();
	}

	@And("User selects {string} brand to view the products")
	public void user_selects_brand_to_view_the_products(String string) {
		ap.SelectBrand();
	}

	@And("User click on sort button dropdown")
	public void user_click_on_sort_button_dropdown() {
		ap.SortButton();
	}

	@And("User selects the {string} sorting option")
	public void user_selects_the_sorting_option(String string) {
		ap.SelectSortFunction();
	}

	@Then("the products should be displayed in descending price range")
	public void the_products_should_be_displayed_in_descending_price_range() {
		Assert.assertTrue(false);
	}

	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenerio.attach(src, "image/png", scenerio.getName());
	}
}
