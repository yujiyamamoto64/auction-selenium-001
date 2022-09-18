package br.com.alura.leilao.leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
	}
	
}
