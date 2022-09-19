package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage leiloesPage;
	
	@AfterEach
	public void afterEach() {
		this.leiloesPage.quit();
	}

	@Test
	public void shold_register_leilao() {
		LoginPage loginPage = new LoginPage();
		loginPage.fillLoginForm("fulano", "pass");
		this.leiloesPage = loginPage.login();
		leiloesPage.loadForm();
		RegisterLeilaoPage registerPage	= leiloesPage.loadForm();
		
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String name = "Leilao do dia " + today;
		String value = "500.00";
		
		this.leiloesPage = leiloesPage.registerLeilao(name, value, today);
		Assert.assertTrue(leiloesPage.isLeilaoRegistered(name, value, today));
	}
	
}
