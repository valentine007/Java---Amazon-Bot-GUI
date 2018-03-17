package service;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BotService {
private static final String BASE_URL = "https://www.amazon.com";
	
	public static WebDriver getFirefoxDriver() {
		String mainDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");
		String driverPath = mainDir + sep + "lib" + sep + "geckodriver.exe"; // Путь к библиотеке-драйверу

		System.setProperty("webdriver.gecko.driver", driverPath);

		FirefoxOptions options = new FirefoxOptions();

		// options.addArguments("--start-maximized");
		// DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(capabilityName, value);

		WebDriver driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		// Ожидание загрузки браузера
		Timer.waitSec(4);
		driver.manage().window().maximize(); //Максимизация окна

		return driver;
	}
	
public static WebDriver registerAccount(WebDriver driver, Account account) {
		
		//Переход по базовому адресу
		driver.get(BASE_URL);
		Timer.waitSec(4);
		
		//Поиск элемента
		WebElement registerDivElement = driver.findElement(By.id("nav-flyout-ya-newCust"));
		WebElement registerLinkElement = registerDivElement.findElement(By.tagName("a"));
		String registerLink = registerLinkElement.getAttribute("href");
		
		driver.get(registerLink);
		Timer.waitSec(4);
		
		//Заполняем форму регистрации
		WebElement inputNameElement = driver.findElement(By.id("ap_customer_name"));
		inputNameElement.sendKeys(account.getFirstName() + " " + account.getSecondName());
		Timer.waitSec(4);
		
		WebElement inputEmailElement = driver.findElement(By.id("ap_email"));
		inputEmailElement.sendKeys(account.getEmail());
		Timer.waitSec(4);
		
		WebElement inputPassworsElement = driver.findElement(By.id("ap_password"));
		inputPassworsElement.sendKeys(account.getPassowrd());
		Timer.waitSec(4);
		
		WebElement inputChecklElement = driver.findElement(By.id("ap_password_check"));
		inputChecklElement.sendKeys(account.getPassowrd());
		Timer.waitSec(4);
		
		WebElement inputSubmitlElement = driver.findElement(By.id("continue"));
		inputSubmitlElement.submit();
		
		//Обрабатываем ответ от сервера
		Timer.waitSec(4);
		String currentURL = driver.getCurrentUrl();
		driver.get(currentURL);																	//Считываем DOM в найш драйвер
		
		if(driver.getPageSource().contains("Hello, "))
			return driver;
		
		driver.quit();
		return null;
	}
	
	public static WebDriver addGoodToCart(WebDriver driver, String asin, Account account, Good good) {
		//Переход по базовому адресу
		driver.get(BASE_URL);
		Timer.waitSec(3);
		
		//Поиск элемента
		WebElement signinDivElement = driver.findElement(By.id("nav-flyout-ya-signin"));
		WebElement signinLinkElement = signinDivElement.findElement(By.tagName("a"));
		String signinLink = signinLinkElement.getAttribute("href");
		
		driver.get(signinLink);
		Timer.waitSec(3);
		
		//Заполняем форму входа
		WebElement inputEmailElement = driver.findElement(By.id("ap_email"));
		inputEmailElement.sendKeys(account.getEmail());
		Timer.waitSec(3);
		
		WebElement inputSubmitlElement = driver.findElement(By.id("continue"));
		inputSubmitlElement.submit();
		Timer.waitSec(3);
		
		WebElement inputPassworsElement = driver.findElement(By.id("ap_password"));
		inputPassworsElement.sendKeys(account.getPassowrd());
		Timer.waitSec(3);

		WebElement inputSubmitlElement2 = driver.findElement(By.id("signInSubmit"));
		inputSubmitlElement2.submit();
		Timer.waitSec(3);
		
		WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys(good.getAsin());
		Timer.waitSec(3);
		
		WebElement navSearchlSubmit = driver.findElement(By.id("nav-search-submit-text"));
		navSearchlSubmit.submit();
		Timer.waitSec(3);
		
		WebElement resultsElement = driver.findElement(By.id("result_0"));
		WebElement resultsElement2 = resultsElement.findElement(By.tagName("a"));
		String addToCartLink = resultsElement2.getAttribute("href");
		
		driver.get(addToCartLink);
		Timer.waitSec(4);
		
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.submit();
		
		Timer.waitSec(4);
		String currentURL = driver.getCurrentUrl();
		driver.get(currentURL);																	//Считываем DOM в найш драйвер
		
		if(driver.getPageSource().contains("Added to Cart"))
			return driver;
		
		driver.quit();
		return null;
	}

}
