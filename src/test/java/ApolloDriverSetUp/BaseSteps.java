package ApolloDriverSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	
	public static WebDriver driver;
	public static ChromeOptions chrome;
	
	public static WebDriver chromedriver() {
		
		WebDriverManager.chromedriver().setup();
		chrome = new ChromeOptions();
		chrome.addArguments("--start-maximized");
		chrome.addArguments("disable-notifications");
		chrome.addArguments("disable-popup-blocking");
		chrome.addArguments("disable-blink-features-AutomationControlled");
		driver = new ChromeDriver(chrome);
		driver.get("https://www.apollo247.com/");
		return driver;
		
	}

	
//    public static WebDriver edgedriver() {
//		
//		WebDriverManager.edgedriver().setup();
//		edge = new EdgeOptions();
//		edge.addArguments("--start-maximized");
//		driver = new EdgeDriver(edge);
//		driver.get("https://www.apollo247.com/");
//		return driver;
//		
//	}

    

}
