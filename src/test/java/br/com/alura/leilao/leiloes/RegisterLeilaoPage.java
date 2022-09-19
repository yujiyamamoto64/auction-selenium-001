package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;

public class RegisterLeilaoPage extends PageObject{
	
	private static final String URL_REGISTER_LEILAO = "http://localhost:8080/leiloes/new";

	public RegisterLeilaoPage(WebDriver browser) {
		super(browser);
	}
	
	public LeiloesPage registerLeilao(String name, String value, String today) {
		this.browser.findElement(By.id("nome")).sendKeys(name);
		this.browser.findElement(By.id("valorInicial")).sendKeys(value);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(today);
		this.browser.findElement(By.id("button-submit")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isValidationMsgVisible() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("não deve estar em branco")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
	
	public boolean isActualPage() {
		return browser.getCurrentUrl().equals(URL_REGISTER_LEILAO);
	}
}
