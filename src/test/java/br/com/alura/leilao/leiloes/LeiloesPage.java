package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject{

	private static final String URL_REGISTER_LEILAO = "http://localhost:8080/leiloes/new";
	private static final Object URL__LEILOES = "http://localhost:8080/leiloes";

	public LeiloesPage(WebDriver browser) {
		super(browser);
	}

	public RegisterLeilaoPage loadForm() {
		this.browser.navigate().to(URL_REGISTER_LEILAO);
		return new RegisterLeilaoPage(browser);
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

	public boolean isActualPage() {
		return browser.getCurrentUrl().equals(URL__LEILOES);
	}
	
}
