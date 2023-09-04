package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Topic_04_Relative_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void TC_01_Relative() {
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
		
		//login button
		
		By loginButtonBy = By.cssSelector("button.logib-button");
		WebElement loginButtonElement = driver.findElement(By.cssSelector("button.logib-button"));
		
		//Remember Me checkbox
		
		By rememberMeCheckboxBy = By.id("RememberMe");
		
		//Forgot Password
		
		WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));
		
		//Password textbox
		
		By passwordTextboxBy = By.cssSelector("input#Password");
		
		//GUI (location/ position)
		WebElement rememberMeTextElement = driver
				.findElement(RelativeLocator.with(By.tagName("label"))
				.above(loginButtonBy)
				.toRightOf(rememberMeCheckboxBy)
				.toLeftOf(forgotPasswordElement)
				.below(passwordTextboxBy)
				.near(forgotPasswordElement));
		System.out.print(rememberMeTextElement.getText());
		
		List <WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
		System.out.print(allLinks.size());
		
	}
	public void TC_02_() {
		
	}
	public void TC_03_() {
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}