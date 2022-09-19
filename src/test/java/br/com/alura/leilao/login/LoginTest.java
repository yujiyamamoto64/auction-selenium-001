package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.lances.LancesPage;

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
		loginPage.login("fulano", "pass");
		
		String usernameLogged = (String) loginPage.getUserLoggedName();
		Assert.assertEquals("fulano", usernameLogged);
		Assert.assertFalse(loginPage.isACtualPage());
	}
	
	@Test
	public void should_not_login_with_invalid_data() {
		loginPage.login("invalid", "321");
		
		Assert.assertNull(loginPage.getUserLoggedName());
		Assert.assertTrue(loginPage.isACtualPage());
		Assert.assertTrue(loginPage.isLoginErrorMsgVisible());
	}
	
	@Test
	public void should_not_access_restrict_page_if_not_logged() {
		LancesPage lancesPage = new LancesPage();
		
		Assert.assertFalse(lancesPage.isActualPage());
		Assert.assertFalse(lancesPage.isLeilaoTitleVisible());
		lancesPage.quit();
	}
}
