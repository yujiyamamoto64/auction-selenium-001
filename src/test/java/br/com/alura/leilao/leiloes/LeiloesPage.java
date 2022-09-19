package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public LeiloesPage registerLeilao(String name, String value, String today) {
		this.browser.findElement(By.id("nome")).sendKeys(name);
		this.browser.findElement(By.id("valorInicial")).sendKeys(value);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(today);
		this.browser.findElement(By.id("button-submit")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isLeilaoRegistered(String name, String value, String today) {
		WebElement tableLine = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement columnName = tableLine.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement columnOpenDay = tableLine.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement columnValue = tableLine.findElement(By.cssSelector("td:nth-child(3)"));

		return columnName.getText().equals(name)
				&& columnOpenDay.getText().equals(today)
				&& columnValue.getText().equals(value);
	}

	

}
