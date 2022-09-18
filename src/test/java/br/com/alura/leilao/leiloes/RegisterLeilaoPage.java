package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class RegisterLeilaoPage {

	private WebDriver browser;

	public RegisterLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}

	public void quit() {
		this.browser.quit();
	}
}
