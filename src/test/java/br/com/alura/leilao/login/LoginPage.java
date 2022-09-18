package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		browser.navigate().to(URL_LOGIN);
	}

	public void quit() {
		this.browser.quit();
	}

	public void fillLoginForm(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage login() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isLoginPage() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public Object getUserLoggedName() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void goToLeiloesPage() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean containsText(String string) {
		return browser.getPageSource().contains(string);
	}

	public boolean isLoginErrorPage() {
		return browser.getCurrentUrl().equals(URL_LOGIN + "?error");
	}

}
