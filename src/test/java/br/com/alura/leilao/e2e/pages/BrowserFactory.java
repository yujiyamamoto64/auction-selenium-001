package br.com.alura.leilao.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BrowserFactory {

	public WebDriver createWebDriver() {
		String webdriver = System.getProperty("browser", "htmlunit");
		switch (webdriver) {
		case "chrome":
			return initChromeDriver();
		default:
			return new HtmlUnitDriver();
		}
	}
	
	private WebDriver initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		return new ChromeDriver();
	}
}
