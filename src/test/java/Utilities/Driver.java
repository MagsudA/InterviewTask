package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

	public static WebDriver driver;
	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigurationReader.getProperty("browser");
			switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					break;

				case "chrome=headless":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
					break;

			}

		}

		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.close();

		}

	}
}
