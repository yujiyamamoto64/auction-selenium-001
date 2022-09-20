package br.com.alura.leilao.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LeilaoTest {

	@Nested
	@DisplayName("Dado um lance valido")
	class UnicoLanceTests {

		Leilao leilao = new Leilao("Macbook Pro 15");
		BigDecimal doisMil = new BigDecimal("2000.0");

		@Nested
		@DisplayName("Quando propoe lance")
		class AssertLanceNormal {

			@Test
			@DisplayName("Entao o lance eh aceito")
			public void deveReceberUmLance() {

				leilao.propoe(new Lance(new Usuario("Steve Jobs"), doisMil));

				assertEquals(1, leilao.getLances().size());
				assertEquals(doisMil, leilao.getLances().get(0).getValor());
			}
		}
	}
}
