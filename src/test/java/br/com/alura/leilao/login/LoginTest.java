package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage loginPage;
	
	@BeforeEach
	public void beforeEach() {
		this.loginPage = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.loginPage.quit();
	}

	@Test
	public void should_login_with_valid_data() {
		loginPage.fillLoginForm("fulano", "pass");
		loginPage.login();
		
		Assert.assertFalse(loginPage.isLoginPage());
		Assert.assertEquals("fulano", loginPage.getUserLoggedName());
	}
	
	@Test
	public void should_not_login_with_invalid_data() throws InterruptedException {
		loginPage.fillLoginForm("invalid", "321");
		loginPage.login();
		
		Assert.assertTrue(loginPage.isLoginErrorPage());
		Assert.assertNull(loginPage.getUserLoggedName());
		Assert.assertTrue(loginPage.containsText("Usuário e senha inválidos."));
	}
	
	@Test
	public void should_not_access_restrict_page_if_not_logged() {
		loginPage.goToLeiloesPage();
		
		Assert.assertTrue(loginPage.isLoginPage());
		Assert.assertFalse(loginPage.containsText("Dados do Leilão"));

	}
}
