package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class LeiloesPage {

	private static final String URL_REGISTER_LEILAO = "http://localhost:8080/leiloes/new";
	private WebDriver browser;

	public LeiloesPage(WebDriver browser) {
		this.browser = browser;
	}

	public void quit() {
		this.browser.quit();
	}

	public RegisterLeilaoPage loadForm() {
		this.browser.navigate().to(URL_REGISTER_LEILAO);
		return new RegisterLeilaoPage(browser);
	}

	

}
