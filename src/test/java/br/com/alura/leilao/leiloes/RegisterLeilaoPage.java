package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class RegisterLeilaoPage {
	
	private static final String URL_REGISTER_LEILAO = "http://localhost:8080/leiloes/new";

	private WebDriver browser;

	public RegisterLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}

	public void quit() {
		this.browser.quit();
	}

	public boolean isActualPage() {
		return browser.getCurrentUrl().equals(URL_REGISTER_LEILAO);
	}

	public boolean isValidationMsgVisible() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("não deve estar em branco")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
}
