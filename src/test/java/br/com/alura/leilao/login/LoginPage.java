package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {

	private static final String URL_LOGIN = "http://localhost:8080/login";

	public LoginPage() {
		super(null);
		browser.navigate().to(URL_LOGIN);
	}

	public void fillLoginForm(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage login(String username, String password) {
		this.fillLoginForm(username, password);
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isACtualPage() {
		return browser.getCurrentUrl().contains(URL_LOGIN);
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
	
	public boolean isLoginErrorMsgVisible() {
		return browser.getPageSource().contains("Usuário e senha inválidos");
	}

}
