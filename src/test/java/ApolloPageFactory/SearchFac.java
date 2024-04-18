package ApolloPageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFac {
	
	WebDriver driver;
	public SearchFac(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[contains(@class, 'Navigation_addOn__F_KmZ') and not(span[@class='Navigation_subTitle__GRqNx'])]")
	WebElement medicine;
	
	@FindBy(xpath="//input[@id='searchProduct' and @placeholder='Search Medicines']")
	WebElement searchBar;
	
	@FindBy(xpath="//input[@id='searchProduct' and @placeholder='Search medicines, brands and more']")
	WebElement search;
	
	public void MedicineSection()
	{
		Actions actions = new Actions(driver);
        actions.moveToElement(medicine).click().build().perform();
		
	}
	
	public void SearchMedicine()
	{
		searchBar.click();
		search.click();
	}
	
	public void EnterMedicine(String Medicine) throws InterruptedException
	{
		search.sendKeys(Medicine);
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
	
	


	

}
