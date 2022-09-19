package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage leiloesPage;
	private RegisterLeilaoPage registerPage;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage loginPage = new LoginPage();
		this.leiloesPage = loginPage.login("fulano", "pass");
		this.registerPage = leiloesPage.loadForm();
	}
	
	@AfterEach
	public void afterEach() {
		this.leiloesPage.quit();
		this.registerPage.quit();
	}

	@Test
	public void shold_register_leilao() {
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String name = "Leilao do dia " + today;
		String value = "500.00";
		
		this.leiloesPage = registerPage.registerLeilao(name, value, today);
		Assert.assertTrue(leiloesPage.isLeilaoRegistered(name, value, today));
	}
	
	@Test
	public void should_validate_leilao_register() {
		this.leiloesPage = registerPage.registerLeilao("", "", "");
		
		Assert.assertFalse(this.registerPage.isActualPage());
		Assert.assertTrue(this.leiloesPage.isActualPage());
		Assert.assertTrue(this.registerPage.isValidationMsgVisible());
	}
	
}
